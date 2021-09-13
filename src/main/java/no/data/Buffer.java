package no.data;

public interface Buffer<T> {
    boolean offer(T value);

    T poll();
}
