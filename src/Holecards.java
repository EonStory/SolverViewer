
public class Holecards {
	
	public final Card card1;
	public final Card card2;
	
	public static final int numberOfHolecards = Card.numberOfCards * (Card.numberOfCards - 1) / 2;
	
	private static Holecards[] allHolecards = new Holecards[numberOfHolecards];
	
	private Holecards(Card card1, Card card2) {
		this.card1 = card1;
		this.card2 = card2;
	}
	
	static {
		int counter = 0;
		for (int i = 0; i < Card.numberOfCards; i++) {
			for (int j = i + 1; j < Card.numberOfCards; j++) {				
				allHolecards[counter] = new Holecards(Card.getCard(i), Card.getCard(j));
				counter++;
			}
		}
	}	
	
	public Holecards get(Card c1, Card c2) {				
		//bigger card always goes second!		
		int smallCard = Math.min(c1.index, c2.index);
		int bigCard = Math.max(c1.index, c2.index);
		
		//triangular numbers!
		int cardsBefore = 0;
		for (int i = 0; i < smallCard; i++) {
			cardsBefore += Card.numberOfCards - 1 - i;
		}
		cardsBefore += bigCard - smallCard - 1;
		
		return allHolecards[cardsBefore];
	}
	
	public String toString() {
		return card1.toString() + card2.toString();
	}	
}