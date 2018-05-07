import java.nio.file.*;
public class GetNameCountSample {
    public static void main(String[] args) {

       Path path = Paths.get(".idea");
        System.out.println(path.getNameCount() );

        System.out.println(path.getName(0) );
    }
}