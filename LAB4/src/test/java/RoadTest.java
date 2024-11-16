import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class RoadTest {
    private Road road;
    private Bus bus;
    private Taxi taxi;
    private PoliceCar policeCar;
    private FireTruck fireTruck;

    @BeforeEach
    void setUp() throws Exception {
        road = new Road();
        bus = new Bus(50);
        taxi = new Taxi(4);
        policeCar = new PoliceCar(4);
        fireTruck = new FireTruck(6);
    }

    @Test
    public void addCarToRoadTest() {
        road.addCarToRoad(bus);
        road.addCarToRoad(taxi);
        road.addCarToRoad(policeCar);
        road.addCarToRoad(fireTruck);

        List<Vehicle<? extends Passenger>> carsOnRoad = road.getCarsInRoad();

        assertEquals(4, carsOnRoad.size());

        assertTrue(carsOnRoad.contains(bus));
        assertTrue(carsOnRoad.contains(taxi));
        assertTrue(carsOnRoad.contains(policeCar));
        assertTrue(carsOnRoad.contains(fireTruck));
    }

    @Test
    public void getCountOfHumansTest() throws Exception {
        bus.boardPassenger(new RegularPassenger());
        taxi.boardPassenger(new RegularPassenger());

        road.addCarToRoad(bus);
        road.addCarToRoad(taxi);

        assertEquals(2, road.getCountOfHumans());
    }

    @Test
    public void getNumberCarsInRoadTest() throws Exception {
        road.addCarToRoad(bus);
        road.addCarToRoad(taxi);
        road.addCarToRoad(policeCar);
        road.addCarToRoad(fireTruck);

        assertEquals(4, road.getNumberCarsInRoad());
    }
}
