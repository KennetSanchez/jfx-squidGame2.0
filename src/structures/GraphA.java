package structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphA<E>{
    private int numberOfVertices;
    private E[][] adj;

    GraphA(int v) {
        this.numberOfVertices = v;
        adj = (E[][])new Object[v][v];
        fillMatrix();
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
       ArrayList<Integer> distances = new ArrayList();
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
            for(int i = 0; i < numberOfVertices; i++) {
                if (adj[vis][i] != null && (!visited[i])) {

                    q.add(i);
                    visited[i] = true;
                    distances.add(distances.get(k-1)+1);
                }
            }
        }
        return distances;
    }

}
