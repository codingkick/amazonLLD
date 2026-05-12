package questions.vendingMachine;

import java.util.Map;

public class PaymentService {
    private static PaymentService paymentService;
    private Map<String, PaymentMethod> paymentMethods;
    private PaymentService() {
        paymentMethods = Map.of(
                "card", CardPayment.getInstance(),
                "upi", UpiPayment.getInstance()
        );
    }

    public static PaymentService getInstance() {
        if(paymentService == null) {
            paymentService = new PaymentService();
        }
        return paymentService;
    }

    public boolean makePayment(String method, double amount) {
        PaymentMethod paymentMethod = paymentMethods.get(method);
        if(paymentMethod != null) {
            return paymentMethod.pay(amount);
        }
        return false;
    }
}
