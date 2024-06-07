package strategy;

public class CardPaymentStrategy implements PaymentStrategy {
    // Assume these details are passed in from the front-end form
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public CardPaymentStrategy(String cardNumber, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean pay(double amount) {
        // Here you would integrate with a card payment API
        // For now, we'll just simulate a payment process
        System.out.println("Processing card payment for amount: " + amount);
        // Validation and processing logic
        if (cardNumberIsValid() && cvvIsValid() && expiryDateIsValid()) {
        	System.out.println("Validate " + amount);
            return true; // Simulate successful payment
        }
        return false;
    }

    private boolean cardNumberIsValid() {
        // Validate card number
        return cardNumber.length() == 16;
    }

    private boolean cvvIsValid() {
        // Validate CVV
        return cvv.length() == 3;
    }

    private boolean expiryDateIsValid() {
        // Validate expiry date
        return expiryDate.matches("(?:0[1-9]|1[0-2])/[0-9]{2}");
    }
}