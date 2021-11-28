package no.data;

/**
 * A Circular Buffer also known  as a Ring Buffer is a Queue with a fixed size.
 * Elements that come in first, come out first.
 */
public class StringCircularBuffer {

    private final String[] elements;
    private int writeCursor;
    private int readCursor;

    public StringCircularBuffer(int bufferSize) {
        elements = new String[bufferSize];
    }

    /**
     * Writes a String element to the Buffer.
     * @return true if succeeds, false otherwise.
     */
    public boolean offer(String element) {
        // Check if it's possible to write
        // a new element
        if (elements[writeCursor] == null) {
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
    public String poll() {
        String element = elements[readCursor];
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

        String bufferElement;
        while( (bufferElement = this.poll()) != null ) {
            stringBuilder.append(bufferElement);
        }

        return stringBuilder.toString();
    }

    // Returns the next cursor position in a
    // circular manner
    private int next(int readCursor) {
        return (readCursor + 1) % elements.length;
    }

}
