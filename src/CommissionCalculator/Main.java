package CommissionCalculator;

import java.time.LocalDateTime;


import java.util.List;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
//        String filePath = "./Data/TradeData.xlsx";
//        List<Trade> trades = ExcelReader.readTradesFromExcel(filePath);

		
        List<Trade> trades = List.of(
            new Trade(LocalDateTime.of(2019, 1, 1, 10, 0), "COM", "BUY", 1000, 12),
            new Trade(LocalDateTime.of(2019, 1, 1, 11, 0), "FX", "SELL", 2000, 20),
            new Trade(LocalDateTime.of(2019, 1, 2, 9, 0), "CB", "BUY", 5000, 10),
            new Trade(LocalDateTime.of(2019, 1, 1, 10, 0), "COM", "BUY", 1000, 12),
            new Trade(LocalDateTime.of(2019, 1, 1, 11, 0), "FX", "SELL", 2000, 20),
            new Trade(LocalDateTime.of(2019, 1, 2, 9, 0), "CB", "BUY", 5000, 10),
            new Trade(LocalDateTime.of(2019, 1, 1, 10, 0), "COM", "BUY", 1000, 12),
            new Trade(LocalDateTime.of(2019, 1, 1, 11, 0), "FX", "SELL", 2000, 20),
            new Trade(LocalDateTime.of(2019, 1, 2, 9, 0), "CB", "BUY", 5000, 10),
            new Trade(LocalDateTime.of(2019, 1, 1, 10, 0), "COM", "BUY", 1000, 12),
            new Trade(LocalDateTime.of(2019, 1, 1, 11, 0), "FX", "SELL", 2000, 20),
            new Trade(LocalDateTime.of(2019, 1, 2, 9, 0), "CB", "BUY", 5000, 10)

        );

        TradeCommissionService service = new TradeCommissionService();
        double totalCommission = service.calculateTotalCommission(trades);
        System.out.println("Total Commission: $" + totalCommission);
    }

}
