import java.util.function.BiFunction;
import java.util.function.Function;


public class WorkingWithMap{
	
	public static void main (String[] args){
		

	}
	public void HashMap (){
		//HashMap
		System.out.println("_____________");
		System.out.println("HashMap");
		java.util.Map<String, String> hashMap = new java.util.HashMap<>();
		hashMap.put("koala","bamboo");
		hashMap.put("lion", "meat");
		hashMap.put("giraffe", "leaf");
		for (String key:hashMap.keySet()) System.out.println(key + " eats " + hashMap.get(key));

	}
	
	public void TreeMap(){
		
		//TreeMap
		System.out.println();
		java.util.Map<String, String> treeMap = new java.util.TreeMap<>();
		treeMap.put("koala","bamboo");
		treeMap.put("lion", "meat");
		treeMap.put("panda", "bamboo");
		treeMap.put("giraffe", "leaf");
		
		System.out.println("_____________");
		System.out.println("TreeMap sorted by key");
		for (String key:treeMap .keySet()) System.out.println(key + " eats " + treeMap.get(key));
		
		System.out.println(treeMap.containsKey("lion")); // true
		System.out.println(treeMap.containsValue("meat")); // false
		System.out.println(treeMap.size()); // 4
	}
	
	public void putIfAbsent(){
		//putIfAbsent
		
		java.util.Map<String, String> favorites = new java.util.HashMap<>();
		favorites.put("Jenny", "Bus Tour");
		favorites.put("Tom", null);
		favorites.putIfAbsent("Jenny", "Tram");
		favorites.putIfAbsent("Sam", "Tram");
		favorites.putIfAbsent("Tom", "Tram");
		System.out.println(favorites); // {Tom=Tram, Jenny=Bus Tour, Sam=Tram}
		
	}
	public void merge (){
		//merge
		BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1: v2;
		java.util.Map<String, String> longer = new java.util.HashMap<>();
		longer.put("Jenny", "Bus Tour");
		longer.put("Tom", "Tram");
		String jenny = longer.merge("Jenny", "Skyride", mapper);
		System.out.println(longer); // {Tom=Skyride, Jenny=Bus Tour}
		System.out.println(jenny); // Bus Tour
		String tom = longer.merge("Tom", "Skyride", mapper);
		System.out.println(tom); // Skyride
	
	}
	
	public void computeIfPresent (){
			java.util.Map<String, Integer> counts = new java.util.HashMap<>();
			counts.put("Jenny", 1);
			BiFunction<String, Integer, Integer> mapper = (k, v) -> v + 1;
			Integer jenny = counts.computeIfPresent("Jenny", mapper);
			Integer sam = counts.computeIfPresent("Sam", mapper);
			System.out.println(counts); // {Jenny=2}
			System.out.println(jenny); // 2
			System.out.println(sam); // null
	}
		
	public void computeIfAbsent (){
		java.util.Map<String, Integer> counts = new java.util.HashMap<>();
		counts.put("Jenny", 15);
		counts.put("Tom", null);
		Function<String, Integer> mapper = (k) -> 1;
		Integer jenny = counts.computeIfAbsent("Jenny", mapper); // 15
		Integer sam = counts.computeIfAbsent("Sam", mapper); // 1
		Integer tom = counts.computeIfAbsent("Tom", mapper); // 1
		System.out.println(counts); // {Tom=1, Jenny=15, Sam=1}
	}
}