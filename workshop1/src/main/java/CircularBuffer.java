

import java.util.ArrayList;
import java.util.List;


public class CircularBuffer {
    private List<String> data;
    private int writePointer;
    private int readPointer;
    private int maxSize;
    private static final int DEFAULT_SIZE = 10;



    public static void main(String[] args) {

    }

    public CircularBuffer(){
        this.maxSize = DEFAULT_SIZE;
        this.data = new ArrayList<>(DEFAULT_SIZE);
    }

    private int getSize() {
        return data.size();
    }

    private boolean isEmpty() {
        return data.isEmpty();
    }

    private boolean isFull() {
        return getSize() == maxSize;
    }
}
