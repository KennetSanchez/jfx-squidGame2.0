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

    public GraphB(int v){
        numberOfVertices=v;
        adjList=new Hashtable<>();
        bft=new BFTree();
        shortestPaths=null;
        nodes=new LinkedList<>();
        parent = null;
        dijkstraShortestPaths=null;
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
}
