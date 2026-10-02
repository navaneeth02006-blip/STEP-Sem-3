import java.util.Scanner;

interface Transport {
    double calculateFare();
}

class Bus implements Transport {
    double distance;

    Bus(double distance) {
        this.distance = distance;
    }

    public double calculateFare() {
        return Math.min(2 + (0.10 * distance), 10);
    }
}

class Train implements Transport {
    double distance;

    Train(double distance) {
        this.distance = distance;
    }

    public double calculateFare() {
        return 3 + (0.15 * distance);
    }
}

class Metro implements Transport {
    double distance;
    double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        this.distance = distance;
        this.peakHourFactor = peakHourFactor;
    }

    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class FareCalculator{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            Transport transport;

            if (type.equals("BUS")) {

                double distance = sc.nextDouble();
                transport = new Bus(distance);

            } else if (type.equals("TRAIN")) {

                double distance = sc.nextDouble();
                transport = new Train(distance);

            } else {

                double distance = sc.nextDouble();
                double peakHourFactor = sc.nextDouble();

                transport = new Metro(distance, peakHourFactor);
            }

            double fare = transport.calculateFare();

            total += fare;

            System.out.printf("%s: %.2f%n%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}