public class Expense {
    private String title;
    private double amount;
    private String category;

    public Expense(String title, double amount, String category) {
        this.title = title;
        this.amount = amount;
        this.category = category;
    }

    public String getTitle() { return title; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return title + "," + amount + "," + category;
    }

    public static Expense fromString(String data) {
        String[] parts = data.split(",");
        return new Expense(parts[0], Double.parseDouble(parts[1]), parts[2]);
    }
}
