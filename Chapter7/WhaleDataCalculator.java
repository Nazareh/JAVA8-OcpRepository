import java.util.stream.*;
import java.util.*;
public class WhaleDataCalculator {
    public int processRecord(int input){
        try{
            Thread.sleep(10);
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        return input +1;
    }

    public void processAllData(List<Integer> data){
        data.stream().map(a -> processRecord(a)).count();
    }
    public void processAllDataParalled(List<Integer> data){
        data.parallelStream().map(a -> processRecord(a)).count();
    }
    public static void main (String[] args){
        WhaleDataCalculator calculator = new WhaleDataCalculator();

        //define data
        List<Integer> data = new ArrayList<>();
        for(int i =0; i<1000; i++){
            data.add(i);
        }
        //process data
        System.out.println();
        System.out.println("Stream processing started...");
        long start = System.currentTimeMillis();
        calculator.processAllData(data);
        double timeEllapsed = (System.currentTimeMillis() - start)/1000.0;
        //report data
        System.out.println(data.size() + " files processed in: "+ timeEllapsed + " seconds.");

        //process data i parallell
        System.out.println();
        System.out.println("Stream parallel processing started...");
        start = System.currentTimeMillis();
        calculator.processAllDataParalled(data);
        timeEllapsed = (System.currentTimeMillis() - start)/1000.0;
        //report data
        System.out.println(data.size() + " files processed in: "+ timeEllapsed + " seconds.");
    }
}