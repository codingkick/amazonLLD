package questions.vendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private InventoryManager inventoryManager;
    private PaymentService paymentService;
    private List<Transaction> transactions;

    VendingMachine(InventoryManager inventoryManager, PaymentService paymentService) {
        this.inventoryManager = inventoryManager;
        this.paymentService = paymentService;
        this.transactions = new ArrayList<>();
    }

    public void getProducts(Product product,int quantity, String paymentMethod) {
       boolean val = inventoryManager.reduceQuantity(product, quantity);
       if(val){
              double amount = product.getPrice() * quantity;
              boolean paymentStatus = paymentService.makePayment(paymentMethod, amount);
              if(paymentStatus) {
                System.out.println("Please collect your product");
                transactions.add(new Transaction(product, quantity, amount, paymentMethod));
              }
              else {
                System.out.println("Payment failed. Please try again.");
                inventoryManager.addProduct(product, quantity); // Revert inventory change
              }
       }
       else {
           System.out.println("Product not available");
       }

    }
}
