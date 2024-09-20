package amaro;

public class Product {
    private int pid, stocks, sold;
    private String pname;
    private double price;

    public void addProduct(int pid, double price, String name, int stocks, int sold) {
        this.pid = pid;
        this.pname = name;
        this.stocks = stocks;
        this.price = price;
        this.sold = sold;
    }

    public void viewProduct() {
        int remainingStock = this.stocks - this.sold; 
        double totalValue = this.price * remainingStock;
        String status = (remainingStock > 0) ? "Available" : "Out of Stock";
        System.out.printf("%-10d %-20s %-10d %-10d %-10.2f %-15s\n", this.pid, this.pname, remainingStock, this.sold, totalValue, status);
    }
}