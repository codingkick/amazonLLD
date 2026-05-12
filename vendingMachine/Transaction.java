package questions.vendingMachine;

public class Transaction {
    private Product product;
    private int quantity;
    private double totalAmount;
    private String paymentMethod;
    Transaction(Product product, int quantity, double totalAmount, String paymentMethod) {
        this.product = product;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
    }
}