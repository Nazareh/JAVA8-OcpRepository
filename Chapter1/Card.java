public class Card {
	private String rank;
	private String suit;
	
	public Card(String r, String s) {
		if (r == null || s == null)
			throw new IllegalArgumentException();
		rank = r;
		suit = s;
		}
	@Override	
	public boolean equals(Object obj) {
		if ( !(obj instanceof Card)) return false;
		Card c = (Card) obj;
		return rank.equals(c.rank) && suit.equals(c.suit);
	}
	@Override
	public int hashCode() {
		return rank.hashCode();
	}
	public static void main (String[] args){
		Card card = new Card("7","Spades");
		
		System.out.println(card.hashCode());
		}
}