import java.util.ArrayList;
import java.util.List;


class Road {
    private List<Vehicle<? extends Passenger>> carsInRoad = new ArrayList<>();

    public void addCarToRoad(Vehicle<? extends Passenger> vehicle) {
        carsInRoad.add(vehicle);
    }

    public int getCountOfHumans() {
        int totalHumans = 0;
        for (Vehicle<? extends Passenger> vehicle : carsInRoad) {
            totalHumans += vehicle.getOccupiedSeats();
        }
        return totalHumans;
    }

    public int getNumberCarsInRoad() {
        return carsInRoad.size();
    }

    public List<Vehicle<? extends Passenger>> getCarsInRoad() {
        return carsInRoad;
    }
}