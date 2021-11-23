package model;

import structures.*;

import java.util.ArrayList;
import java.util.Arrays;


public class Game {

    private ArrayList<Integer> obstaclesToPlace;
    private int[][] board;
    private int rows;
    private int columns;
    private GraphA graphA;
    private String obstaclesString;
    private int[] random;


    public Game(){
        columns=11;
        rows=11;
        board=new int[rows][columns];
        boardExample();
        fillBoard();
        genericObstacle();
        graphA=new GraphA(123);
        obstaclesString="";
        random=new int[123];
        generateRandoms();
    }


    public void fillBoard(){
       for (int i=0;i<rows;i++){
           for (int j=0;j<columns;j++){
               if(board[i][j]<10){
                   if(!(obstaclesString.contains(0+""+board[i][j]+","))){
                       graphA.addEdge(i,j,(Math.random()*99)+1);
                       //UpperVertex
                       if(i!=10&&(obstaclesString.contains(0+""+board[i+1][j]+",")||obstaclesString.contains(board[i+1][j]+","))){
                           graphA.addEdge((i+1),i,(Math.random()*99)+1);
                       }
                       //LeftVertex
                       if(j!=0&&(obstaclesString.contains(0+""+board[i][j-1]+",")||obstaclesString.contains(board[i][j-1]+","))){
                           graphA.addEdge(i,(j-1),(Math.random()*99)+1);
                       }
                       //RightVertex
                       if(j!=10&&(obstaclesString.contains(0+""+board[i][j+1]+",")||obstaclesString.contains(board[i][j+1]+","))){
                            graphA.addEdge(i,(j+1),(Math.random()*99)+1);
                       }
                   }
               }
               else{
                   if(!(obstaclesString.contains(board[i][j]+","))){
                       graphA.addEdge(i,j,(Math.random()*99)+1);
                       //Upper Vertex
                       if(i!=10&&(obstaclesString.contains(0+""+board[i+1][j]+",")||obstaclesString.contains(board[i+1][j]+","))){
                           graphA.addEdge((i+1),i,(Math.random()*99)+1);
                       }
                       //Left Vertex
                       if(j!=0&&(obstaclesString.contains(0+""+board[i][j-1]+",")||obstaclesString.contains(board[i][j-1]+","))){
                           graphA.addEdge(i,(j-1),(Math.random()*99)+1);
                       }
                       //Right Vertex
                       if(j!=10&&(obstaclesString.contains(0+""+board[i][j+1]+",")||obstaclesString.contains(board[i][j+1]+","))){
                           graphA.addEdge(i,(j+1),(Math.random()*99)+1);
                       }
                   }
               }

               }
           }
    }

    public void generateRandoms(){
        for (int i=1;i<random.length-1;i++){
            int temp=(int)(Math.random()*99)+1;
            random[i]=temp;
        }
    }

    public boolean linkMatrix(int origin, int destination){
        origin=0;
        destination=1;
        if(origin==0){
            graphA.addEdgeDirected(0,6,random[6]);
        }
            else if(origin==117){
                graphA.addEdgeDirected(117,123,0);
            }
        if(!((obstaclesString.contains(origin+",")||obstaclesString.contains(0+""+origin+",")))){
            if (origin >= 1 && origin < 122) {
                if (origin % 11 != 0) {
                    if (origin <= 110) {
                        if (!((obstaclesString.contains(destination + ",")) || obstaclesString.contains(0 + "" + destination + ","))) {
                            graphA.addEdgeDirected(origin, destination, random[destination]);
                            graphA.addEdgeDirected(destination, origin, random[origin]);

                        }
                        if (!(obstaclesString.contains((origin + 11) + ","))) {
                            graphA.addEdgeDirected(origin, origin + 11, random[origin + 11]);
                        }
                    } else {
                        if (!((obstaclesString.contains(destination + ",")) || obstaclesString.contains(0 + "" + destination + ","))) {
                            graphA.addEdgeDirected(origin, destination, random[destination]);
                            graphA.addEdgeDirected(destination, origin, random[origin]);
                        }
                    }

                } else {
                    if (origin <= 110) {
                        if (!(obstaclesString.contains((origin + 11) + ","))) {
                            graphA.addEdgeDirected(origin, origin + 11, random[origin + 11]);
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
        for(int i=0;i<obstaclesToPlace.size();i++){
            if(obstaclesToPlace.get(i)<10){
                obstaclesString+=0+""+obstaclesToPlace.get(i)+",";
            }
            else{
                obstaclesString+=obstaclesToPlace.get(i)+",";
            }

        }
    }

    public void placeObstacles(int n){

    }

    public void searchObstaclesPlace(){

    }
}
