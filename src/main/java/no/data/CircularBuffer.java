package no.data;

public class CircularBuffer implements Buffer {

    private final Object[] buffer;

    public CircularBuffer(int size) {
        buffer = new Object[size];
    }

    @Override
    public boolean offer(Object value) {
        return false;
    }

    @Override
    public Object poll() {
        return null;
    }
}
