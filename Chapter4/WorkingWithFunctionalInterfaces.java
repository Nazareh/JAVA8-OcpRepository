import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;
import java.util.function.BinaryOperator;
import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;

public class WorkingWithFunctionalInterfaces {
	
	
	public static void main (String[] args){
		WorkingWithFunctionalInterfaces  wwfi = new WorkingWithFunctionalInterfaces();
		wwfi.ImplementingSupplier();
		wwfi.ImplementingConsumers();
		wwfi.ImplementingBiConsumer();
		wwfi.ImplementingPredicate();
		wwfi.ImplementingBiPredicate();
		wwfi.ImplementingFunction();
		wwfi.ImplementingBiFunction();
		wwfi.ImplementingUnaryOperator();
		wwfi.ImplementingBinaryOperator();
		
		
		
	}
	
	public void ImplementingSupplier(){
		Supplier<LocalDate> s1 = LocalDate::now;
		Supplier<LocalDate> s2 = () -> LocalDate.now();
		LocalDate d1 = s1.get();
		LocalDate d2 = s2.get();
		System.out.println(d1);
		System.out.println(d2);
	}
	public void ImplementingConsumers (){
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = x -> System.out.println(x);
		c1.accept("Annie");
		c2.accept("Annie");
	}
	public void ImplementingBiConsumer (){
		Map<String,Integer> map = new HashMap();
		
		BiConsumer<String,Integer> b1 = map::put;
		BiConsumer<String,Integer> b2 = (k,v) -> map.put(k,v);
		
		b1.accept("chicken", 7);
		b2.accept("chick", 1);
		
		System.out.println(map);
	}
	
	public void ImplementingPredicate(){
		Predicate<String> s1 = String::isEmpty;
		Predicate<String> s2 = s -> s.isEmpty();		
		System.out.println(s1.test(""));
		System.out.println(s2.test(""));	
	}
	public void ImplementingBiPredicate(){
		BiPredicate<String,String> s1 = String::startsWith;
		BiPredicate<String,String> s2 = (t,u) -> t.startsWith(u);
		
		System.out.println(s1.test("chicken", "chick"));
		System.out.println(s2.test("chicken", "egg"));
		
	}
	public void ImplementingFunction(){
		Function<String, Integer> f1 = x -> x.length();
		Function<String, Integer> f2 = String::length;
			
		System.out.println(f1.apply("abcdef"));
		System.out.println(f2.apply("abcdef"));
	}
	
	public void ImplementingBiFunction(){
		BiFunction<String,String,String> f1 = (x,y) -> x.concat(y);
		BiFunction<String,String,String> f2 = String::concat;
		
		System.out.println(f1.apply("Nazareh ", "Turmina"));
		System.out.println(f2.apply("Nazareh ", "Turmina"));
	}
	
	public void ImplementingUnaryOperator(){
		UnaryOperator<String> u1 = String::toUpperCase;
		UnaryOperator<String> u2 = x -> x.toUpperCase();
		System.out.println(u1.apply("chirp"));
		System.out.println(u2.apply("chirp"));
	}	
	public void ImplementingBinaryOperator(){
		BinaryOperator<String> b1 = String::concat;
		BinaryOperator<String> b2 = (x, y) -> x.concat(y);
		System.out.println(b1.apply("baby","chick" ));
		System.out.println(b2.apply("baby","chick"));
	}
		
}