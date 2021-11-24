package no.data;

public class CircularBuffer {

    // Buffer elements
    private final Object[] elements;
    private int readCursor = 0;
    private int writeCursor = 0;

    public CircularBuffer(int size) {
        elements = new Object[size];
    }

    public boolean offer(Object element) {
        // Check if it's possible to write
        // a new element
        if(elements[writeCursor] == null){
            elements[writeCursor] = element;
            writeCursor = next(writeCursor);
            return true;
        } else {
            return false;
        }
    }

    public Object poll() {
        Object element = elements[readCursor];
        if( element == null ){
            return null;
        } else {
            // remove element from buffer
            elements[readCursor] = null;
            // updated readCursor
            readCursor = next(readCursor);
            return element;
        }
    }

    // Returns the next cursor position
    // in a circular manner
    private int next(int index) {
        return (index + 1) % elements.length;
    }

    public String printContent() {
        StringBuilder stringBuilder = new StringBuilder();

        Object bufferElement;
        while( (bufferElement = this.poll()) != null ) {
            stringBuilder.append(bufferElement.toString());
        }

        return stringBuilder.toString();
    }
}