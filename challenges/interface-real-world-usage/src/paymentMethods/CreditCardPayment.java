package paymentMethods;

public class CreditCardPayment implements PaymentGateway{
    @Override
    public void process() {
        System.out.println("Processing paymentMethods CreditCardPayment..!!");
    }
}
