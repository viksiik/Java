import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleTest {
    private Bus bus;
    private List<RegularPassenger> passengers;

    @BeforeEach
    void setUp() {
        bus = new Bus(30);
        passengers = new ArrayList<>();
    }

    @Test
    void GetMaxSeatsTest() throws Exception {
        try {
            assertEquals(30, new Bus(30).getMaxSeats());
        } catch (Exception e) {
            assertEquals("Max seats must be greater than 0", e.getMessage());
            System.out.println("Exception: " + e);
        }
    }

    @Test
    void GetNegativeMaxSeatsTest() throws Exception {
        try {
            assertEquals(-1, new Bus(-1).getMaxSeats());

        } catch (Exception e) {
            assertEquals("Max seats must be greater than 0", e.getMessage());
            System.out.println("Exception: " + e);
        }
    }


    @Test
    void getPassengersTest() throws Exception {
        try {
            bus.boardPassenger(new RegularPassenger());
            bus.boardPassenger(new RegularPassenger());

            assertFalse(bus.getPassengers().isEmpty());
            assertEquals(2, bus.getOccupiedSeats());

        } catch (Exception e) {
            assertEquals("There are no passengers", e.getMessage());
            System.out.println("Exception: " + e);
        }

    }

    @Test
    void getNoPassengersTest() {
        try {
            assertTrue(bus.getPassengers().isEmpty());
        } catch (Exception e) {
            assertEquals("There are no passengers", e.getMessage());
            System.out.println("Exception: " + e);
        }
    }

    @Test
    void getNoOccupiedSeatsTest() {
        assertEquals(0, bus.getOccupiedSeats());
    }

    @Test
    void getOccupiedSeatsTest() throws Exception {
        bus.boardPassenger(new RegularPassenger());
        bus.boardPassenger(new RegularPassenger());

        assertEquals(2, bus.getOccupiedSeats());
    }

    @Test
    void boardPassengerTest() throws Exception {
        RegularPassenger passenger = new RegularPassenger();
        bus.boardPassenger(passenger);

        assertEquals(1, bus.getOccupiedSeats());
    }

    @Test
    void boardFullPassengerTest(){
        try {
            bus.boardPassenger(new RegularPassenger());
            bus.boardPassenger(new RegularPassenger());
            bus.boardPassenger(new RegularPassenger());
            bus.boardPassenger(new RegularPassenger());

        } catch (Exception e) {
            assertEquals("All seats are occupied!", e.getMessage());
        }
    }


    @Test
    void unboardPassengerTest() throws Exception {
        RegularPassenger passenger = new RegularPassenger();
        bus.boardPassenger(passenger);

        bus.unboardPassenger(passenger);
        assertEquals(0, bus.getOccupiedSeats());
    }

    @Test
    void unboardNoPassengerTest() {
        try {
            RegularPassenger passenger = new RegularPassenger();
            bus.unboardPassenger(passenger);

        } catch (Exception e) {
            assertEquals("The specified passenger is not in the vehicle!", e.getMessage());
        }
    }

    @Test
    void unboardPassengerEmptyTest() {
        try {
            bus.unboardPassenger(new RegularPassenger());

        } catch (Exception e) {
            assertEquals("The specified passenger is not in the vehicle!", e.getMessage());
        }
    }
}
