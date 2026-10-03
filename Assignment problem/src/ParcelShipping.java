import java.util.*;

abstract class Parcel {
    double weight;
    double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();

    double calculateInsurance() {
        return 0;
    }
}

interface Insurable {
    double calculateInsurance();
}

class Standard extends Parcel {
    Standard(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40 + (weight * 10);
    }
}

class Express extends Parcel implements Insurable {
    Express(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    public double calculateCharge() {
        return 80 + (weight * 15);
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    public double calculateCharge() {
        return 40 + (weight * 10) + 50;
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

public class ParcelShipping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            Parcel parcel;

            if (type.equals("STANDARD")) {
                parcel = new Standard(weight, declaredValue);
            }
            else if (type.equals("EXPRESS")) {
                parcel = new Express(weight, declaredValue);
            }
            else {
                parcel = new Fragile(weight, declaredValue);
            }

            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double total = charge + insurance;

            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        sc.close();
    }
}
