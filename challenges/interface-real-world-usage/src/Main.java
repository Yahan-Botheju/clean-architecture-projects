import paymentMethods.CreditCardPayment;
import paymentMethods.PayPalPayment;

public class Main {
    public static void main(String[] args) {
      CreditCardPayment creditCardPayment = new CreditCardPayment();
        PayPalPayment payPalPayment = new PayPalPayment();


      PaymentService service = new PaymentService(creditCardPayment);
        service.payForItems();

      PaymentService service2 = new PaymentService(payPalPayment);
      service2.payForItems();
    }
}