package test5;
public class InsufficientFundsException extends Exception {

    private final String transactionId;

    public InsufficientFundsException(String message, String transactionId) {
        super(message);
        this.transactionId = transactionId;
    }

    public InsufficientFundsException(String message, Throwable cause, String transactionId) {
        super(message, cause);
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
