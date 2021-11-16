package structures;

import java.util.*;

public class GraphB<E> implements GraphInterface<E>{
    private int numberOfVertices;
    private Hashtable<Integer,Vertex<E>> adjList;
    private Hashtable<Integer,String> shortestPaths;
    private BFTree bft;
    private Queue<Node> nodes;

    public GraphB(int v){
        numberOfVertices=v;
        adjList=new Hashtable<>();
        bft=new BFTree();
        shortestPaths=null;
        nodes=new LinkedList<>();
    }

    @Override
    public void addEdge(int v1,int v2,E edgeValue){
        Vertex<E> vertex1 = new Vertex<>(v1,edgeValue);
        Vertex<E> vertex2 = new Vertex<>(v2,edgeValue);
        if(adjList.get(v1)==null){
            adjList.put(v1,vertex2);
        }
        else{
            adjList.get(v1).setNext(vertex2);
        }
        if(adjList.get(v2)==null){
            adjList.put(v2,vertex1);
        }
        else{
            adjList.get(v2).setNext(vertex1);
        }
    }

    @Override
    public ArrayList<Integer> BFS(int start) {
        Node st = new Node(0);
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
}
