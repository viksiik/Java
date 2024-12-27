import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testCalculatePi_singleThread() {
        double pi = Main.calculatePi(1_000_000, 1);
        assertTrue(pi > 3.1 && pi < 3.2);
    }

    @Test
    void testCalculatePi_multipleThreads() {
        double pi = Main.calculatePi(1_000_000, 4);
        assertTrue(pi > 3.1 && pi < 3.2);
    }

    @Test
    void testCalculatePi_largeIterations() {
        double pi = Main.calculatePi(10_000_000, 4);
        assertTrue(pi > 3.14 && pi < 3.15);
    }
}
