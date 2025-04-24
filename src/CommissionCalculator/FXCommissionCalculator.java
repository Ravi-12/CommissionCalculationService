package CommissionCalculator;

public class FXCommissionCalculator implements CommissionCalculator{
    @Override
    public double calculateCommission(Trade trade) {
        double amount = trade.getQuantity() * trade.getPrice();
        if ("SELL".equalsIgnoreCase(trade.getTransactionType())) {
            if (amount > 1_000_000) return 1000;
            else if (amount > 10_000) return 100;
            else return 0;
        } else {
            return amount * 0.0001;
        }
    }

}
