public class CircularBuffer {
    public static final int DEFAULT_SIZE = 10;
    // Variables
    private String[] buffers;
    private int writePointer;
    private int readPointer;

    // Constructor
    public CircularBuffer() {}

    // Methods
    // Public
    public void create() {
        create(DEFAULT_SIZE);
    }

    public void create(int size) {
        buffers = new String[size];
    }

    public int getSize() {
        return buffers.length;
    }

    public boolean isEmpty() {
        System.out.println("writePointer " + writePointer);
        System.out.println("readPointer " + readPointer);
        return writePointer - readPointer == 0;
    }

    public void write(String input) {
        if (writePointer < getSize()) {
            buffers[writePointer++] = input;
        }
        if (writePointer == getSize()){
            writePointer = 0;
        }
    }

    public String read() {
        String result;
        if (readPointer < getSize()) {
            result =  buffers[readPointer++];
        } else {
            throw new RuntimeException("unexpected");
        }
        if (readPointer == getSize()){
            readPointer = 0;
        }
        return result;
    }

    // Private
}