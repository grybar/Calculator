package calculator;

public class Calculator implements CalculatorInterface {
	private History history;
	private String expression;
	
	public Calculator() {
		history = new History();
		expression = "";
	}
	
	@Override
	public String calculate() {
		int total;
		
		String[] expressionArray = expression.split(" ");
		if (containsParenthesis(expressionArray)) {
			expressionArray = calculateParenthesis(expressionArray);
		}
		
		return null;
	}

	private String[] calculateParenthesis(String[] expressionArray) {
		
		int startPos = findParenthesisPos(expressionArray);
		int endPos = findParenthesisPosEnd(expressionArray);
		String[] subExpression = new String[endPos - startPos];
		
		for (int i = startPos; i < endPos; i++) {
			subExpression[i] = expressionArray[i];
		}
		if (containsParenthesis(subExpression)) {
			calculateParenthesis(subExpression);
		}
		
		
		
		return null;
	}
	
	private boolean containsParenthesis(String[] expression) {
		boolean returnVal = false;
		
		for (String value: expression) {
			if (value.equals("(")) {
				returnVal = true;
			}
		}
		
		return returnVal;
	}
	
	private int findParenthesisPosEnd(String[] expressionArray) {
		boolean foundParenthesis = false;
		int position = expressionArray.length - 1;
		
		while (!foundParenthesis && position > 0) {
			if (expressionArray[position].equals("(")) {
				foundParenthesis = true;
			}
			position--;
		}
		
		return position;
	}

	// This method return the position of the first parenthesis
	private int findParenthesisPos(String[] expressionArray) {
		boolean foundParenthesis = false;
		int position = 0;
		
		while (!foundParenthesis && position < expressionArray.length) {
			if (expressionArray[position].equals("(")) {
				foundParenthesis = true;
			}
			position++;
		}
		
		return position;
	}

	@Override
	public void addToExpression(String newValue) {
		

		
		char latestAddition = ' ';
		if (!expression.isEmpty()) {
			latestAddition = expression.charAt(expression.length() - 1);
		}
		
		if (expression.isEmpty() && !isNumeric(newValue)) {
			if (newValue.equals("(")){
				expression += "(";
			}else {
				expression += "0 " + newValue;
			}		
		}else if (expression.isEmpty() && isNumeric(newValue)) {
			expression += newValue;
		}else if (isNumeric(newValue) && !isNumeric(latestAddition)) {
			expression += " " + newValue;
		}else if (isNumeric(newValue) && isNumeric(latestAddition)) {
			expression += newValue;
		}else if (!isNumeric(newValue) && isNumeric(latestAddition)) {
			expression += " " + newValue;
		}else {
			if (newValue.equals("(")){
				expression += " (";
			}else {
				expression = replaceLast(newValue);
			}
			
		}
	}

	//This method clears the calculators current expression and adds it to the history
	@Override
	public void clearExpression() {
		history.addTo(expression);
		expression = "";
	}

	//This method checks if the string value is numeric.
	public boolean isNumeric(String newValue) {
		
		return newValue.matches("-?\\d+(\\.\\d+)?");  
	
	}
		
	public boolean isNumeric(char newValue) {
		String stringNewValue = "";
		stringNewValue += newValue;
		return stringNewValue.matches("-?\\d+(\\.\\d+)?");
	}
	
	public String getExpression() {
		return expression;
	}
	
	private String replaceLast(String newValue) {
		
		char[] charExpression = expression.toCharArray();
		char[] charNewValue = newValue.toCharArray();
		charExpression[charExpression.length - 1] = charNewValue[0];
		String newExpression = new String(charExpression);
		
		return newExpression;
	}
}
