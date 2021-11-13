package structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphA<E>{
    private int numberOfVertices;
    private E[][] adj;
    private BFTree bft;
    private Queue<Node> nodes;

    GraphA(int v) {
        this.numberOfVertices = v;
        adj = (E[][])new Object[v][v];
        fillMatrix();
        bft=new BFTree();
        nodes = new LinkedList<>();
    }

    private void fillMatrix(){
        for(int i=0;i<numberOfVertices;i++){
            for(int j=0;j<numberOfVertices;j++) {
                adj[i][j] = null;
            }
        }
    }

    public void addEdge(int v1, int v2,E edgeValue) {
        adj[v1][v2] = edgeValue;
        adj[v2][v1] = edgeValue;
    }

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
            //System.out.print("\n" + vis + "=");

            k++;
            for (int i = 0; i < numberOfVertices; i++) {
                if (adj[vis][i] != null && (!visited[i])) {
                    Node newNode = new Node(i);
                    nodes.peek().add(newNode);
                    nodes.add(newNode);
                    q.add(i);
                    visited[i] = true;
                    //System.out.print("-" + adj[vis][i] + "->" + i + " ");
                    distances.add(distances.get(k - 1) + 1);
                }
            }
            nodes.poll();
        }
        bft.setRoot(st);
        return distances;
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
}
