import java.text.*;
import java.util.*;

public class FormatNumbers {
	public static void main(String[] args) throws ParseException{
		
		int attendeesPerYear = 3_200_000;
		int attendeesPerMonth = attendeesPerYear / 12;
		
		NumberFormat us = NumberFormat.getInstance(Locale.US);
		System.out.println(us.format(attendeesPerMonth));
		
		NumberFormat g = NumberFormat.getInstance(Locale.GERMANY);
		System.out.println(g.format(attendeesPerMonth));
		
		NumberFormat ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
		System.out.println(ca.format(attendeesPerMonth));
				
		double price = 48;
		us = NumberFormat.getCurrencyInstance();
		System.out.println(us.format(price));
		
		NumberFormat en = NumberFormat.getInstance(Locale.US);
		NumberFormat fr = NumberFormat.getInstance(Locale.FRANCE);
		String s = "40.45";
		System.out.println(en.parse(s)); // 40.45
		
		/*it stops after it reaches a character 
		that cannot be parsed, the parsing stops and the value is returned*/
		System.out.println(fr.parse(s)); // 40
		
		String amt = "$92,807.99";
		NumberFormat cf = NumberFormat.getCurrencyInstance();
		double value = (Double) cf.parse(amt);
		System.out.println(value); // 92807.99
		
	} 
}