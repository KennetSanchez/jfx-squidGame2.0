package structures;

import java.util.*;

public class GraphB<E extends Number> implements GraphInterface<E>{
    private int numberOfVertices;
    private Hashtable<Integer,Vertex<E>> adjList;
    private Hashtable<Integer,String> shortestPaths;
    private BFTree bft;
    private Queue<Node> nodes;
    private int[] parent;
    private Hashtable<Integer,String> dijkstraShortestPaths;
    private ArrayList<Node> dfsForest;
    private String[] primEdges;
    private String[] kruskalEdges;
    private PriorityQueue<VertexUnion<E>> vertexUnionsPq;
    private int[] set;

    public GraphB(int v){
        numberOfVertices=v;
        adjList=new Hashtable<>();
        bft=new BFTree();
        shortestPaths=null;
        nodes=new LinkedList<>();
        parent = null;
        dijkstraShortestPaths=null;
        dfsForest=null;
        primEdges=null;
        vertexUnionsPq=new PriorityQueue<>();
    }

    @Override
    public void addEdge(int v1,int v2,E edgeValue){
        Vertex<E> vertex1 = new Vertex<>(v1,edgeValue);
        Vertex<E> vertex2 = new Vertex<>(v2,edgeValue);
        if(adjList.get(v1)==null){
            adjList.put(v1,vertex2);
        }
        else{
            adjList.get(v1).add(vertex2);
        }
        if(adjList.get(v2)==null){
            adjList.put(v2,vertex1);
        }
        else{
            adjList.get(v2).add(vertex1);
        }
        vertexUnionsPq.add(new VertexUnion<>(v1,v2,edgeValue));
    }

    @Override
    public void addEdgeDirected(int v1, int v2, E edgeValue) {
        Vertex<E> vertex2 = new Vertex<>(v2,edgeValue);
        if(adjList.get(v1)==null){
            adjList.put(v1,vertex2);
        }
        else{
            adjList.get(v1).add(vertex2);
        }
        vertexUnionsPq.add(new VertexUnion<>(v1,v2,edgeValue));
    }

    @Override
    public ArrayList<Integer> BFS(int start) {
        Node st = new Node(start);
        nodes.add(st);
        ArrayList<Integer> distances = new ArrayList<>();
        ArrayList<Integer> vertices = new ArrayList<>();
        boolean visited[] = new boolean[numberOfVertices];
        Arrays.fill(visited, false);
        distances.add(0);
        Queue<Integer> queue = new LinkedList<>();
        visited[start]=true;
        queue.add(start);

        int k = 0;
        int vis;

        while (!queue.isEmpty()) {
            vis = queue.poll();
            vertices.add(vis);
            k++;
            Vertex<E> i = adjList.get(vis);
            visited=allAdjacent(i,visited,queue,distances,k);
            nodes.poll();
        }
        bft.setRoot(st);
        shortestPaths=bft.findShortestPaths();
        return vertices;
    }

    @Override
    public void dijkstra(int src) {
        dijkstra(adjList,src);
    }

    public int[] dijkstra(Hashtable<Integer,Vertex<E>> graph,int src){
        parent = new int[numberOfVertices];
        int[] distance = new int[numberOfVertices];
        parent[0] = -1;
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src] = 0;

        PriorityQueue<Vertex<Float>> pq = new PriorityQueue<>(Comparator.comparingDouble(v -> v.getEdgeValue()));
        pq.add(new Vertex<>(src, (float) 0));
        while(!pq.isEmpty()){
            Vertex<Float> current = pq.poll();
            distance=allVertex(current, graph.get(current.getValue()),pq,distance);
            /*
            for (AdjListNode n : graph.get(current.getVertex())) {
                if (distance[current.getVertex()] + n.getWeight() < distance[n.getVertex()]) {
                    distance[n.getVertex()] = n.getWeight() + distance[current.getVertex()];
                    pq.add(new AdjListNode(n.getVertex(), distance[n.getVertex()]));
                }
                */
        }
        return distance;
    }

    public void findDijkstraShortestPaths(){
        dijkstraShortestPaths=new Hashtable<>();
        for(int i=0;i<numberOfVertices;i++){
            int pos = parent[i];
            StringBuilder input1 = new StringBuilder();
            input1.append(i+",");
            while(pos!=-1){
                input1.append(pos+",");
                pos=parent[pos];
            }
            input1.reverse();
            String info = input1.substring(1,input1.length());
            dijkstraShortestPaths.put(i,info);
        }
    }

    public float[][] floydWarshall(){
        float[][] dist = new float[numberOfVertices][numberOfVertices];
        int i = 0;
        int j = 0;
        int k = 0;
        for(int p=0;p<numberOfVertices;p++){
            Arrays.fill(dist[p], Float.MAX_VALUE);
        }
        dist=adjacencyMatrix(dist);
        for (k = 0; k < numberOfVertices; k++) {
            for (i = 0; i < numberOfVertices; i++) {
                for (j = 0; j < numberOfVertices; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }

            }
        }
        /*
        String info = "\n";
        for(int m=0;m<numberOfVertices;m++){
            for(int n=0;n<numberOfVertices;n++){
                info += (int)dist[m][n]+" ";
            }
            info+="\n";
        }
        System.out.println(info);
         */
        return dist;
    }

    @Override
    public void DFS() {
        dfsForest=new ArrayList<>();
        boolean visited[] = new boolean[numberOfVertices];
        for (int i = 0; i < numberOfVertices; ++i) {
            if (visited[i] == false) {
                Node newRoot = new Node(i);
                dfsForest.add(newRoot);
                DFSVisit(i, visited, newRoot);
            }
        }
    }

    @Override
    public void prim() {
        primEdges= new String[numberOfVertices-1];
        Boolean[] mstset = new Boolean[numberOfVertices];
        VertexAndKey[] e = new VertexAndKey[numberOfVertices];
        int[] parent = new int[numberOfVertices];

        for (int i = 0; i < numberOfVertices; i++){
            e[i] = new VertexAndKey();
        }
        for (int i = 0; i < numberOfVertices; i++) {
            mstset[i] = false;
            e[i].setKey(Float.MAX_VALUE);
            e[i].setVertex(i);
            parent[i] = -1;
        }

        mstset[0] = true;
        e[0].setKey(0);

        // Use TreeSet instead of PriorityQueue as the remove function of the PQ is O(n) in java.
        TreeSet<VertexAndKey> queue = new TreeSet<>(new comparator());

        for (int i = 0; i < numberOfVertices; i++) {
            queue.add(e[i]);
        }

        while (!queue.isEmpty()) {
            VertexAndKey node0 = queue.pollFirst();
            mstset[node0.getVertex()] = true;

            primAux(mstset,parent,node0.getVertex(),e,queue,adjList.get(node0.getVertex()));
        }
        for (int i = 1; i < numberOfVertices; i++) {
            primEdges[i-1]=parent[i]+ " - " + i;
        }
    }

    public void primAux(Boolean[] mstset,int[] parent,int value,VertexAndKey[] e,TreeSet<VertexAndKey> queue,Vertex<E> actual){
        if(actual!=null){
            if (mstset[actual.getValue()] == false) {
                if (e[actual.getValue()].getKey() > actual.getEdgeValue().floatValue()) {
                    queue.remove(e[actual.getValue()]);
                    e[actual.getValue()].setKey(actual.getEdgeValue().floatValue());
                    queue.add(e[actual.getValue()]);
                    parent[actual.getValue()] = value;
                }
            }
            primAux(mstset,parent,value,e,queue,actual.getNext());
        }
    }

    @Override
    public void kruskal() {
        makeSet(numberOfVertices);
        kruskalEdges=new String[numberOfVertices-1];
        int counter = 0;
        while(!vertexUnionsPq.isEmpty()){
            VertexUnion e = vertexUnionsPq.poll();
            if(!areEqual(e.getV1(), e.getV2())){
                kruskalEdges[counter] = e.getV1()+ " - " +e.getV2();
                union(e.getV1(), e.getV2());
                counter++;
            }
        }
    }

    private int findSet(int i){
        if(set[i]==i){
            return i;
        }
        else{
            set[i] = findSet(set[i]);
            return set[i];
        }
    }
    private void union(int i, int j){
        set[findSet(i)] = set[findSet(j)];
    }
    private boolean areEqual(int i, int j){
        return findSet(i) == findSet(j);
    }
    private void makeSet(int size) {
        set = new int[size];
        for (int i = 0; i < size; i++){
            set[i] = i;
        }
    }
    private int find(int i,int[] parent) {
        while (parent[i] != i)
            i = parent[i];
        return i;
    }

    private void DFSVisit(int v,boolean[] visited, Node prevNode) {
        visited[v] = true;
        Vertex<E> routeNode = adjList.get(v);
        DFSVisitAux(visited,prevNode,routeNode);
    }

    private void DFSVisitAux(boolean[] visited,Node prevNode,Vertex<E> routeNode){
        if(routeNode!=null){
            if(!visited[routeNode.getValue()]){
                Node nextNode = new Node(routeNode.getValue());
                prevNode.add(nextNode);
                DFSVisit(routeNode.getValue(),visited,nextNode);
            }
            DFSVisitAux(visited,prevNode,routeNode.getNext());
        }
    }



    public float[][] adjacencyMatrix(float[][] emptyMatrix){
        for(int i=0;i<numberOfVertices;i++){
            emptyMatrix[i][i]=0;
            emptyMatrix=adjacencyMatrix(emptyMatrix,i,adjList.get(i));
        }
        return emptyMatrix;
    }

    public float[][] adjacencyMatrix(float[][] emptyMatrix,int i,Vertex<E> v){
        if(v!=null){
            emptyMatrix[i][v.getValue()] =  v.getEdgeValue().floatValue();
            //System.out.println("["+i+"]"+" ["+v.getValue()+"] = "+v.getEdgeValue().floatValue());
            return adjacencyMatrix(emptyMatrix,i,v.getNext());
        }
        else {
            return emptyMatrix;
        }
    }

    public int[] allVertex(Vertex<Float> current,Vertex<E> n,PriorityQueue<Vertex<Float>> pq,int[] distance){
        if(n!=null){
            if(distance[current.getValue()] + n.getEdgeValue().intValue() < distance[n.getValue()]){
                distance[n.getValue()] = n.getEdgeValue().intValue() + distance[current.getValue()];
                parent[n.getValue()] = current.getValue();
                pq.add(new Vertex<>(n.getValue(), (float) distance[n.getValue()]));
            }
            return allVertex(current,n.getNext(),pq,distance);
        }
        else{
            return distance;
        }
    }

    public boolean[] allAdjacent(Vertex<E> v,boolean[] visited,Queue queue,ArrayList<Integer> vertices,int k){
        if(v!=null){
            int n = v.getValue();
            if (!visited[n]) {
                Node newNode = new Node(n);
                nodes.peek().add(newNode);
                nodes.add(newNode);
                visited[n] = true;
                queue.add(n);
                vertices.add(n);
            }
            return allAdjacent(v.getNext(),visited,queue,vertices,k);
        }
        else{
            return visited;
        }
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public void setNumberOfVertices(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
    }

    public Hashtable<Integer, Vertex<E>> getAdjList() {
        return adjList;
    }

    public void setAdjList(Hashtable<Integer, Vertex<E>> adjList) {
        this.adjList = adjList;
    }

    public Hashtable<Integer, String> getShortestPaths() {
        return shortestPaths;
    }

    public void setShortestPaths(Hashtable<Integer, String> shortestPaths) {
        this.shortestPaths = shortestPaths;
    }

    public BFTree getBft() {
        return bft;
    }

    public void setBft(BFTree bft) {
        this.bft = bft;
    }

    public Queue<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Queue<Node> nodes) {
        this.nodes = nodes;
    }

    public int[] getParent() {
        return parent;
    }

    public void setParent(int[] parent) {
        this.parent = parent;
    }

    public Hashtable<Integer, String> getDijkstraShortestPaths() {
        return dijkstraShortestPaths;
    }

    public void setDijkstraShortestPaths(Hashtable<Integer, String> dijkstraShortestPaths) {
        this.dijkstraShortestPaths = dijkstraShortestPaths;
    }

    public ArrayList<Node> getDfsForest() {
        return dfsForest;
    }

    public void setDfsForest(ArrayList<Node> dfsForest) {
        this.dfsForest = dfsForest;
    }

    public String[] getPrimEdges() {
        return primEdges;
    }

    public void setPrimEdges(String[] primEdges) {
        this.primEdges = primEdges;
    }

    public String[] getKruskalEdges() {
        return kruskalEdges;
    }

    public void setKruskalEdges(String[] kruskalEdges) {
        this.kruskalEdges = kruskalEdges;
    }

    public PriorityQueue<VertexUnion<E>> getVertexUnionsPq() {
        return vertexUnionsPq;
    }

    public void setVertexUnionsPq(PriorityQueue<VertexUnion<E>> vertexUnionsPq) {
        this.vertexUnionsPq = vertexUnionsPq;
    }

    public int[] getSet() {
        return set;
    }

    public void setSet(int[] set) {
        this.set = set;
    }
}
