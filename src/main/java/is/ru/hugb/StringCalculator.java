package is.ru.hugb;

public class StringCalculator
{
	public static void main(String[] args)
	{
	}
	
	public static int add(String text)
	{
		if(text.equals(""))
		{
			return 0;
		}
		else
		{
			if(text.contains("\n"))
			{
				text = text.replaceAll("\n", ",");
			}
			if(text.contains(","))
			{
				String numbers[] = text.split(",");
				return sum(numbers);
			}
			return 1;
		}
	}

	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}

	private static int sum(String[] numbers)
	{
		int total = 0;
		for(String number : numbers)
		{
			int numberToAdd = toInt(number);
			if(numberToAdd < 0) 
			{
				throw new IllegalArgumentException("-1");
			}
			else
			{
				total += numberToAdd;
			}
		}
		return total;
	}
}