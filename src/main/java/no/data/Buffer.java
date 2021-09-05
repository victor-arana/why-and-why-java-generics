package no.data;

public interface Buffer {

    /**
     * Inserts an element
     * @param value
     * @return
     */
    boolean offer(Object value);

    Object poll();
}
