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


    public Game(){
        columns=11;
        rows=11;
        board=new int[rows][columns];
        boardExample();
        fillBoard();
        genericObstacle();
        graphA=new GraphA(123);
        obstaclesString="";
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

    public boolean linkMatrix(int origin, int destination, int weight){
        origin=0;
        destination=1;
        int random=(int)(Math.random()*99)+1;
        if(origin==0){
            graphA.addEdgeDirected(0,6,random);
        }
        else if(origin==117){
            graphA.addEdgeDirected(117,123,random);
        }
        else if(origin>=1&&origin<122){
            if(origin%11!=0){
                if(origin<=110){
                    if(!((obstaclesString.contains(destination+","))||obstaclesString.contains(0+""+destination+","))){
                        graphA.addEdgeDirected(origin,destination,random);
                    }
                    if (!(obstaclesString.contains((origin+11)+","))){
                        random=(int)(Math.random()*99)+1;
                        graphA.addEdgeDirected(origin,origin+11,random);
                    }
                }
                else{
                    if(!((obstaclesString.contains(destination+","))||obstaclesString.contains(0+""+destination+","))){
                        graphA.addEdgeDirected(origin,destination,random);
                    }
                }

            }
            else{

            }

        }
        linkMatrix(origin+1,destination+1,random);
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
