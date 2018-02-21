// Instantiation using a static block
public class StaffRegister {
	
	private static final StaffRegister instance;
	
	static {
		instance = new StaffRegister();
		// Additional steps would be performed here
	}
	
	private StaffRegister() {}
	
	public static StaffRegister getInstance() {
		
		return instance;
	}

}