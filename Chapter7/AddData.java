import java.util.concurrent.*;
public class AddData	{
	
	public static void main (String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService service = null;
		
		try{
			service = Executors.newSingleThreadExecutor();
			
			Future<Integer> futureReturn = service.submit(() -> 33+14);
			System.out.println(futureReturn.get());
		}
		finally{
			if(service != null)
				service.shutdown();
		}
		
				
	}
}