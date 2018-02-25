import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.ArrayDeque;

public class WorkingWithCollections{
	
	public static void main (String[] args){
	
		//List allows duplicates
		List<String> list = new ArrayList<>();
		System.out.println(list.add("Sparrow"));
		System.out.println(list.add("Sparrow"));
		System.out.println(list.remove("cardinal")); // prints false
		System.out.println(list.remove("Sparrow")); // prints true
		System.out.println(list); // [Sparrow], removed only one match of "Sparrow"
		
		//set does not allow duplicates
		//HashSet is not sorted
		System.out.println();
		Set<Integer> set = new HashSet<>();
		boolean b1 = set.add(66); // true
		boolean b2 = set.add(10); // true
		boolean b3 = set.add(66); // false
		boolean b4 = set.add(8); // true
		for (Integer integer: set) System.out.print(integer + ","); // 66,8,10,
		
		//////TreeSet is sorted if the element implements the Comparable interface
		System.out.println();
		Set<Integer> s = new TreeSet<>();
		b1 = s.add(66); // true
		b2 = s.add(10); // true
		b3 = s.add(66); // false
		b4 = s.add(8); // true
		for (Integer integer: s) System.out.print(integer + ","); // 66,8,10,
		
		//TreeSet implements NavigableSet		
		NavigableSet<Integer> navSet = new TreeSet<>();
		for (int i = 1; i <= 20; i++) navSet.add(i);
		System.out.println(navSet.lower(10)); // 9
		System.out.println(navSet.floor(10)); // 10
		System.out.println(navSet.ceiling(19)); // 19
		System.out.println(navSet.higher(19)); // 20
		System.out.println(navSet.higher(20)); // null
		
		//ArrayDeque is a "pure" double-ended" queue
		//add at the end with offer
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		System.out.println(queue.offer(10)); // true
		System.out.println(queue.offer(4)); // true
		System.out.println(queue.peek()); // 10
		System.out.println(queue.poll()); // 10
		System.out.println(queue.poll()); // 4
		System.out.println(queue.peek()); // null
		//add at the beginning with push
		queue.push(10);
		queue.push(4);
		System.out.println(queue.peek()); // 4
		System.out.println(queue.poll()); // 4
		System.out.println(queue.poll()); // 10
		System.out.println(queue.peek()); // null
		
		
		}
	
}
