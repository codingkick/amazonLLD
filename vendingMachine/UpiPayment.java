package questions.vendingMachine;

public class UpiPayment implements PaymentMethod {
    private static UpiPayment instance;
    UpiPayment() {}
    public static UpiPayment getInstance() {
        if (instance == null) {
            instance = new UpiPayment();
        }
        return instance;
    }
    @Override
    public boolean pay(double amount) {
        // Implement UPI payment processing logic here
        return true; // Placeholder
    }
}
