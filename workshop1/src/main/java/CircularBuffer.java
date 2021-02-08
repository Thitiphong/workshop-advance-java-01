

import java.util.ArrayList;
import java.util.List;


public class CircularBuffer {
    private String[] data;
    private int writePointer = 0;
    private int readPointer = 0;
    private int maxSize;
    private static final int DEFAULT_SIZE = 10;

    public CircularBuffer(){}

    public static void main(String[] args) {
        CircularBuffer circularBuffer = new CircularBuffer();
        circularBuffer.create();
        int size = circularBuffer.getSize();
        System.out.println(size);
    }

    public void create(){
        create(DEFAULT_SIZE);
    }


    public void create(int i) {
        data = new String[i];
    }


    public CircularBuffer(int size){
        this.maxSize = size;
        this.data = new String[size];
    }

    public int getSize() {
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
