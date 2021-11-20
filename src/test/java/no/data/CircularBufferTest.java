package no.data;

import org.junit.Assert;
import org.junit.Test;

/**
 * A circular Buffer also known  as a Ring Buffer is a Queue with a fixed size.
 * Elements that come in first, come out first. It offers two methods:
 *
 * 1. offer(element): Writes an element to the buffer.
 *    Returns true if succeeds, false otherwise.
 *
 * 2. poll(): Reads from the buffer.
 *    Returns The first element that came into the buffer or null
 *    if the buffer is empty.
 */
public class CircularBufferTest {

    /**
     * Should return true when offer an element in a
     * non-empty buffer.
     */
    @Test
    public void shouldOfferElement(){
        // Given a non-empty buffer
        final int bufferSize = 1;
        CircularBuffer buffer = new CircularBuffer(bufferSize);
        // When offer an element
        Assert.assertTrue(buffer.offer(1));
    }

    /**
     * Should return the first element that came in
     * a full Circular Buffer with size > 1
     */
    @Test
    public void shouldPollElement(){
        // Given a full Circular Buffer with size > 1
        final int bufferSize = 2;
        CircularBuffer buffer = new CircularBuffer(bufferSize);
        buffer.offer(1);
        buffer.offer(2);
        // When polling an element return the first element
        // that came into the buffer
        Assert.assertEquals(1, buffer.poll());
    }

    /**
     * Should return false when offering an element
     * to a full Circular Buffer.
     */
    @Test
    public void shouldNotOfferWhenBufferIsFull(){
        // Given a full Circular Buffer
        final int bufferSize = 1;
        CircularBuffer buffer = new CircularBuffer(bufferSize);
        buffer.offer(1);
        // When offering an element return false
        Assert.assertFalse(buffer.offer(3));
    }

    /**
     * Should return null when polling an empty
     * Buffer.
     */
    @Test
    public void shouldNotPollWhenBufferIsEmpty(){
        // Given an empty buffer with size 1.
        final int bufferSize = 1;
        CircularBuffer buffer = new CircularBuffer(bufferSize);
        // When polling the buffer return Null
        Assert.assertNull(buffer.poll());
    }


    @Test
    public void shouldRecycleBuffer(){
        // Given a full Circular Buffer
        final int bufferSize = 2;
        CircularBuffer buffer = new CircularBuffer(bufferSize);
        buffer.offer(1);
        buffer.offer(2);
        // After polling one element and offering a new
        // element
        Assert.assertEquals(1, buffer.poll());
        buffer.offer(3);
        // The last element occupies the place left
        Assert.assertEquals(2, buffer.poll());
        Assert.assertEquals(3, buffer.poll());
    }
}
