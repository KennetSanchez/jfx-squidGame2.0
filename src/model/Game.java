package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class Game {

    private ArrayList<Integer> obstaclesToPlace;
    private int[][] board;
    private int rows;
    private int columns;


    public Game(){
        columns=11;
        rows=11;
        board=new int[rows][columns];
        fillBoard();
        genericObstacle();
    }

    public void fillBoard(){
        int temp=1;
        for(int i=0;i<rows;i++){
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
}
