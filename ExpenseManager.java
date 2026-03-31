import java.io.*;
import java.util.*;

public class ExpenseManager {
    private List<Expense> expenses = new ArrayList<>();
    private final String FILE_NAME = "expenses.txt";

    public ExpenseManager() {
        loadFromFile();
    }

    public void addExpense(String title, double amount, String category) {
        expenses.add(new Expense(title, amount, category));
        saveToFile();
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        for (Expense e : expenses) {
            System.out.println("Title: " + e.getTitle() +
                               ", Amount: " + e.getAmount() +
                               ", Category: " + e.getCategory());
        }
    }

    public void showTotal() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        System.out.println("Total Spending: " + total);
    }

    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Expense e : expenses) {
                bw.write(e.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                expenses.add(Expense.fromString(line));
            }
        } catch (IOException e) {
            // first time file won't exist
        }
    }
}