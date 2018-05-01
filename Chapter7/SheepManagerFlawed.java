/*In this example, multiple workers/threads are sharing the sheepCount variable. In the first
sample, two zoo workers both call ++sheepCount at the same time, possible resulting in one of the
increment operations actually being lost, with the last total being 9 instead of 10. Results from
earlier threads are output before ones that started later. We had 10 workers, but the results are
incomplete and out of order.The idea here is that some zoo workers may run faster on their way to
the field but moreslowly on their way back and report late. Others may get to the field last but
somehow be the first ones back to report the results.*/

import java.util.concurrent.*;
public class SheepManagerFlawed {
    private int sheepCount = 0;
    public void incrementAndReport(){
        ++sheepCount;
        System.out.println(sheepCount);
    }
    public static void main (String[] args){
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManagerFlawed manager = new SheepManagerFlawed();
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
