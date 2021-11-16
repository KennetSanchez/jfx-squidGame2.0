package structures;

import java.util.ArrayList;

public interface GraphInterface<E> {
    public void addEdge(int v1, int v2,E edgeValue);
    public ArrayList<Integer> BFS(int start);
    public void dijkstra(int src);
}
