package questions.vendingMachine;

public class Item {
    private Product product;
    private int quantity;
    Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
