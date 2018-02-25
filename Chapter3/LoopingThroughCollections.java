public class LoopingThroughCollections {
	
	public static void main (String[] args){
		//using ehanced loop
		java.util.List<String> cats = java.util.Arrays.asList("Tom", "Garfield");
		for (String cat:cats){
			System.out.println(cat);
		}
		
		//using forEach
		cats.forEach(c -> System.out.println(c));
		
		//using method reference
		cats.forEach(System.out::println);
		
		
	}
}
