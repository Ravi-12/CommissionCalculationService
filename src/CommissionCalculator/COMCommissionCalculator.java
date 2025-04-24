package CommissionCalculator;

public class COMCommissionCalculator implements CommissionCalculator{
	
	@Override
    public double calculateCommission(Trade trade) {
        double amount = trade.getQuantity() * trade.getPrice();
        double commission = amount * 0.0005;
        if (trade.getTransactionType().equalsIgnoreCase("SELL") && amount > 100000) {
            commission += 500;
        }
        return commission;
    }

}
