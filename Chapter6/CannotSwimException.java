public class CannotSwimException extends Exception {
	public CannotSwimException () {
		super();
	}
	
	public CannotSwimException (Exception e){
		super(e);
	}
	
	public CannotSwimException (String msg) {
		super(msg);
	}

}