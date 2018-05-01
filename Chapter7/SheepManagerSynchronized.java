import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class SheepManagerSynchronized {

    private int sheepCount = 0 ;

    public synchronized void incrementAndReport(){
        System.out.println(++sheepCount);
    }

    public static void main (String[] args){
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManagerSynchronized manager = new SheepManagerSynchronized();

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
