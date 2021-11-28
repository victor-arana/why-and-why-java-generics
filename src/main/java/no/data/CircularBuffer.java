package no.data;

/**
 * A Circular Buffer also known  as a Ring Buffer is a Queue with a fixed size.
 * Elements that come in first, come out first.
 */
public class CircularBuffer<T> {

    // Buffer elements
    private final T[] elements;
    private int readCursor = 0;
    private int writeCursor = 0;

    public CircularBuffer(int size) {
        elements = (T[]) new Object[size];
    }

    /**
     * Writes a String element to the Buffer.
     * @return true if succeeds, false otherwise.
     */
    public boolean offer(T element) {
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

    /**
     * Reads a String element from the Buffer.
     * @return The first String element that came into the
     * buffer or null if the buffer is empty
     */
    public T poll() {
        T element = elements[readCursor];
        if (element == null) {
            return null;
        } else {
            // remove element from buffer
            elements[readCursor] = null;
            // updated readCursor
            readCursor = next(readCursor);
            return element;
        }
    }

    /**
     * Print the content of the Buffer
     * @return A String containing the elements
     * of the Buffer
     */
    public String printContent() {
        StringBuilder stringBuilder = new StringBuilder();

        T bufferElement;
        while( (bufferElement = this.poll()) != null ) {
            stringBuilder.append(bufferElement.toString());
        }

        return stringBuilder.toString();
    }

    // Returns the next cursor position
    // in a circular manner
    private int next(int index) {
        return (index + 1) % elements.length;
    }
}
