import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.nio.file.attribute.BasicFileAttributes;


public class SearchDirectorySample {

    public static void main(String[] args) throws IOException{
        Path path = Paths.get("/bigcats");
        long dateFilter = 1420070400000l;
        try {
           Stream<Path> stream = Files.find(path, 10,  (p, a) -> p.toString().endsWith(".java")
                                                                 && a.lastModifiedTime().toMillis() > dateFilter);
            stream.forEach(System.out::println);
        } catch ( Exception e) {
                // Handle file I/O exception...
        }
    }
}