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

	private static void gatherNegatives(String[] numbers)
	{
		StringBuilder builder = new StringBuilder();
		for(String number : numbers)
		{
			if(toInt(number) < 0)
			{	
				if(builder.length() != 0)
				{
					builder.append(", ");
				}
				builder.append(number);
			}
		}
		throw new IllegalArgumentException("Negatives not allowed: " + builder);
	}

	private static int sum(String[] numbers)
	{
		int total = 0;
		boolean negative = false;
		
		for(String number : numbers)
		{
			int numberToAdd = toInt(number);
			if(numberToAdd < 0) 
			{
				gatherNegatives(numbers);
			}
			else if(numberToAdd > 1000)
			{
				continue;
			}
			else
			{
				total += numberToAdd;
			}
		}
		return total;
	}
}