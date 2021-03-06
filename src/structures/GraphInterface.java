package structures;

import java.util.ArrayList;

public interface GraphInterface<E extends Number> {
    public void addEdge(int v1, int v2,E edgeValue);
    public ArrayList<Integer> BFS(int start);
    public void dijkstra(int src);
    public float[][] floydWarshall();
    public void DFS();
    public void prim();
    public void kruskal();
    public void addEdgeDirected(int v1, int v2,E edgeValue);
}
