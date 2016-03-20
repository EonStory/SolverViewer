
public class Card {
	
	public final int rank;
	public final int suit;
	public final int index;
	
	private static String[] rankNames = new String[] {"A","K","Q","J","T","9","8","7","6","5","4","3","2"};
	private static String[] suitNames = new String[] {"s","h","d","c"};
	
	public static Card[] allCards = new Card[52];
	
	public static final int numberOfCards = rankNames.length * suitNames.length;
	
	//new cards cannot be constructed outside of this class
	private Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
		index = suit * 13 + rank;
	}
	
	static {		
		int counter = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				allCards[counter] = new Card(j, i);
				counter++;
			}
		}
	}
	
	public static Card getCard(int index) {
		return allCards[index];
	}
	
	public String toString() {
		return rankNames[rank] + suitNames[suit];
	}	
}
