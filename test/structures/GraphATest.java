package structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphATest {
    private GraphA<Integer> exampleGraph;

    private void setupScene1(){
        exampleGraph=new GraphA<>(5);
    }


    //Esta no es una prueba real jaja, es donde debugeo mis cositas uwu
    @Test
    public void addEdgeTest(){
        setupScene1();
        exampleGraph.addEdge(0,1,15); //1->2
        exampleGraph.addEdge(0,2,11);//1->3
        exampleGraph.addEdge(1,2,12);//2->3
        exampleGraph.addEdge(1,3,14);//2->4
        exampleGraph.addEdge(1,4,1);//2->5
        exampleGraph.addEdge(2,3,3);//3->4
        exampleGraph.addEdge(3,4,2);//4->5
        System.out.println("BFS");
        System.out.println(exampleGraph.BFS(2));
        System.out.println(exampleGraph.getShortestPaths().get(0));
        System.out.println(exampleGraph.getShortestPaths().get(1));
        System.out.println(exampleGraph.getShortestPaths().get(2));
        System.out.println(exampleGraph.getShortestPaths().get(3));
        System.out.println(exampleGraph.getShortestPaths().get(4));
        System.out.println("BFS");
        exampleGraph.dijkstra(0);
        exampleGraph.findDijkstraShortestPaths();
        System.out.println("Inicio rutas completas");
        System.out.println(exampleGraph.getDijkstraShortestPaths().get(0));
        System.out.println(exampleGraph.getDijkstraShortestPaths().get(1));
        System.out.println(exampleGraph.getDijkstraShortestPaths().get(2));
        System.out.println(exampleGraph.getDijkstraShortestPaths().get(3));
        System.out.println(exampleGraph.getDijkstraShortestPaths().get(4));
        System.out.println(exampleGraph.floydWarshall());
        System.out.println("prim");
        exampleGraph.prim();
        System.out.println(exampleGraph.getPrimEdges()[0]);
        System.out.println(exampleGraph.getPrimEdges()[1]);
        System.out.println(exampleGraph.getPrimEdges()[2]);
        System.out.println(exampleGraph.getPrimEdges()[3]);
        System.out.println("kruskal");
        exampleGraph.kruskal();
        System.out.println(exampleGraph.getKruskalEdges()[0]);
        System.out.println(exampleGraph.getKruskalEdges()[1]);
        System.out.println(exampleGraph.getKruskalEdges()[2]);
        System.out.println(exampleGraph.getKruskalEdges()[3]);
    }

    //Otro test que no sirve para la entrega jaja, hay que borrar esto cuando ya esten las pruebas reales
    @Test
    public void genericTest(){
        setupScene1();
        exampleGraph.addEdge(1,4,0);
        exampleGraph.addEdge(1,3,0);
        exampleGraph.addEdge(0,2,0);
        exampleGraph.DFS();
        System.out.println("1st Tree");
        System.out.println(exampleGraph.getDfsForest().get(0).getValue());
        System.out.println(exampleGraph.getDfsForest().get(0).getChildren().get(0).getValue());
        System.out.println("2nd tree");
        System.out.println(exampleGraph.getDfsForest().get(1).getValue());
        System.out.println(exampleGraph.getDfsForest().get(1).getChildren().get(0).getValue());
        System.out.println(exampleGraph.getDfsForest().get(1).getChildren().get(1).getValue());
    }
}
