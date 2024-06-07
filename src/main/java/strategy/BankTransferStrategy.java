package strategy;

public class BankTransferStrategy implements PaymentStrategy {
    private String accountNumber;
    private String routingNumber;

    public BankTransferStrategy(String accountNumber, String routingNumber) {
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
    }

    @Override
    public boolean pay(double amount) {
        // Here you would integrate with a bank's API
        System.out.println("Processing bank transfer for amount: " + amount);
        // Validation and processing logic
        if (accountAndRoutingNumberAreValid()) {
            // Process bank transfer
            return true; // Simulate successful bank transfer
        }
        return false;
    }

    private boolean accountAndRoutingNumberAreValid() {
        // Validate account and routing number
        // This is a simplistic check
        return accountNumber.length() > 5 && routingNumber.length() > 5;
    }
}