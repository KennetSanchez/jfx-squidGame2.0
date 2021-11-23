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

    public GraphB(int v){
        numberOfVertices=v;
        adjList=new Hashtable<>();
        bft=new BFTree();
        shortestPaths=null;
        nodes=new LinkedList<>();
        parent = null;
        dijkstraShortestPaths=null;
        dfsForest=null;
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
    }

    @Override
    public ArrayList<Integer> BFS(int start) {
        Node st = new Node(start);
        nodes.add(st);
        ArrayList<Integer> distances = new ArrayList<>();
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
            System.out.print(vis+" ");
            k++;
            Vertex<E> i = adjList.get(vis);
            visited=allAdjacent(i,visited,queue,distances,k);
            nodes.poll();
        }
        bft.setRoot(st);
        shortestPaths=bft.findShortestPaths();
        return distances;
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

            for (Vertex iterator : adjList.get(node0.getVertex())) {

                // If V is in queue
                if (mstset[iterator.dest] == false) {
                    // If the key value of the adjacent vertex is
                    // more than the extracted key
                    // update the key value of adjacent vertex
                    // to update first remove and add the updated vertex
                    if (e[iterator.dest].key > iterator.weight) {
                        queue.remove(e[iterator.dest]);
                        e[iterator.dest].key = iterator.weight;
                        queue.add(e[iterator.dest]);
                        parent[iterator.dest] = node0.vertex;
                    }
                }
            }
        }

        // Prints the vertex pair of mst
        for (int o = 1; o < graph.V; o++)
            System.out.println(parent[o] + " "
                    + "-"
                    + " " + o);
    }

    public void primAux(VertexAndKey[] e,TreeSet<VertexAndKey> queue,Vertex<E> actual){

    }

    @Override
    public void kruskal() {

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
            System.out.println("["+i+"]"+" ["+v.getValue()+"] = "+v.getEdgeValue().floatValue());
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

    public boolean[] allAdjacent(Vertex<E> v,boolean[] visited,Queue queue,ArrayList<Integer> distances,int k){
        if(v!=null){
            int n = v.getValue();
            if (!visited[n]) {
                Node newNode = new Node(n);
                nodes.peek().add(newNode);
                nodes.add(newNode);
                visited[n] = true;
                queue.add(n);
                distances.add(distances.get(k - 1) + 1);
            }
            return allAdjacent(v.getNext(),visited,queue,distances,k);
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
}

class VertexAndKey{
    private int vertex;
    private float key;
    VertexAndKey(){
    }

    public int getVertex() {
        return vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    public float getKey() {
        return key;
    }

    public void setKey(float key) {
        this.key = key;
    }
}

class comparator implements Comparator<VertexAndKey> {

    @Override
    public int compare(VertexAndKey vak1, VertexAndKey vak2)
    {
        return (int) (vak1.getKey() - vak2.getKey());
    }
}
