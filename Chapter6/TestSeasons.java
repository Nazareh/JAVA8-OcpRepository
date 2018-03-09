enum Seasons {
	SPRING, SUMMER, FALL
	}

public class TestSeasons {
	public static void main (String[] args){
		test (Seasons.SUMMER);
	}
	public static void test(Seasons s) {
		switch (s) {
			case SPRING:
				System.out.println("Normal hours");
				break;
			case FALL:
				System.out.println("Shorter hours");
				break;
			case SUMMER:
				System.out.println("Longer hours");
				break;
			default:
				assert false: "Invalid season";
		}
	}
}