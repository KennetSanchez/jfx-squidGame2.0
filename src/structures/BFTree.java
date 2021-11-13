package structures;

import java.util.ArrayList;
import java.util.Hashtable;

public class BFTree {
    private Node root;
    private Hashtable<Character,String> shortestPaths;

    public BFTree(){
        root=null;
    }

    public void setRoot(Node root){
        this.root=root;
    }

    public void findShortestPaths(){
        findShortestPaths(root);
    }

    public void findShortestPaths(Node init){
        if(init!=null){
        }
    }

    public Node getRoot(){
        return root;
    }


}
