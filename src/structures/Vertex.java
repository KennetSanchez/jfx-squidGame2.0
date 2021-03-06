package structures;

import java.util.ArrayList;
import java.util.ListIterator;

public class Vertex<E> {
    private int value;
    private E edgeValue;
    private Vertex<E> next;

    public Vertex(int value, E edgeValue) {
        this.value = value;
        this.edgeValue = edgeValue;
    }

    public void add(Vertex<E> next){
        add(next,this);
    }

    public void add(Vertex<E> next,Vertex<E> root){
        if(root.getNext()==null){
            root.setNext(next);
        }
        else{
            add(next,root.getNext());
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public E getEdgeValue() {
        return edgeValue;
    }

    public void setEdgeValue(E edgeValue) {
        this.edgeValue = edgeValue;
    }

    public Vertex<E> getNext() {
        return next;
    }

    public void setNext(Vertex<E> next) {
        this.next = next;
    }
}
