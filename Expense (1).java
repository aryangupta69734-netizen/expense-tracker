import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    private String category;
    private double amount;
    private String description;

    public Expense(String category, double amount, String description) {
        this.category = category;
        this.amount = amount;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Category: " + category + ", Amount: " + amount + ", Description: " + description;
    }
}

public class Main {   // 👈 Use 'Main' if your online compiler forces main class name
    private static ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Expense Tracker ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Show Total Expenses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: addExpense(sc); break;
                case 2: viewExpenses(); break;
                case 3: showTotal(); break;
                case 4: System.out.println("Exiting... Goodbye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
        sc.close();
    }

    private static void addExpense(Scanner sc) {
        System.out.print("Enter category (Food, Travel, Shopping, etc.): ");
        String category = sc.nextLine();
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter description: ");
        String description = sc.nextLine();
        expenses.add(new Expense(category, amount, description));
        System.out.println("Expense added successfully!");
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
        } else {
            System.out.println("\n--- List of Expenses ---");
            for (Expense e : expenses) System.out.println(e);
        }
    }

    private static void showTotal() {
        double total = 0;
        for (Expense e : expenses) total += e.getAmount();
        System.out.println("Total Expenses: " + total);
    }
}
