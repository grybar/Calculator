package calculator;

public interface HistoryInterface {
	
	
	public void addTo(String newExpression);
	
	public void clear();
	
	public String getPastExpression(int position);
}
