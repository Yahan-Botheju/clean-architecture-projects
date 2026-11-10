package paymentMethods;

public class PayPalPayment implements PaymentGateway{
    @Override
    public void process() {
        System.out.println("Processing paymentMethods PayPalPayment..!!");
    }
}
