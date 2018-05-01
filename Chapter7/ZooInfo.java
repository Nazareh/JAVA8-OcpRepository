import java.util.concurrent.*;
public class ZooInfo {
	public static void main (String[] args){
		ExecutorService service = null;
		
		
		try {
			service = Executors.newSingleThreadExecutor();
			
			System.out.println("BEGIN");
			
			service.execute(() -> System.out.println("Printing Zoo inventory"));
			service.execute(() -> {	for(int i =0; i <3; i++){
									System.out.println("Printing record "+i);}
								  });
			service.execute(() -> System.out.println("Printing Zoo inventory"));
			
			System.out.println("END");
		}
		finally{
			if(service != null)
				service.shutdown();
		}
	}
}
			