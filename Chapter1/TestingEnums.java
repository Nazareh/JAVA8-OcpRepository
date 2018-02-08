public class TestingEnums {
	public static void main (String[] args){
		
		for(Season season: Season.values()) {
			System.out.println(season.name() + " " + season.ordinal());
		}
		Season season = Season.SUMMER;
		switch (season) {
		case WINTER:
			System.out.println("Get out the sled!" );
			season.printExpectedVisitors();
			season.printHours() ;
			break;
		case SUMMER:
			System.out.println("Time for the pool!");
			season.printExpectedVisitors();
			season.printHours() ;
			break;
		default:
			System.out.println("Is it summer yet?");
			season.printExpectedVisitors();
			season.printHours() ;
		}
	
	}
	
}

enum Season {
	WINTER("Low") {
		public void printHours() { System.out.println("Opening Hours: short hours"); }
	}
	,SUMMER("High") {
		public void printHours() { System.out.println("Opening Hours: long hours"); }	
	}
	,SPRING("Medium"), FALL("Medium");
	
	public void printHours() { System.out.println("Opening Hours: default hours");};
	
	private String expectedVisitors;
	
	private Season(String expectedVisitors) {
		this.expectedVisitors = expectedVisitors;
	}

	public void printExpectedVisitors() {
		System.out.println("Expected Visitors: "+ expectedVisitors);
	}
}
