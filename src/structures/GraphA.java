package structures;

import java.util.*;

public class GraphA<E extends Number> implements GraphInterface<E> {
    private int numberOfVertices;
    private E[][] adj;
    private BFTree bft;
    private Queue<Node> nodes;
    private Hashtable<Integer, String> bfsShortestPaths;
    private int[] parent;
    private Hashtable<Integer,String> dijkstraShortestPaths;

    GraphA(int v) {
        this.numberOfVertices = v;
        adj = (E[][]) new Number[v][v];
        fillMatrix();
        bft = new BFTree();
        nodes = new LinkedList<>();
        bfsShortestPaths = null;
        parent = null;
        dijkstraShortestPaths=null;
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
    }


    @Override
    public ArrayList<Integer> BFS(int start) {
        Node st = new Node(0);
        nodes.add(st);
        ArrayList<Integer> distances = new ArrayList<>();
        boolean[] visited = new boolean[numberOfVertices];
        Arrays.fill(visited, false);
        distances.add(0);
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
                }
            }
            nodes.poll();
        }
        bft.setRoot(st);
        bfsShortestPaths=bft.findShortestPaths();
        return distances;
    }

    @Override
    public void dijkstra(int src){
        dijkstra(adj,src);
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
        System.out.println("Inicio de caminos");
        for(int j=0;j<parent.length;j++){
            System.out.println(parent[j]);
        }
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
}
