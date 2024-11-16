//Реалізувати із застосуванням узагальненого програмування ієрархію Java-класів
//для транспортних засобів, які можуть перевозити різні типи пасажирів.
//Є наступні транспортні засоби: автобус, таксі, пожежна машина, поліцейська машина.
//У цих транспортних засобах можуть їздити наступні види пасажирів: звичайний пасажир,
//пожежник, поліцейський.
//Ієрархія вказаних об’єктів подана на рис. 1. В ході виконання роботи ієрархія може
//бути доопрацьована.
//Рис. 1.
//Автобус та таксі можуть перевозити будь-яких пасажирів, пожежна машина – тільки
//пожежників, поліцейська машина – тільки поліцейських. Реалізувати на основі узагальненого
//програмування (generics) вказані обмеження щодо перевозки пасажирів.
//Для класів транспортних засобів реалізувати наступні функції:
//        - Кожний транспортний засіб має обмежену кількість місць. Реалізувати функцію
//для отримання максимальної кількість місць та функцію для отримання кількості
//зайнятих місць.
//        - Посадка пасажира у транспортний засіб. Якщо всі місця вже зайнято, функція
//повинна ініціювати виключну ситуацію.
//        - Висадка пасажира із транспортного засобу. Функція повинна ініціювати виключну
//ситуацію, якщо вказаний пасажир «не сидить» у транспортному засобі.
//Додатково реалізувати функцію підрахунку кількості людей, які перевозяться на
//автомобілями на певній ділянці дороги. Варіант коду наданий нижче. Дописати код до
//працездатного. Обов’язково використовувати generics та wildcard (де це потрібно).
//public class Road {
//    public List<Vehicle> carsInRoad = new ArrayList<>();
//    public int getCountOfHumans(){….}
//    public void addCarToRoad( …. ){ … }
//}
//Реалізувати модульні тести з наповнення транспортних засобів різними типами пасажирів.
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try {
            Random rand = new Random();
            RegularPassenger passenger = new RegularPassenger();
            Bus bus = new Bus(50);
            bus.boardPassenger(passenger);

            int numberPassengers = rand.nextInt(50);
            for (int i = 0; i < numberPassengers; i++) {
                bus.boardPassenger(new RegularPassenger());
            }
            bus.unboardPassenger(passenger);
            bus.boardPassenger(new Firefighter());
            bus.boardPassenger(new Policeman());

            Taxi taxi = new Taxi(4);
            taxi.boardPassenger(new RegularPassenger());
            taxi.boardPassenger(new RegularPassenger());

            FireTruck fireTruck = new FireTruck(6);
            fireTruck.boardPassenger(new Firefighter());

            PoliceCar policeCar = new PoliceCar(4);
            policeCar.boardPassenger(new Policeman());

            Road road = new Road();
            road.addCarToRoad(bus);
            road.addCarToRoad(taxi);
            road.addCarToRoad(fireTruck);
            road.addCarToRoad(policeCar);

            System.out.println("Total cars on the road: " + road.getNumberCarsInRoad());
            System.out.println("Total humans on the road: " + road.getCountOfHumans());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
