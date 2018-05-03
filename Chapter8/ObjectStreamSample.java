import java.util.*;
import java.io.*;

public class ObjectStreamSample{
    public static List<Animal> getAnimals(File source) throws IOException, ClassNotFoundException{
        List<Animal> animals = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(source)))){
            while(true) {
                Object object = in.readObject();
                if (object instanceof Animal) animals.add((Animal) object);
            }
        }
        catch (EOFException e){
            //File end reached
        }
        return animals;
    }
    public static void createAnimalsFile(List<Animal> animals, File destination) throws IOException{
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(destination)))){
            for (Animal animal:animals){
                out.writeObject(animal);
            }
        }
    }
    public static void main(String[] args) throws IOException,ClassNotFoundException{
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Tommy Tiger", 5, 'T'));
        animals.add(new Animal("Peter Penguin", 8, 'P'));

        File data = new File("data\\Animal.data");
        createAnimalsFile(animals,data);
        getAnimals(data).forEach(System.out::println);
    }
}