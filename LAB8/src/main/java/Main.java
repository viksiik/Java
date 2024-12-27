import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Correct usage in command line: java Main.java <number_of_threads>");
            return;
        }

        int numberOfThreads = Integer.parseInt(args[0]);

        if (numberOfThreads <= 0) {
            System.out.println("Number of threads must be greater than 0.");
            return;
        }

        long iterations = 1_000_000_000L;

        long startTime = System.nanoTime();
        double pi = calculatePi(iterations, numberOfThreads);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000_000.0;

        System.out.printf("PI is %.5f\n", pi);
        System.out.println("THREADS " + numberOfThreads);
        System.out.println("ITERATIONS " + iterations);
        System.out.printf("TIME %.2fs\n", duration);
    }

    public static double calculatePi(long iterations, int numberOfThreads) {
        AtomicLong pointsInCircle = new AtomicLong(0);
        long pointsPerThread = iterations / numberOfThreads;

        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                Random random = new Random();
                long localPointsInCircle = 0;

                for (long j = 0; j < pointsPerThread; j++) {
                    double x = random.nextDouble();
                    double y = random.nextDouble();

                    if (x * x + y * y <= 1) {
                        localPointsInCircle++;
                    }
                }

                pointsInCircle.addAndGet(localPointsInCircle);
            });
        }

        System.out.println("--------------------------------");
        for (Thread thread : threads) {
            thread.start();
            System.out.println("Thread " + thread.getName() + " started.");
        }
        System.out.println("--------------------------------\n");

        System.out.println("--------------------------------");
        try {
            for (Thread thread : threads) {
                thread.join();
                System.out.println("Thread " + thread.getName() + " joined.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------------\n");

        return 4.0 * pointsInCircle.get() / iterations;
    }
}
