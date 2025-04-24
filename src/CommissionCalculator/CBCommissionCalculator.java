package CommissionCalculator;

public class CBCommissionCalculator implements CommissionCalculator{
	
	 @Override
	    public double calculateCommission(Trade trade) {
	        double amount = trade.getQuantity() * trade.getPrice();
	        return "BUY".equalsIgnoreCase(trade.getTransactionType()) ? amount * 0.0002 : amount * 0.0001;
	    }

}
