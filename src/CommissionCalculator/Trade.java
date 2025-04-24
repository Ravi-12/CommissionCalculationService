package CommissionCalculator;

import java.time.LocalDateTime;

public class Trade {
	
	private LocalDateTime timestamp;
    private String securityType; 
    private String transactionType;
    private int quantity;
    private double price;
    
    public Trade(LocalDateTime timestamp, String securityType, String transactionType, int quantity, double price) {
        this.timestamp = timestamp;
        this.securityType = securityType;
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.price = price;
    }
    
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getSecurityType() { return securityType; }
    public String getTransactionType() { return transactionType; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public double getAmount() { return quantity * price; }

   
}
 