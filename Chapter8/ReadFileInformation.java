import java.io.File;

public class ReadFileInformation{
    public static void main (String[] args){
        File file = new File ("C:\\Users\\nazar\\Google Drive\\Programming\\Java\\JAVA OCP 8\\Repository\\Chapter8\\data\\zoo.txt");
        System.out.println("File exists: "+ file.exists());
        if (file.exists()){
            System.out.println("Absolute Path: "+ file.getAbsolutePath());
            System.out.println("Name: "+ file.getName());
            System.out.println("Type : "+ (file.isDirectory() ? "Directory" : "File") );
            System.out.println("Parent Path: "+ file.getParent());
            if (file.isFile()){
                System.out.println("File size: "+file.length());
                System.out.println("File last modified: "+ file.lastModified());
            }
            else{
                for (File subfile : file.listFiles())
                    System.out.println("\t"+subfile.getName());
            }
        }
    }
}