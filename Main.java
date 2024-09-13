import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. List Expenses");
            System.out.println("3. Save Expenses");
            System.out.println("4. Load Expenses");
            System.out.println("5. Show Total Expenses");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    manager.addExpense(new Expense(category, amount, description));
                    break;

                case 2:
                    manager.listExpenses();
                    break;

                case 3:
                    System.out.print("Enter filename to save: ");
                    String saveFile = scanner.nextLine();
                    try {
                        manager.saveExpenses(saveFile);
                        System.out.println("Expenses saved.");
                    } catch (IOException e) {
                        System.out.println("Error saving expenses: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter filename to load: ");
                    String loadFile = scanner.nextLine();
                    try {
                        manager.loadExpenses(loadFile);
                        System.out.println("Expenses loaded.");
                    } catch (IOException e) {
                        System.out.println("Error loading expenses: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Total expenses: $" + manager.getTotalExpenses());
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
