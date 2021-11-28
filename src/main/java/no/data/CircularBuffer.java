package no.data;

/**
 * A Circular Buffer also known  as a Ring Buffer is a Queue with a fixed size.
 * Elements that come in first, come out first.
 */
public class CircularBuffer<T> {

    public CircularBuffer(int size) {
    }

    /**
     * Writes a String element to the Buffer.
     * @return true if succeeds, false otherwise.
     */
    public boolean offer(T element) {
        return false;
    }

    /**
     * Reads a String element from the Buffer.
     * @return The first String element that came into the
     * buffer or null if the buffer is empty
     */
    public T poll() {
        return null;
    }

    /**
     * Print the content of the Buffer
     * @return A String containing the elements
     * of the Buffer
     */
    public String printContent() {
        return null;
    }
}
