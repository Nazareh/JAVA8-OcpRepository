import java.util.stream.*;
import java.util.*;
import java.util.function.*;



public class UsingStreams{
	public static void main (String [] args){
		UsingStreams u = new UsingStreams();
			
		u.createStream();
		//u.terminalOperations();
		//u.intermediateOperations();
		u.sortedArray();
	}
	public void createStream (){
		List<String> list  = Arrays.asList("table", "bed","chair");
		Stream<String> fromList = list.stream();
		Stream<String> fromListParallel = list.parallelStream();
		
		Stream<Double> randoms = Stream.generate(Math::random);
		Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
	
	
	}
	public void terminalOperations(){
		List<String> list  = Arrays.asList("table", "bed","chair");
		Stream<String> stream = list.stream();
		//count
		System.out.println(stream.count());	
		//min or  max
		stream = Stream.of("monkey", "ape", "bonobo");
		Optional<String> min = stream.min((s1, s2) -> s1.length() - s2.length());
		min.ifPresent(System.out::println); // ape
		
		Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
		System.out.println(minEmpty.isPresent()); // false
		
		//findAny and findFirst
		
		stream = Stream.of("monkey", "gorilla", "bonobo");
		Stream<String> infinite = Stream.generate(() -> "chimp");
		stream.findAny().ifPresent(System.out::println); // monkey
		infinite.findAny().ifPresent(System.out::println); // chimp
		
		//allMatch() , anyMatch() and noneMatch()
		List<String> l = Arrays.asList("monkey", "2", "chimp");
		Stream<String> infinite2 = Stream.generate(() -> "chimp");
		Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
		System.out.println(l.stream().anyMatch(pred)); // true
		System.out.println(l.stream().allMatch(pred)); // false
		System.out.println(l.stream().noneMatch(pred)); // false
		System.out.println(infinite2.anyMatch(pred)); // true
		
		//forEach
		stream = Stream.of("Monkey", "Gorilla", "Bonobo");
		stream.forEach(System.out::println); // MonkeyGorillaBonobo
		
		//reduce
		stream = Stream.of("w", "o", "l", "f");
		String word = stream.reduce("", (s, c) -> s + c);
		System.out.println(word); // wolf
		
		// collect
		//if the stream doesnt point to a new object, java.lang.IllegalStateException is throwed at runtime.
		stream = Stream.of("w", "o", "l", "f");
		StringBuilder word1 = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		
		//if the stream doesnt point to a new object, java.lang.IllegalStateException is throwed at runtime.
		stream = Stream.of("w", "o", "l", "f");
		TreeSet<String> treeSet = stream.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(treeSet); // [f, l, o, w]
		
		//if the stream doesnt point to a new object, java.lang.IllegalStateException is throwed at runtime.
		stream = Stream.of("w", "o", "l", "f");
		Set<String> set = stream.collect(Collectors.toSet());
		System.out.println(set); // [f, w, l, o]
		
	}
	public void intermediateOperations(){
		//filter
		Stream<String> stream = Stream.of("monkey","lion","giraffe");
		stream.filter(a -> a.startsWith("m")).forEach(System.out::println);
		//distinct
		stream = Stream.of("banana","apple","banana");
		stream.distinct().forEach(System.out::println);
		//limit and skip
		Stream<Integer> i = Stream.iterate(1, n -> n + 1);
		i.skip(5).limit(2).forEach(s -> System.out.print(s + " ")); // 67
		//map
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		s.map(String::length).forEach(System.out::print); // 676
		//flatmap
		List<String> zero = Arrays.asList();
		List<String> one = Arrays.asList("Bonobo");
		List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
		Stream<List<String>> animals = Stream.of(zero, one, two);
		animals.flatMap(list -> list.stream()).forEach(System.out::println);
		//sorted 
		stream = Stream.of("brown-", "bear-");
		stream.sorted().forEach(System.out::print); // bear-brown
		stream = Stream.of("brown bear-", "grizzly-");
		stream.sorted(Comparator.reverseOrder()).forEach(System.out::print); // grizzly-brown bear-
		//peek
		System.out.println();
		stream = Stream.of("black bear", "brown bear", "grizzly");
		long count = stream.filter(x -> x.startsWith("b")).peek(System.out::println).count(); // "black bear", "brown bear
		System.out.println(count); // 2

		
	}
	
	public void sortedArray(){
	/*say that we wanted to get the first two names alphabetically that are
		four characters long. In Java 7, we’d have to write something like the following:*/
		List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
		List<String> filtered = new ArrayList<>();
		for (String name: list) {
			if (name.length() == 4) filtered.add(name);
		}
		Collections.sort(filtered);
		Iterator<String> iter = filtered.iterator();
		if (iter.hasNext()) System.out.println(iter.next());
		if (iter.hasNext()) System.out.println(iter.next());
		
		//solving the same problem with stream
		list.stream().filter(n -> n.length() == 4)
			.sorted()
			.limit(2)
			.forEach(System.out::println);
	
	}
	
}