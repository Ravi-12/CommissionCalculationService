package CommissionCalculator;

public class CommissionCalculatorFactory {
	public static CommissionCalculator getCalculator(String securityType) {
        return switch (securityType.toUpperCase()) {
            case "COM" -> new COMCommissionCalculator();
            case "CB" -> new CBCommissionCalculator();
            case "FX" -> new FXCommissionCalculator();
            default -> throw new IllegalArgumentException("Invalid security type");
        };
    }
}
