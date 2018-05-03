import java.io.*;

public class SystemInSample{
    public static void main (String[] args) throws  IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String userInput = in.readLine();
        System.out.println("You have entered the following: "+ userInput);
    }
}