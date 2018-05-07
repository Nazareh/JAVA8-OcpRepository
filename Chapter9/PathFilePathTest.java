import java.nio.file.*;
import java.io.IOException;
public class PathFilePathTest {

    public static void printPathInformation(Path path) {
        System.out.println("Filename is: " + path.getFileName());
        System.out.println("Root is: " + path.getRoot());
        Path currentParent = path;
        while ((currentParent = currentParent.getParent()) != null){
            System.out.println("   Current parent is:" + currentParent);
        }
    }

    public static void absolutePathInfo() throws IOException {
        Path path1 = Paths.get("C:\\Users\\nazar\\Google Drive\\Programming\\Java\\JAVA OCP 8\\Repository\\Chapter9\\.idea");
        System.out.println("Path1 is Absolute? "+path1.isAbsolute());
        System.out.println("Absolute Path1: "+path1.toAbsolutePath());

        Path path2 = Paths.get(".idea");
        System.out.println("Path2 is Absolute? "+path2.isAbsolute());
        System.out.println("Absolute Path2 "+path2.toAbsolutePath());

        Path path3 = Paths.get("E:\\habitat");
        Path path4 = Paths.get("E:\\sanctuary\\raven");
        System.out.println(path3.relativize(path4));
        System.out.println(path4.relativize(path3));

        System.out.println();
        Path path5 = Paths.get("/turkey/food");
        Path path6 = Paths.get("c:/tiger/cage");
        System.out.println(path5.resolve(path6));

        Path path7 = Paths.get("C:\\Users\\nazar\\Google Drive\\Programming\\Java\\JAVA OCP 8\\Repository\\Chapter9\\.idea");
        System.out.println(Files.isSymbolicLink(path7));
        System.out.println(Files.isRegularFile(path7));
        System.out.println(Files.getLastModifiedTime(path7));
    }

    public static void main(String[] args) throws IOException {
        printPathInformation(Paths.get("/zoo/armadilho/shells.txt"));
        System.out.println();
        printPathInformation(Paths.get("armadilho/shells.txt"));

        absolutePathInfo();
    }
}