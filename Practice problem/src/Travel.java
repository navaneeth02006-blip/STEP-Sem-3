import java.util.*;

abstract class TravelBooking {
    double distance;

    TravelBooking(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double getTotalFare() {
        return calculateFare() + 50;
    }
}

class Bus extends TravelBooking {
    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 2;
    }
}

class Train extends TravelBooking {
    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 1.5;
    }
}

class Flight extends TravelBooking {
    Flight(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 2500 + distance * 4;
    }
}

public class Travel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            TravelBooking booking;

            if (mode.equals("BUS")) {
                booking = new Bus(distance);
            }
            else if (mode.equals("TRAIN")) {
                booking = new Train(distance);
            }
            else {
                booking = new Flight(distance);
            }

            System.out.printf("%s: %.2f%n",
                    mode, booking.getTotalFare());
        }

        sc.close();
    }
}