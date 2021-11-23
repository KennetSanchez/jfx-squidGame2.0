package structures;

public class VertexUnion<E extends Number> implements Comparable<VertexUnion>{
    int v1;
    int v2;
    E weight;

    VertexUnion(int v1,int v2,E weight){
        this.v1=v1;
        this.v2=v2;
        this.weight=weight;
    }

    public int getV1() {
        return v1;
    }

    public void setV1(int v1) {
        this.v1 = v1;
    }

    public E getWeight() {
        return weight;
    }

    public void setWeight(E weight) {
        this.weight = weight;
    }

    public int getV2() {
        return v2;
    }

    public void setV2(int v2) {
        this.v2 = v2;
    }

    @Override
    public int compareTo(VertexUnion o) {
        if(this.weight.floatValue() < o.getWeight().floatValue()){
            return -1;
        }
        else if(this.weight==o.weight){
            return 0;
        }
        return 1;
    }
}
