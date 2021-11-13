package structures;

import java.util.ArrayList;
import java.util.Hashtable;

public class BFTree {
    private Node root;

    private String aux;

    public BFTree(){
        root=null;
        aux="";
    }

    public void setRoot(Node root){
        this.root=root;
        aux=root.getValue()+",";
    }

    public Hashtable<Integer,String> findShortestPaths(){
        Hashtable<Integer,String> shortestPaths=new Hashtable<>();
        shortestPaths.put(0,"");
        findShortestPaths(root,shortestPaths);
        return shortestPaths;
    }

    public void findShortestPaths(Node init,Hashtable<Integer,String> shortestPaths){
        if(!init.getChildren().isEmpty()){
            ArrayList<Node> aL = init.getChildren();
            for(int i=0;i<aL.size();i++){
                int actual = aL.get(i).getValue();
                aux+=actual+",";
                //System.out.println("aux es: "+aux);
                shortestPaths.put(actual,aux.substring(0,aux.length()-1));
                findShortestPaths(aL.get(i),shortestPaths);
            }
            aux=aux.substring(0,aux.length()-2);
        }
        else{
            aux=aux.substring(0,aux.length()-2);
        }
    }

    public Node getRoot(){
        return root;
    }

    public String getAux(){
        return aux;
    }

    public void setAux(String aux) {
        this.aux = aux;
    }
}
