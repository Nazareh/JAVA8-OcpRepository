import java.util.*;
import java.util.stream.*;
public class ParallelStream {
    public static void main (String[] args){
        Stream<Integer> parallelStreamA = Arrays.asList(2,1,3,4,5).stream().parallel();
        parallelStreamA.forEachOrdered(s -> System.out.println(s));
    }
}