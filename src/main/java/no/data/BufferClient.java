package no.data;

/**
 * Hello world!
 *
 */
public class BufferClient
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public String concatenate(CircularBuffer buffer) {

        StringBuilder stringBuilder = new StringBuilder();

        String bufferElement;
        while((bufferElement = (String) buffer.poll()) != null){
            stringBuilder.append(bufferElement);
        }

        return stringBuilder.toString();
    }
}
