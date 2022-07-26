package mangatha;

public class Card {
	
	private String rank;
	private String suit;
	
	public Card() {
		System.out.println("Card object has been generated");
	}

	public Card(String rank, String suit)throws InvalidSuitException,InvalidRankException {
			setRank(rank);
			setSuit(suit);
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) throws InvalidRankException{
		boolean isValidRank = false;
		for(String r : CardVariables.getRanks())
			if(rank.toLowerCase().equals(r))
				isValidRank = true;
		
		if(!isValidRank) 
			throw new InvalidRankException("Rank is Invalid");
		else {
			this.rank = rank;
		}
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) throws InvalidSuitException{
		boolean isValidSuit = false;
		for(String s : CardVariables.getSuits())
			if(suit.toLowerCase().equals(s))
				isValidSuit = true;
		
		if(!isValidSuit) 
			throw new InvalidSuitException("Suit is Invalid");
		else {
			this.suit = suit;
		}		
	}
	
	public static boolean compareCards(Card card1, Card card2) {
		return (card1.getRank().equals(card2.getRank()) && card1.getSuit().equals(card2.getSuit()));
	}
	
	
	@Override
	public String toString() {
		return getRank() + " of " + getSuit();
	}
	
}
