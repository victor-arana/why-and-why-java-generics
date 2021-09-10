package no.data;

import org.junit.Assert;
import org.junit.Test;

public class BufferClientTest
{
    @Test
    public void shouldConcatenateBufferContent(){

        Buffer buffer = new CircularBuffer(10);
        buffer.offer("a");
        buffer.offer("bc");
        buffer.offer("d");

        Assert.assertEquals("abcd", (new BufferClient()).concatenate(buffer));
    }
}
