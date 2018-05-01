import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class SheepManagerAsynchronized {

    private AtomicInteger sheepCount = new AtomicInteger(0) ;

    public void incrementAndReport(){
        System.out.println(sheepCount.incrementAndGet());
    }

    public static void main (String[] args){
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManagerAsynchronized manager = new SheepManagerAsynchronized();

            for (int i = 0; i < 10; i++) {
                service.submit(() -> manager.incrementAndReport());
            }
        }
        finally{
            if (service != null)
                service.shutdown();
        }
    }
}
