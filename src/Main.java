import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	DateFile();
    	MonthFile();
        EndOfMonthFile();
    }

    public static void DateFile() {
        try (PrintWriter writer = new PrintWriter("date.txt")) {
            LocalDate currentDate = LocalDate.now();
            writer.println(currentDate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void MonthFile() {
        try (PrintWriter writer = new PrintWriter("month.txt")) {
            LocalDate currentDate = LocalDate.now();
            for (int i = 1; i <= currentDate.getDayOfMonth(); i++) {
                writer.println(LocalDate.of(currentDate.getYear(), currentDate.getMonth(), i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void EndOfMonthFile() {
        try (PrintWriter writer = new PrintWriter("end_of_the_month.txt")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter month (1-12): ");
            int month = scanner.nextInt();
            LocalDate currentDate = LocalDate.now().withMonth(month);
            writer.println(currentDate.withDayOfMonth(currentDate.lengthOfMonth()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
