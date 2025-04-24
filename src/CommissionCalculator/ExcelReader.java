package CommissionCalculator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
	
	public static List<Trade> readTradesFromExcel(String filePath) throws Exception {
	    List<Trade> trades = new ArrayList<>();
	    FileInputStream fis = new FileInputStream(filePath);
	    Workbook workbook = new XSSFWorkbook(fis);
	    Sheet sheet = workbook.getSheetAt(0);

	    for (Row row : sheet) {
	        if (row.getRowNum() == 0) continue; 

	        try {

	            String timestampStr = getCellStringValue(row.getCell(0));
	            String securityType = getCellStringValue(row.getCell(1));
	            String transactionType = getCellStringValue(row.getCell(2));
	            int quantity = (int) row.getCell(3).getNumericCellValue();
	            double price = row.getCell(4).getNumericCellValue();

	            LocalDateTime timestamp = LocalDateTime.parse(timestampStr, DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"));

	            trades.add(new Trade(timestamp, securityType, transactionType, quantity, price));
	        } catch (Exception e) {
	            System.out.println("Error reading row " + row.getRowNum() + ": " + e.getMessage());
	        }
	    }

	    workbook.close();
	    fis.close();
	    return trades;
	}

	
	private static String getCellStringValue(Cell cell) {
	    if (cell == null) return "";

	    return switch (cell.getCellType()) {
	        case STRING -> cell.getStringCellValue();
	        case NUMERIC -> String.valueOf(cell.getNumericCellValue());
	        case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
	        case FORMULA -> cell.getCellFormula();  
	        default -> "";
	    };
	}
}
