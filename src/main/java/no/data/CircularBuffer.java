package no.data;

public class CircularBuffer {

    private final Object[] buffer;
    private int readCursor = 0;
    private int writeCursor = 0;

    public CircularBuffer(int size) {
        buffer = new Object[size];
    }

    public boolean offer(int value) {
        // Check if it's possible to write
        // a new value
        if(buffer[writeCursor] != null){
            return false;
        }

        buffer[writeCursor] = value;
        writeCursor = next(writeCursor);
        return true;
    }

    public Object poll() {
        Object value = buffer[readCursor];
        if( value != null ){
            buffer[readCursor] = null;
            readCursor = next(readCursor);
        }
        return value;
    }

    // Returns the next cursor position
    // in a circular manner
    private int next(int index) {
        return (index + 1) % buffer.length;
    }
}