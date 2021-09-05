package no.data;

public class CircularBuffer implements Buffer {

    private final Object[] buffer;
    private int writeCursor = 0;

    public CircularBuffer(int size) {
        buffer = new Object[size];
    }

    @Override
    public boolean offer(Object value) {
        if(buffer[writeCursor] != null){
            return false;
        }

        buffer[writeCursor] = value;
        writeCursor = next(writeCursor);
        return true;
    }

    @Override
    public Object poll() {
        return null;
    }

    private int next(int index) {
        return (index + 1) % buffer.length;
    }
}
