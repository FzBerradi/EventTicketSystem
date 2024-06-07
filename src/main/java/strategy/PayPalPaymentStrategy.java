package strategy;

public class PayPalPaymentStrategy implements PaymentStrategy {
    private String paypalEmail;
    
    public PayPalPaymentStrategy(String paypalEmail) {
        this.paypalEmail = paypalEmail;
    }

    @Override
    public boolean pay(double amount) {
        // Here you would integrate with PayPal's API
        System.out.println("Processing PayPal payment for amount: " + amount);
        // Assume the email validation is done elsewhere or is simply true for this example
        if (paypalEmailIsValid()) {
            // Process PayPal payment
            return true; // Simulate successful PayPal payment
        }
        return false;
    }

    private boolean paypalEmailIsValid() {
        // Validate PayPal email
        // This is a simplistic check
        return paypalEmail.contains("@") && paypalEmail.contains(".");
    }
}
