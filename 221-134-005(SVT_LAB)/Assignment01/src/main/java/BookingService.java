public class BookingService {
    private PaymentService paymentService;

    public BookingService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    public void bookService(String serviceName, double amount){
        System.out.println("Booking service: " + serviceName);
        paymentService.processPayment(amount);
    }
}
