package is.ru.hugb;

import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
public class CalculatorTest
{

	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testEmptyString()
	{
		assertEquals(0, StringCalculator.add(""));
	}
	
	@Test
	public void testOneNumber()
	{
		assertEquals(1, StringCalculator.add("1"));
	}
	
	@Test
	public void testTwoNumbers()
	{
		assertEquals(3, StringCalculator.add("1,2"));
	}
	@Test
	public void testMultipleNumbers()
	{
		assertEquals(6, StringCalculator.add("1,2,3"));
	}
	@Test
	public void testNewLineInString()
	{
		assertEquals(6, StringCalculator.add("1,2\n3"));
	}

	@Test
	public void testNegativeNumbers()
	{
		thrown.expect(IllegalArgumentException.class);
		StringCalculator.add("-1,2");
	}
	@Test
	public void testMultipleNegativeNumbers()
	{
		thrown.expect(IllegalArgumentException.class);
		StringCalculator.add("-3,2,-2,3");
	}
}