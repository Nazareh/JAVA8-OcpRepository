/*the favoriteFoods cannot have a GET method because it is a mutable object
and a immutable class should never share references to its mutable objects*/
import java.util.*;

public final class ImmutableAnimal {
	private final String species;
	private final int age;
	private final List<String> favoriteFoods;
	
	public ImmutableAnimal(String species, int age, List<String> favoriteFoods) {
		this.species = species;
		this.age = age;
		
		if(favoriteFoods == null) {
			throw new RuntimeException("favoriteFoods is required");
		}
		
		/*when creating immutable objects any mutable input arguments, such as favoriteFoods,
		should copied to the instance instead of being used directly.
		Othwewise, caller that creates the object is using the same reference as the 
		immutable object, which means that it has the ability to change the List*/
		this.favoriteFoods = new ArrayList<String>(favoriteFoods);
	}
	
	public String getSpecies() {
		return species;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getFavoriteFoodsCount() {
		return favoriteFoods.size();
	}
	
	public String getFavoriteFood(int index) {
		return favoriteFoods.get(index);
	}
}