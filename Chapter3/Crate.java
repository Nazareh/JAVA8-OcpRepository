//working with generics
public class Crate<T> {
	private T contents;
	public T emptyCrate() {
		return contents;
	}
	public void packCrate(T contents) {
		this.contents = contents;
	}
	public static void main (String[] args){
		Elephant elephant = new Elephant();
		Crate<Elephant> crateForElephant = new Crate<>();
		crateForElephant.packCrate(elephant);
		Elephant inNewHome = crateForElephant.emptyCrate();
		
		Robot joeBot = new Robot();
		Crate<Robot> robotCrate = new Crate<>();
		robotCrate.packCrate(joeBot);
		Robot atDestination = robotCrate.emptyCrate();
		}
}