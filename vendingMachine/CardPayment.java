package questions.vendingMachine;


public class CardPayment implements PaymentMethod {
    private static CardPayment instance;
    private CardPayment() {
        // Private constructor to prevent instantiation
    }
    public static CardPayment getInstance() {
        if (instance == null) {
            instance = new CardPayment();
        }
        return instance;
    }

    @Override
    public boolean pay(double amount) {
        // Implement card payment processing logic here
        return true; // Placeholder
    }
}
