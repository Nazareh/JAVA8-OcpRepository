// Lazy instantiation
public class VisitorTicketTracker {
	private static volatile VisitorTicketTracker instance;
	
	private VisitorTicketTracker() {}
	
	/*The synchronized implementation of getInstance(), while correctly preventing multiple
	singleton objects from being created, has the problem that every single call to this
	method will require synchronization. In practice, this can be costly and can impact
	performance. Synchronization is only needed the first time that the object is created.
	The solution is to use double-checked locking, a design pattern to first test if
	synchronization is needed before actually acquiring any locks.
	*/
	
	public static VisitorTicketTracker getInstance() {
		
		if(instance == null) {
			synchronized(VisitorTicketTracker.class) {
				if(instance == null) {
					instance = new VisitorTicketTracker();
				}
			}
		}
		return instance;
	
	}

}