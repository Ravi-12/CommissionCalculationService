package CommissionCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TradeCommissionService {
	
	private static final int MAX_PARALLEL_TRADES = 10;

    public double calculateTotalCommission(List<Trade> trades) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(MAX_PARALLEL_TRADES);
        List<Future<Double>> futures = new ArrayList<>();

        for (Trade trade : trades) {
            futures.add(executor.submit(() -> {
                CommissionCalculator calculator = CommissionCalculatorFactory.getCalculator(trade.getSecurityType());
                return calculator.calculateCommission(trade);
            }));
        }

        double totalCommission = 0.0;
        for (Future<Double> future : futures) {
            totalCommission += future.get();
        }

        executor.shutdown();
        return totalCommission;
    }

}
