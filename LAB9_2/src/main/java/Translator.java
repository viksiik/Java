class Translator implements Runnable {
    private final CircularBuffer inputBuffer;
    private final CircularBuffer outputBuffer;
    private final int threadNumber;

    public Translator(CircularBuffer inputBuffer, CircularBuffer outputBuffer, int threadNumber) {
        this.inputBuffer = inputBuffer;
        this.outputBuffer = outputBuffer;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = inputBuffer.take();
                String translatedMessage = "Потік № " + threadNumber + " переклав повідомлення, яке " + message;
                outputBuffer.put(translatedMessage);
                System.out.println(translatedMessage);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
