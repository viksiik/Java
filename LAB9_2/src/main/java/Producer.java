class Producer implements Runnable {
    private final CircularBuffer buffer;
    private final int threadNumber;

    public Producer(CircularBuffer buffer, int threadNumber) {
        this.buffer = buffer;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = "Потік № " + threadNumber + " згенерував повідомлення";
                buffer.put(message);
                System.out.println(message);
                Thread.sleep(400);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
