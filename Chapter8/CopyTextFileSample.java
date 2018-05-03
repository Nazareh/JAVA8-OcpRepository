import java.io.*;
import java.util.*;
public class CopyTextFileSample{
    public static List<String> readFile(File source) throws IOException{
        List<String> data = new ArrayList<>();
        try( BufferedReader in = new BufferedReader(new FileReader(source))){
            String s;
            while( (s = in.readLine()) != null)
                data.add(s);
        }
        return data;
    }
    public static void writeFile(List<String> data, File destination) throws IOException{
        try(BufferedWriter out = new BufferedWriter(new FileWriter(destination))){
           for(String line:data){
               out.write(line);
               out.newLine();
           }
        }
    }
    public static void main (String[] args) throws IOException{
            File source = new File("data\\Zoo.txt");
            File destination = new File("data\\ZooCopy.txt");
            List<String> data = readFile(source);
            data.stream().forEach(System.out::println);
            writeFile(data,destination);
        }
}

