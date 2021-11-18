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

    @Test
    public void shouldOfferElement(){
        CircularBuffer buffer = new CircularBuffer(1);
        Assert.assertTrue(buffer.offer(1));
    }

    @Test
    public void shouldPollElement(){
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.offer(1);
        buffer.offer(2);
        buffer.offer(3);
        // When polling an element return the first element
        // that came into the buffer
        Assert.assertEquals(1, buffer.poll());
    }

    @Test
    public void shouldNotOfferWhenBufferIsFull(){
        CircularBuffer buffer = new CircularBuffer(1);
        buffer.offer(1);
        Assert.assertFalse(buffer.offer(3));
    }

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
        CircularBuffer buffer = new CircularBuffer();
        buffer.offer(1);
        buffer.offer(2);
        Assert.assertEquals(1, buffer.poll());
        buffer.offer(3);
        Assert.assertEquals(2, buffer.poll());
        Assert.assertEquals(3, buffer.poll());
    }
}
