class Rodent {
}

public class Capybara extends Rodent {
	public static void main(String[] args) {
		Rodent rodent = new Rodent();
		
		//rigth way
		if(rodent instanceof Capybara) {
			Capybara capybara = (Capybara)rodent;
		}
		
		//wrong way
		Capybara capybara = (Capybara)rodent; // Throws ClassCastException at runtim
	}
}