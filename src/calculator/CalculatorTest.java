package calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void test() {
		Calculator calculator = new Calculator();
		calculator.addToExpression("(");
		calculator.addToExpression("+");
		calculator.addToExpression("(");
		calculator.addToExpression("9");
		calculator.addToExpression(")");
		System.out.println(calculator.getExpression());
		assertEquals("expression should be ( + ( 9 )", "( + ( 9 )", calculator.getExpression());
	}

}
