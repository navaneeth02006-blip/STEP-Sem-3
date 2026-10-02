import java.time.LocalDate;
import java.util.Scanner;
interface LibraryItem {
    int getBorrowingDays();
}
class Book implements LibraryItem {
    public int getBorrowingDays() {
        return 14;
    }
}
class DVD implements LibraryItem {
    public int getBorrowingDays() {
        return 7;
    }
}
class Magazine implements LibraryItem {
    public int getBorrowingDays() {
        return 3;
    }
}
public class LibraryItemm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String[] parts = line.split(" ", 2);

            String type = parts[0];
            String title = parts[1].replace("\"", "");

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book();
            } else if (type.equals("DVD")) {
                item = new DVD();
            } else {
                item = new Magazine();
            }
            LocalDate dueDate = currentDate.plusDays(item.getBorrowingDays());

            System.out.println(title + ": " + dueDate);
        }

        sc.close();
    }
}