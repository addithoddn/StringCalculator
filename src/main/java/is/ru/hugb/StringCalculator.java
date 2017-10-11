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
		boolean negative = false;
		StringBuilder builder = new StringBuilder();
		for(String number : numbers)
		{
			int numberToAdd = toInt(number);
			if(numberToAdd < 0) 
			{
				if(builder.length() != 0)
				{
					builder.append(", ");
				}
				negative = true;
				builder.append(number);
				
			}
			else
			{
				total += numberToAdd;
			}
		}
		if(negative)
			{
				throw new IllegalArgumentException("Negatives not allowed " + builder);
			}
		return total;
	}
}