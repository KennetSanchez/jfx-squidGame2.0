package structures;

import java.util.Comparator;

public class VertexAndKey {
        private int vertex;
        private float key;
        VertexAndKey(){
        }

        public int getVertex() {
            return vertex;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        public float getKey() {
            return key;
        }

        public void setKey(float key) {
            this.key = key;
        }
    }

    class comparator implements Comparator<structures.VertexAndKey> {

        @Override
        public int compare(structures.VertexAndKey vak1, structures.VertexAndKey vak2)
        {
            return (int) (vak1.getKey() - vak2.getKey());
        }
    }
