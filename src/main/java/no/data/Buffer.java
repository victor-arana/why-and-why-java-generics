package no.data;

public interface Buffer {

    /**
     * Inserts an element
     * @param value
     * @return
     */
    boolean offer(Object value);

    /**
     * Removes an element from the buffer
     * @return element at the front of the queue
     *
     */
    Object poll();
}
