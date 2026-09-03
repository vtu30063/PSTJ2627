import java.util.*;

abstract class Vehicle {
    abstract int calculateFare(int distance);
}

class Bike extends Vehicle {
    public int calculateFare(int distance) {
        return distance * 5;
    }
}

class Auto extends Vehicle {
    public int calculateFare(int distance) {
        return distance * 12;
    }
}

class Cab extends Vehicle {
    public int calculateFare(int distance) {
        return distance * 12;
    }
}

class Driver {
    String name;

    Driver(String name) {
        this.name = name;
    }
}

class Rider {
    String name;

    Rider(String name) {
        this.name = name;
    }
}

class Trip {
    Driver driver;
    Rider rider;
    Vehicle vehicle;
    int distance;

    Trip(Driver driver, Rider rider, Vehicle vehicle, int distance) {
        this.driver = driver;
        this.rider = rider;
        this.vehicle = vehicle;
        this.distance = distance;
    }

    int getFare() {
        return vehicle.calculateFare(distance);
    }
}

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Driver driver = new Driver("Driver1");
        Rider rider = new Rider("Rider1");

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int distance = sc.nextInt();

            try {
                Vehicle vehicle;

                if (type.equalsIgnoreCase("Bike")) {
                    vehicle = new Bike();
                } else if (type.equalsIgnoreCase("Auto")) {
                    vehicle = new Auto();
                } else if (type.equalsIgnoreCase("Cab")) {
                    vehicle = new Cab();
                } else {
                    throw new IllegalArgumentException(
                            "Invalid ride type");
                }

                if (distance <= 0) {
                    throw new IllegalArgumentException(
                            "Invalid distance");
                }

                Trip trip = new Trip(
                        driver, rider, vehicle, distance);

                System.out.println(trip.getFare());

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Booking");
            }
        }

        sc.close();
    }
}
// input
3
Bike 10
Cab 15
Auto 8
// output
50
180
96 
