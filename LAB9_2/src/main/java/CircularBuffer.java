import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class CircularBuffer {
    private final BlockingQueue<String> buffer;

    public CircularBuffer(int size) {
        this.buffer = new ArrayBlockingQueue<>(size);
    }

    public void put(String message) throws InterruptedException {
        buffer.put(message);
    }

    public String take() throws InterruptedException {
        return buffer.take();
    }
}
