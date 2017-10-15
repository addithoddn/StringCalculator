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
			String[] numbers = delimeterHandling(text);
			return sum(numbers);	
		}
	}

	private static String[] delimeterHandling(String text)
	{
		String delimeter = ",";
		StringBuilder builder = new StringBuilder();
		if( text.charAt(0) == '/')
		{
			delimeter = getDelimeter(text);
			text = text.substring(delimeter.length() + 3, text.length());
		}
		if(text.contains("\n"))
		{
			text = text.replaceAll("\n", delimeter);
		}
		return text.split(delimeter);
	}

	private static String getDelimeter(String text)
	{
		String[] delimeterText = text.split("\n");
		return delimeterText[0].substring(2, delimeterText[0].length());
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
			if(number == "")
			{
				continue;
			}
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