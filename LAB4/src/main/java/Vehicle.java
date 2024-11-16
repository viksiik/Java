import java.util.ArrayList;
import java.util.List;

abstract class Vehicle<T extends Passenger> {
    private List<T> passengers = new ArrayList<>();
    private final int maxSeats;

    public Vehicle(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public int getMaxSeats() throws Exception {
        if (maxSeats <= 0) {
            throw new Exception("Max seats must be greater than 0");
        }
        return maxSeats;
    }

    public List<T> getPassengers() throws Exception {
        if (passengers.isEmpty()) {
            throw new Exception("There are no passengers");
        }
        return passengers;
    }

    public int getOccupiedSeats() {
        return passengers.size();
    }

    public void boardPassenger(T passenger) throws Exception {
        if (getOccupiedSeats() >= maxSeats) {
            throw new Exception("All seats are occupied!");
        }
        passengers.add(passenger);
    }

    public void unboardPassenger(T passenger) throws Exception {
        if (!passengers.contains(passenger)) {
            throw new Exception("The specified passenger is not in the vehicle!");
        }
        else if (getOccupiedSeats() <= 0) {
            throw new Exception("There are no other passengers in the vehicle!");
        }
        passengers.remove(passenger);
    }

}