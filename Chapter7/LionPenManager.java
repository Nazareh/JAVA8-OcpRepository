import java.util.concurrent.*;

public class LionPenManager{

    private void removeAnimals(){ System.out.println("Removing animals");}
    private void cleanPen(){ System.out.println("Cleaning Pen");}
    private void addAnimals(){ System.out.println("Adding animals");}

    public void performTasks(CyclicBarrier c1, CyclicBarrier c2){
        try{
            removeAnimals();
            c1.await();
            cleanPen();
            c2.await();
            addAnimals();
        }
        catch (InterruptedException | BrokenBarrierException e){
            System.out.println(e);
        }
    }
    public static void main (String[] args){
        ExecutorService service = null;

        try{
            service = Executors.newFixedThreadPool(4);
            LionPenManager manager = new LionPenManager();
            CyclicBarrier c1 = new CyclicBarrier(4,() -> System.out.println("***Pen Emptied***"));
            CyclicBarrier c2 = new CyclicBarrier(4,() -> System.out.println("***Pen Cleaned***"));

            for (int i = 0; i< 4; i++){
                service.submit(() -> manager.performTasks(c1,c2));
            }
        }
        finally{
            if (service != null) service.shutdown();

        }
    }

}