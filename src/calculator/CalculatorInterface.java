package calculator;

public interface CalculatorInterface {
	
	
	public String calculate();
	
	public void addToExpression(String newValue);
	
	public void clearExpression();
	
	public boolean isNumeric(String newValue);
	
	public boolean isNumeric(char newValue);
	
	public String getExpression();
}
