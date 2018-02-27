import java.util.stream.*;
import java.util.OptionalDouble;

public class primitiveStreams {
	
	public static void main (String[] args){
	
        //using object stream to calc the average
		Stream<Integer> stream = Stream.of(1, 2, 3);
        System.out.println(stream.mapToInt(x -> x).sum());
		System.out.println();
		
        //using primitive streams to calc the average
        //one way
		IntStream intStream = IntStream.of(1, 2, 3);
        OptionalDouble avg = intStream.average();
        System.out.println(avg.getAsDouble());
		//other way
		 intStream = IntStream.rangeClosed(1,10);
		OptionalDouble optional = intStream.average();
		optional.ifPresent(System.out::println);
		System.out.println(optional.getAsDouble());
		System.out.println(optional.orElseGet(() -> Double.NaN));
			System.out.println();

        //creating primitive streams
        DoubleStream oneValue = DoubleStream. of (3.14);
        DoubleStream varargs = DoubleStream. of (1.0, 1.1, 1.2);
        oneValue.forEach(System.out::println);
        System.out.println();
        varargs.forEach(System.out::println);
			System.out.println();

        DoubleStream random = DoubleStream. generate (Math::random);
        DoubleStream fractions = DoubleStream. iterate (.5, d -> d / 2);
        random.limit(3).forEach(System.out::println);
        System.out.println();
        fractions.limit(3).forEach(System.out::println);
			System.out.println();

        //counting from 1 to 5 - one way
        intStream = IntStream.iterate(1, n -> n+1).limit(5);
        intStream.forEach(System.out::print);
		 System.out.println();
		//counting from 1 to 5 - other way
		intStream = IntStream.range(1, 6);
		intStream.forEach(System.out::print);
		

	}
}
