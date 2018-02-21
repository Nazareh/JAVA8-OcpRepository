import java.util.List;

public class Animal {
	private String species;
	private boolean canHop;
	private boolean canSwim;
	private int age;
	private List<String> favoriteFoods;
	
	
	public Animal(String speciesName, boolean hopper, boolean swimmer) {
		species = speciesName;
		canHop = hopper;
		canSwim = swimmer;
	}
	
	//constructor used by AnimalBuilder class
	public Animal (String species, int age, List<String> favoriteFoods){
		this.species = species;
		this.age = age;
		this.favoriteFoods = favoriteFoods;
		
	}	

	public boolean canHop() { return canHop; }

	public boolean canSwim() { return canSwim; }

	public String toString() { return species; }
}