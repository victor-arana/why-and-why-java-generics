package no.data;

import org.junit.Assert;
import org.junit.Test;

public class CircularBufferTest {

    // Given a Buffer with size = 2
    private CircularBuffer buffer = new CircularBuffer(2);

    @Test
    public void shouldOfferPollableElement(){
        // When an element is added to the buffer
        int element = 1;
        Assert.assertTrue(buffer.offer(element));
        Assert.assertEquals(element, buffer.poll());
        Assert.assertNull(buffer.poll());
    }

    @Test
    public void shouldNotOfferWhenBufferIsFull(){
        Assert.assertTrue(buffer.offer(1));
        Assert.assertTrue(buffer.offer(2));
        Assert.assertFalse(buffer.offer(3));
    }

    @Test
    public void shouldNotPollWhenBufferIsEmpty(){
        Assert.assertNull(buffer.poll());
    }

    @Test
    public void shouldRecycleBuffer(){
        Assert.assertTrue(buffer.offer(1));
        Assert.assertTrue(buffer.offer(2));
        Assert.assertEquals(1, buffer.poll());
        Assert.assertTrue(buffer.offer(3));
        Assert.assertEquals(2, buffer.poll());
        Assert.assertEquals(3, buffer.poll());
    }
}
