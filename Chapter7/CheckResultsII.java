import java.util.concurrent.*;
public class CheckResultsII {
	public static int counter = 0;
	
	public static void main (String[] args) throws InterruptedException, ExecutionException{
			ExecutorService service = null;
			System.out.println(Runtime.getRuntime().availableProcessors());
			
			try{
				service = Executors.newSingleThreadExecutor();
				Future<?> futureResult = service.submit(() -> { for(int i = 0; i < 500; i++){
																counter++;																															
														}});
				futureResult.get(10,TimeUnit.SECONDS);
				
				System.out.println("END Reached!");
				
			}
			catch (TimeoutException e){
				System.out.println("Not reached in time!");
			}
			finally{
				if (service != null)
					service.shutdown();
			}
			if (service != null){
			service.awaitTermination(1,TimeUnit.MINUTES);
			// Check whether all tasks are finished
			if (service.isTerminated())
				System.out.println("All tasks finished");
			else 
				System.out.println("At least one task is still runnning");
		}
	}
}