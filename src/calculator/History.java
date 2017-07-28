package calculator;

public class History implements HistoryInterface {
	private String[] pastCalculations;
	
	public History(){
		pastCalculations = new String[10];
	}
	
	@Override
	public void addTo(String newExpression) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPastExpression(int position) {
		// TODO Auto-generated method stub
		return null;
	}

}
