package no.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BufferClientTest
{

    private GenericCircularBuffer<String> buffer;

    @Before
    public void init(){
        buffer = new GenericCircularBuffer<>(10);
    }

    @Test
    public void shouldConcatenateBufferContent(){
        buffer.offer("a");
        buffer.offer("bc");
        buffer.offer("d");

        Assert.assertEquals("abcd", (new BufferClient()).concatenate(buffer));
    }

    @Test
    public void shouldNotThrowAClassCastException() {
        buffer.offer("1");
        //buffer.offer(1);
        (new BufferClient()).concatenate(buffer);
    }
}
