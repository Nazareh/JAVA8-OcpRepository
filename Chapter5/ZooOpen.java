import java.util.*;


public class ZooOpen{
	public static void main(String[] args){
		Locale enUs = new Locale("en" ,"US");
		Locale frFr = new Locale("fr" ,"FR");
		Locale ptBr = new Locale("pt"  ,"BR");
		
		printProperties(enUs);
		System.out.println();
		
		printProperties(frFr);
		System.out.println();
		
		printProperties(ptBr);
		System.out.println();
		
	}
	public static void printProperties(Locale locale){
	
		ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);
		
		//property by property
		System.out.println(rb.getString("hello"));
		System.out.println(rb.getString("open"));
		
		//all properties at once
		Set<String> key = rb.keySet();
		key.stream().map(k ->k+  "=" + rb.getString(k)).forEach(System.out::println);
		
		//using the Properties class
		Properties properties = new Properties();
		key.stream().forEach(k -> properties.put(k,rb.getString(k)));
		System.out.println(properties.getProperty("notReallyAProperty")); // creates the properties with null value
		System.out.println(properties.getProperty("notReallyAProperty", "123")); //add a value to "notReallyAProperty"
		System.out.println(properties.getProperty("hello"));//retrieves an existing property.
		
		
		
		
	}
	
}