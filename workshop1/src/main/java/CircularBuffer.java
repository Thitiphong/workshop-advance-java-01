

import java.util.ArrayList;
import java.util.List;


public class CircularBuffer {
    private String[] data;
    private int writePointer;
    private int readPointer;
    private int maxSize;
    private static final int DEFAULT_SIZE = 10;



    public static void main(String[] args) {
        CircularBuffer circularBuffer = new CircularBuffer(10);
        int size = circularBuffer.getSize();
        System.out.println(size);

    }


    public CircularBuffer(){
        new CircularBuffer(DEFAULT_SIZE);
    }

    public CircularBuffer(int size){
        this.maxSize = size;
        this.data = new String[size];
    }

    private int getSize() {
        return data.length;
    }

    private boolean isEmpty() {
        for ( String d: data) {
            if (d != null) {
                return false;
            }
        }
        return true;
    }

    private boolean isFull() {
        return getSize() == maxSize;
    }

    public String read() throws  EmptyBufferException{
        if (isEmpty()){
            throw new EmptyBufferException();
        }
        return data[readPointer++];
    }

    public void write(String input) throws FullBufferException {

        // TODO
    }
}
