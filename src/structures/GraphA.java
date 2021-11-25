package structures;

import java.util.*;

public class GraphA<E extends Number> implements GraphInterface<E> {
    private int numberOfVertices;
    private E adj[][];
    private BFTree bft;
    private Queue<Node> nodes;
    private Hashtable<Integer, String> bfsShortestPaths;
    private int[] parent;
    private Hashtable<Integer,String> dijkstraShortestPaths;
    private ArrayList<Node> dfsForest;
    private String[] primEdges;
    private String[] kruskalEdges;
    private PriorityQueue<VertexUnion<E>> vertexUnionsPq;
    private int[] set;

    public GraphA(int v) {
        this.numberOfVertices = v;
        adj = (E[][]) new Number[v][v];
        fillMatrix();
        bft = new BFTree();
        nodes = new LinkedList<>();
        bfsShortestPaths = null;
        parent = null;
        dijkstraShortestPaths=null;
        dfsForest=null;
        primEdges=null;
        vertexUnionsPq=new PriorityQueue<>();
    }

    private void fillMatrix() {
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                adj[i][j] = null;
            }
        }
    }

    public float EValue(E value){
        if(value==null){
            return 0;
        }
        return value.floatValue();
    }

    @Override
    public void addEdge(int v1, int v2, E edgeValue) {
        adj[v1][v2] = edgeValue;
        adj[v2][v1] = edgeValue;
        vertexUnionsPq.add(new VertexUnion<>(v1,v2,edgeValue));
    }

    @Override
    public void addEdgeDirected(int v1, int v2, E edgeValue) {
        adj[v1][v2] = edgeValue;
        vertexUnionsPq.add(new VertexUnion<>(v1,v2,edgeValue));
    }


    @Override
    public ArrayList<Integer> BFS(int start) {
        Node st = new Node(start);
        nodes.add(st);
        ArrayList<Integer> distances = new ArrayList<>();
        ArrayList<Integer> vertices = new ArrayList<>();
        boolean[] visited = new boolean[numberOfVertices];
        Arrays.fill(visited, false);
        distances.add(0);
        vertices.add(start);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int k = 0;
        visited[start] = true;

        int vis;
        while (!q.isEmpty()) {
            vis = q.poll();
            k++;
            for (int i = 0; i < numberOfVertices; i++) {
                if (adj[vis][i] != null && (!visited[i])) {
                    Node newNode = new Node(i);
                    nodes.peek().add(newNode);
                    nodes.add(newNode);
                    q.add(i);
                    visited[i] = true;
                    distances.add(distances.get(k - 1) + 1);
                    vertices.add(i);
                }
            }
            nodes.poll();
        }
        bft.setRoot(st);
        bfsShortestPaths=bft.findShortestPaths();
        return vertices;
    }

    @Override
    public void dijkstra(int src){
        dijkstra(adj,src);
    }

    @Override
    public float[][] floydWarshall() {
        float[][] dist = new float[numberOfVertices][numberOfVertices];
        int i = 0;
        int j = 0;
        int k = 0;

        for (i = 0; i < numberOfVertices; i++){
            for (j = 0; j < numberOfVertices; j++){
                if(i==j){
                    dist[i][j]=0;
                }
                else{
                    float newN;
                    if(adj[i][j] != null){
                        newN = adj[i][j].floatValue();
                    }
                    else{
                        newN = Float.MAX_VALUE;
                    }
                    dist[i][j] = newN;
                }
            }
        }

        for (k = 0; k < numberOfVertices; k++) {
            for (i = 0; i < numberOfVertices; i++) {
                for (j = 0; j < numberOfVertices; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }

            }
        }

        String info = "\n";
        for(int m=0;m<numberOfVertices;m++){
            for(int n=0;n<numberOfVertices;n++){
                info += (int)dist[m][n]+" ";
            }
            info+="\n";
        }
        //System.out.println(info);

        return dist;
    }

    @Override
    public void DFS() {
        dfsForest=new ArrayList<>();
        boolean visited[] = new boolean[numberOfVertices];
        for (int i = 0; i < numberOfVertices; ++i){
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
        TreeSet<VertexAndKey> queue = new TreeSet<>(new comparator());

        for (int i = 0; i < numberOfVertices; i++) {
            queue.add(e[i]);
        }

        while (!queue.isEmpty()) {
            VertexAndKey node0 = queue.pollFirst();
            mstset[node0.getVertex()] = true;
            int F = node0.getVertex();
            for(int i=1;i<numberOfVertices;i++){
                if (mstset[i] == false && adj[F][i]!=null) {
                    if (e[i].getKey() > adj[F][i].floatValue()) {
                        queue.remove(e[i]);
                        e[i].setKey(adj[F][i].floatValue());
                        queue.add(e[i]);
                        parent[i] = F;
                    }
                }
            }
        }
        for (int i = 1; i < numberOfVertices; i++) {
            primEdges[i-1]=parent[i]+ " - " + i;
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

    public void union1(int i, int j,int[] parent)
    {
        int a = find(i,parent);
        int b = find(j,parent);
        parent[a] = b;
    }

    private int find(int i,int[] parent) {
        while (parent[i] != i)
            i = parent[i];
        return i;
    }

    public void DFSVisit(int v,boolean[] visited,Node prevNode){
        visited[v] = true;
        for (int i = 0; i < numberOfVertices; i++) {
            if (adj[v][i] != null && (!visited[i])) {
                Node newNode = new Node(i);
                prevNode.add(newNode);
                DFSVisit(i, visited,newNode);
            }
        }
    }

    public void dijkstra(E[][] graph,int src) {
        parent = new int[numberOfVertices];
        parent[0]=-1;
        float[] dist = new float[numberOfVertices];
        boolean sptSet[] = new boolean[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            dist[i] = Float.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] = 0;
        for (int count = 0; count < numberOfVertices - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < numberOfVertices; v++){
                if (!sptSet[v] && EValue(graph[u][v]) != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + EValue(graph[u][v]) < dist[v]){
                    parent[v] = u;
                    dist[v] = dist[u] + EValue(adj[u][v]);
                }
            }
        }
        /*
        System.out.println("Inicio de caminos");
        for(int j=0;j<parent.length;j++){
            System.out.println(parent[j]);
        }
         */
    }

    public int minDistance(float[] dist,boolean[] sptSet){
        float min = Float.MAX_VALUE;
        int min_index = -1;
        for (int v = 0; v < numberOfVertices; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
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

    public E getElementAdj(int i,int j){
        return adj[i][j];
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public void setNumberOfVertices(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
    }

    public E[][] getAdj() {
        return adj;
    }

    public void setAdj(E[][] adj) {
        this.adj = adj;
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

    public Hashtable<Integer, String> getShortestPaths() {
        return bfsShortestPaths;
    }

    public void setShortestPaths(Hashtable<Integer, String> bfsShortestPaths) {
        this.bfsShortestPaths = bfsShortestPaths;
    }

    public Hashtable<Integer, String> getBfsShortestPaths() {
        return bfsShortestPaths;
    }

    public void setBfsShortestPaths(Hashtable<Integer, String> bfsShortestPaths) {
        this.bfsShortestPaths = bfsShortestPaths;
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
}
