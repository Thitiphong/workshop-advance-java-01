public class CircularBuffer {
    private String[] buffers;
    private int writePointer = 0;
    private boolean flag = false;
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
        buffers = new String[i];
        flag = true;
    }


    public CircularBuffer(int size){
        this.maxSize = size;
        this.buffers = new String[size];
    }

    public int getSize() {
        return buffers.length;
    }

    public boolean isEmpty() {

        // Big O = n
//        for ( String d: buffers) {
//            if (d != null) {
//                return false;
//            }
//        }


        return flag;


    }

    private boolean isFull() {
        return getSize() == maxSize;
    }

    public String read() throws  EmptyBufferException{
        if (isEmpty()){
            throw new EmptyBufferException();
        }
        return buffers[readPointer++];
    }

    public void write(String input) throws FullBufferException {

        // TODO
    }

}
