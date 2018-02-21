
public class Oceanographer {
	public void checkSound(LivesInOcean animal) {
		animal.makeSound();
	}
	
	public void main(String[] args) {
		Oceanographer o = new Oceanographer();
		o.checkSound(new Dolphin());
		o.checkSound(new Whale());
}
}