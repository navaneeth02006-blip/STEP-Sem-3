import java.util.*;

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    double calculateFare() {
        double fare = km * getRate();

        // Minimum fare for every cab
        return Math.max(fare, 100);
    }

    boolean nightServiceAvailable() {
        return false;
    }

    double getFinalFare(String time) {
        double fare = calculateFare();

        if (time.equals("NIGHT")) {
            fare = fare * 1.20;
        }

        return fare;
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }
}

class Sedan extends Cab {
    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    boolean nightServiceAvailable() {
        return true;
    }
}

class SUV extends Cab {
    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    boolean nightServiceAvailable() {
        return true;
    }
}

public class CabFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (type.equals("MINI")) {
                cab = new Mini(km);
            }
            else if (type.equals("SEDAN")) {
                cab = new Sedan(km);
            }
            else {
                cab = new SUV(km);
            }

            if (time.equals("NIGHT") && !cab.nightServiceAvailable()) {
                System.out.println(type + ": night service not available");
            }
            else {
                double fare = cab.getFinalFare(time);

                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}