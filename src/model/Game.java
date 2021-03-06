package model;

import structures.*;

import java.io.Serializable;
import java.util.*;


public class Game implements Serializable {

    private ArrayList<Integer> obstaclesToPlace;
    private int[][] board;
    private int rows;
    private int columns;
    transient GraphA<Integer> graphA;
    transient GraphB<Integer> graphB;
    private String obstaclesString;
    private int[] random;
    private int actualPlayerNegativeScore;
    private int totalBoxesScore;
    private ArrayList<Player> bestScores;


    public Game() {
        bestScores=new ArrayList<>();
        initializeGame();
    }

    public void initializeGame(){
        totalBoxesScore=0;
        actualPlayerNegativeScore=0;
        columns=11;
        rows=11;
        board=new int[rows][columns];
        boardExample();
        obstaclesString = ",28,82,83,84,92,96,";
        graphA=new GraphA<>(123);
        graphB=new GraphB<>(123);
        random=new int[123];
        searchObstaclesPlace(15);
        generateRandoms();
    }

    public String giveBfs(boolean graph){
        if(graph){
             graphA.BFS(0);
             return graphA.getBfsShortestPaths().get(122);
        }
        else {
            graphB.BFS(0);
            return graphB.getShortestPaths().get(122);
        }
    }

    public String giveDijkstra(boolean graph){
        if(graph){
            graphA.dijkstra(0);
            graphA.findDijkstraShortestPaths();
            return graphA.getDijkstraShortestPaths().get(116);
        }
        else {
            graphB.dijkstra(0);
            graphB.findDijkstraShortestPaths();
            return graphB.getDijkstraShortestPaths().get(116);
        }
    }

    public void giveNegativeScore(int boardPosition){
        if(boardPosition>-5 && boardPosition < 122){
            actualPlayerNegativeScore+=random[boardPosition];
        }
    }

    public void generateRandoms(){
        random[0]=-1;
        for (int i=1;i<random.length-1;i++){
            if(obstaclesString.contains(","+i+",")){
                random[i]=-1;
            }
            else {
                int temp=(int)(Math.random()*99)+1;
                random[i]=temp;
                totalBoxesScore+=temp;
            }
        }
    }

    public boolean linkMatrix(boolean graph){
        if(graph){
            graphA = new GraphA<>(123);
            graphA.addEdgeDirected(0,6,random[6]);
            graphA.addEdgeDirected(116,122,0);
            graphA.addEdgeDirected(122,116,0);
            return linkMatrix(1,2);
        }
        else {
            graphB = new GraphB<>(123);
            graphB.addEdgeDirected(0,6,random[6]);
            graphB.addEdgeDirected(116,122,0);
            return linkMatrixB(1,2);
        }
    }

    public Hashtable<Integer, String> graphShortestPaths(boolean option){
        if(option){
            graphA.BFS(0);
            return graphA.getShortestPaths();
        }
        else{
            graphB.BFS(0);
            return graphB.getShortestPaths();
        }
    }

    public boolean linkMatrix(int origin, int destination){
        if(!(obstaclesString.contains(","+origin+","))){
            if (origin >= 1 && origin < 122) {
                if (origin % 11 != 0) {
                    if (origin <= 110) {
                        if (!(obstaclesString.contains(","+destination+","))) {
                            graphA.addEdgeDirected(origin, destination, random[destination]);
                            graphA.addEdgeDirected(destination, origin, random[origin]);

                        }
                        if (!(obstaclesString.contains(","+(origin+11)+","))) {
                            graphA.addEdgeDirected(origin, origin + 11, random[origin + 11]);
                            graphA.addEdgeDirected(origin + 11,origin, random[origin]);
                        }
                    } else {
                        if (!(obstaclesString.contains(","+(destination)+","))) {
                            graphA.addEdgeDirected(origin, destination, random[destination]);
                            graphA.addEdgeDirected(destination, origin, random[origin]);
                        }
                    }

                } else {
                    if (origin <= 110) {
                        if (!(obstaclesString.contains(","+(origin+11)+","))) {
                            graphA.addEdgeDirected(origin, origin + 11, random[origin + 11]);
                            graphA.addEdgeDirected(origin + 11,origin, random[origin]);
                        }
                    }
                }

            }
            else if(origin==122){
                return true;
            }
        }
        linkMatrix(origin+1,destination+1);
        return false;
    }

    public boolean linkMatrixB(int origin, int destination){
        if(!(obstaclesString.contains(","+origin+","))){
            if (origin >= 1 && origin < 122) {
                if (origin % 11 != 0) {
                    if (origin <= 110) {
                        if (!(obstaclesString.contains(","+destination+","))) {
                            graphB.addEdge(origin, destination, random[destination]);
                            graphB.addEdge(destination, origin, random[origin]);

                        }
                        if (!(obstaclesString.contains(","+(origin+11)+","))) {
                            graphB.addEdge(origin, origin + 11, random[origin + 11]);
                            graphB.addEdge(origin + 11,origin, random[origin]);
                        }
                    } else {
                        if (!(obstaclesString.contains(","+(destination)+","))) {
                            graphB.addEdge(origin, destination, random[destination]);
                            graphB.addEdge(destination, origin, random[origin]);
                        }
                    }

                } else {
                    if (origin <= 110) {
                        if (!(obstaclesString.contains(","+(origin+11)+","))) {
                            graphB.addEdge(origin, origin + 11, random[origin + 11]);
                            graphB.addEdge(origin + 11,origin, random[origin]);
                        }
                    }
                }

            }
            else if(origin==122){
                return true;
            }
        }
        linkMatrixB(origin+1,destination+1);
        return false;
    }
    public void boardExample(){
        int temp=1;
        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                board[i][j]=temp;
                temp++;
            }
        }
    }
    public void genericObstacle(){
        Integer[] temp={38,39,41,59,60,61,62,64,83};
        ArrayList<Integer> aux= new ArrayList<Integer>(Arrays.asList(temp));
        obstaclesToPlace=aux;
    }

    public void turnObstaclesToString(){
        obstaclesString=",";
        for(int i=0;i<obstaclesToPlace.size();i++){
                obstaclesString+=obstaclesToPlace.get(i)+",";
        }
    }

    public void placeObstacles(int n){

    }



    public void finishGame(String nickname,String time,int min,int secs){
        double totalTimeInSeconds = min+(secs/60);
        Player newPlayer = new Player(nickname,time,totalTimeInSeconds,actualPlayerNegativeScore,totalBoxesScore);
        bestScores.add(newPlayer);
        initializeGame();
    }

    public int countObstaclesInRange(int a, int b){
        int count=0;
            for(int i=a;i<=b;i++){
                if(a>=1&&a<=122){
                    if(obstaclesString.contains(","+(i)+",")){
                        count++;
                    }
                }
            }
            return count;
    }
    public boolean foundAPlace(int a){
        //God forgive me pls
        if(a>11&&a<111){
            if(!(obstaclesString.contains(","+a+","))){
                //Validation  down, left, right
                if(!(obstaclesString.contains(","+(a+1)+","))&&
                        !(obstaclesString.contains(","+(a-1)+","))
                        &&!(obstaclesString.contains(","+(a+11)+","))&&
                        !(obstaclesString.contains(","+(a-10)+","))&&
                        !(obstaclesString.contains(","+(a-11)+","))&&
                        !(obstaclesString.contains(","+(a-12)+","))&&
                        !(obstaclesString.contains(","+(a+10)+","))
                        &&!(obstaclesString.contains(","+(a+12)+","))){
                    return true;
                }

            }
        }
       return false;
    }

    public void searchObstaclesPlace(int obstacles){
            for (int i=0;i<=121;i=i+30){
                if(countObstaclesInRange(i,i+30)<6) {
                    for(int j=i;j<=i+30;j++){
                        if(countObstaclesInRange(i,i+30)<6) {
                            if (foundAPlace(j)) {
                                obstaclesString+=j+",";
                                double decision = Math.random();
                                if(decision<0.5){
                                    obstaclesString+=(j+1)+",";
                                }
                                else {
                                    obstaclesString+=(j-1)+",";
                                }

                            }
                        }
                    }
                }
            }

    }

    public void sortBestScores(){
        Collections.sort(bestScores);
    }

    public ArrayList<Integer> getObstaclesToPlace() {
        return obstaclesToPlace;
    }

    public int getTotalBoxesScore() {
        return totalBoxesScore;
    }

    public void setTotalBoxesScore(int totalBoxesScore) {
        this.totalBoxesScore = totalBoxesScore;
    }

    public ArrayList<Player> getBestScores() {
        return bestScores;
    }

    public void setBestScores(ArrayList<Player> bestScores) {
        this.bestScores = bestScores;
    }

    public void setObstaclesToPlace(ArrayList<Integer> obstaclesToPlace) {
        this.obstaclesToPlace = obstaclesToPlace;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public GraphA getGraphA() {
        return graphA;
    }

    public String getObstaclesString() {
        return obstaclesString;
    }

    public void setObstaclesString(String obstaclesString) {
        this.obstaclesString = obstaclesString;
    }

    public int[] getRandom() {
        return random;
    }

    public void setRandom(int[] random) {
        this.random = random;
    }

    public void setGraphA(GraphA<Integer> graphA) {
        this.graphA = graphA;
    }

    public GraphB<Integer> getGraphB() {
        return graphB;
    }

    public void setGraphB(GraphB<Integer> graphB) {
        this.graphB = graphB;
    }

    public int getActualPlayerNegativeScore() {
        return actualPlayerNegativeScore;
    }

    public void setActualPlayerNegativeScore(int actualPlayerNegativeScore) {
        this.actualPlayerNegativeScore = actualPlayerNegativeScore;
    }
}
