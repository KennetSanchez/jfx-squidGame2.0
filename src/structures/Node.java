package structures;


import java.util.ArrayList;

public class Node {
    private Node parent;
    private ArrayList<Node> children;
    private int value;

    public Node(int value){
        this.value=value;
        parent=null;
        children = new ArrayList<>();
    }

    public Node getParent() {
        return parent;
    }

    public void add(Node newNode){
        newNode.setParent(parent);
        children.add(newNode);
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getChildrenString(){
        String info = "";
        for(int i=0;i<children.size();i++){
            info += children.get(i).getValue()+" ";
        }
        return info;
    }
}
