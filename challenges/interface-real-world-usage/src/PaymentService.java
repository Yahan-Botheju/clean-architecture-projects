import paymentMethods.PaymentGateway;

public class PaymentService {

    //inject dependencies
    private final PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    //use dependency in related method
    public void payForItems(){
        paymentGateway.process();
    }

}
