import java.util.*;

abstract class Connection {
    protected int units;

    Connection(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class Home extends Connection {
    Home(int units) {
        super(units);
    }

    double calculateBill() {
        if (units <= 100)
            return units * 5;
        return 100 * 5 + (units - 100) * 7;
    }
}

class Shop extends Connection {
    Shop(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 8 + 100;
    }
}

class Factory extends Connection {
    Factory(int units) {
        super(units);
    }

    double calculateBill() {
        return Math.max(units * 6, 1000);
    }
}

public class Electricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            Connection connection;

            if (type.equals("HOME"))
                connection = new Home(units);
            else if (type.equals("SHOP"))
                connection = new Shop(units);
            else
                connection = new Factory(units);

            double bill = connection.calculateBill();
            total += bill;

            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}