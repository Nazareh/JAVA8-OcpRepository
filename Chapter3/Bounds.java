import java.util.List;
import java.util.ArrayList;

interface Flyer { void fly(); }

class HangGlider implements Flyer { public void fly() {} }

class Goose implements Flyer { public void fly() {} }


public class Bounds {


	//unbounded wildcard
	public static void printList(List<?> list) {
		for (Object x: list) System.out.println(x);
	}
	
	//upper-bounded wildcard
	public static long total(List<? extends Number> list) {
		long count = 0;
		for (Number number: list)
		count += number.longValue();
		return count;
	}

	
	static void anyFlyer(List<Flyer> flyer) {}
	
	static void groupOfFlyers(List<? extends Flyer> flyer) {}
	
	
	public static void main(String[] args) {
		
		//using unbounded wildcard
		List<String> keywords = new ArrayList<>();
		keywords.add("java");
		printList(keywords); 
		
		//upper-bounded wildcard
		List<Integer> numbers = new ArrayList<>();
		numbers.add(4); numbers.add(5);
		System.out.println(total(numbers));
		
		List<Flyer> list = new ArrayList<>();
		list.add(new HangGlider());
		anyFlyer(list);
		groupOfFlyers(list);
		
		
		
	}
	
	
}