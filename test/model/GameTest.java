package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    private Game game = new Game();

    private void setupScene1(){
        //Manual board creation with no random obstacles
        int[] newRandom = new int[122];
        Arrays.fill(newRandom,9);
        newRandom[0]=0;
        newRandom[6]=1;
        newRandom[17]=2;
        newRandom[28]=3;
        newRandom[27]=4;
        newRandom[26]=5;
        newRandom[37]=6;
        newRandom[48]=7;
        newRandom[49]=8;
        newRandom[50]=9;
        newRandom[51]=10;
        newRandom[52]=11;
        newRandom[63]=12;
        newRandom[74]=13;
        newRandom[73]=14;
        newRandom[72]=15;
        newRandom[71]=16;
        newRandom[82]=17;
        newRandom[93]=18;
        newRandom[94]=19;
        newRandom[105]=20;
        newRandom[116]=21;
        game.setRandom(newRandom);
    }

    @Test
    public void correctCreationOfObstaclesTest() {
        setupScene1();
        game.linkMatrix(true);
        Hashtable<Integer, String> test = game.graphShortestPaths(true);
        assertEquals(test.get(38),null);
        assertEquals(test.get(39),null);
        assertEquals(test.get(41),null);
        assertEquals(test.get(59),null);
        assertEquals(test.get(60),null);
        assertEquals(test.get(61),null);
        assertEquals(test.get(62),null);
        assertEquals(test.get(64),null);
        assertEquals(test.get(83),null);


    }
}
