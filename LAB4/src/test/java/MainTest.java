import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private Bus bus;
    private Taxi taxi;
    private PoliceCar policeCar;
    private FireTruck fireTruck;

    @BeforeEach
    void setUp() {
        bus = new Bus(30);
        taxi = new Taxi(4);
        policeCar = new PoliceCar(2);
        fireTruck = new FireTruck(6);
    }

    @Test
    void TaxiTest() throws Exception {

        taxi.boardPassenger(new RegularPassenger());
        taxi.boardPassenger(new RegularPassenger());

        assertEquals(2, taxi.getOccupiedSeats());
    }

    @Test
    void anotherTaxiTest() throws Exception {

        taxi.boardPassenger(new Policeman());
        taxi.boardPassenger(new Firefighter());
        taxi.boardPassenger(new RegularPassenger());

        assertEquals(3, taxi.getOccupiedSeats());
    }

    @Test
    void BusTest() throws Exception {

        bus.boardPassenger(new RegularPassenger());
        bus.boardPassenger(new RegularPassenger());
        bus.boardPassenger(new RegularPassenger());
        bus.boardPassenger(new RegularPassenger());
        bus.boardPassenger(new RegularPassenger());

        assertEquals(5, bus.getOccupiedSeats());
    }

    @Test
    void anotherBusTest() throws Exception {

        bus.boardPassenger(new Policeman());
        bus.boardPassenger(new Firefighter());
        bus.boardPassenger(new Firefighter());
        bus.boardPassenger(new RegularPassenger());
        bus.boardPassenger(new RegularPassenger());
        bus.boardPassenger(new RegularPassenger());
        bus.boardPassenger(new RegularPassenger());

        assertEquals(7, bus.getOccupiedSeats());
    }

    @Test
    void PoliceCarTest() throws Exception {

        policeCar.boardPassenger(new Policeman());
        policeCar.boardPassenger(new Policeman());

        assertEquals(2, policeCar.getOccupiedSeats());
    }

    @Test
    void FireTruckTest() throws Exception {

        fireTruck.boardPassenger(new Firefighter());
        fireTruck.boardPassenger(new Firefighter());

        assertEquals(2, fireTruck.getOccupiedSeats());
    }

}
