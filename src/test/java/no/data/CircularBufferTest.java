package no.data;

import org.junit.Assert;
import org.junit.Test;

public class CircularBufferTest {

    // Given a Buffer with size = 2
    private Buffer buffer = new CircularBuffer(2);

    @Test
    public void shouldOfferPollableElement(){
        // When an element is added to the buffer
        int element = 1;
        Assert.assertTrue(buffer.offer(element));

        //Assert.assertEquals(element, buffer.poll());
        //Assert.assertNull(buffer.poll());
    }

    @Test
    public void shouldNotOfferWhenBufferIsFull(){

    }

    @Test
    public void shouldNotPollWhenBufferIsEmpty(){

    }

    @Test
    public void shouldRecycleBuffer(){

    }
}
