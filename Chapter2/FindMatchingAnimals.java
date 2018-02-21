public class FindMatchingAnimals {
	private static void print(Animal animal, CheckTrait trait) {
		if(trait.test(animal))
			System.out.println(animal);
	}
	
	public static void main(String[] args) {
		Animal fish = new Animal("fish", false,true);
		
		Animal kangaroo = new Animal("kangaroo", true, false);
		
		print(fish, a -> a.canHop());
		print(kangaroo, a -> a.canHop());
		
	
	}
		
}