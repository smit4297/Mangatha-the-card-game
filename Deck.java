package mangatha;

import java.util.Collections;
import java.util.LinkedList;


public class Deck {
	
	LinkedList<Card> deckOfCards  = new LinkedList<>();
	
	public Deck() throws InvalidSuitException, InvalidRankException {
		for(String suit: CardVariables.getSuits()) 
			for(String rank: CardVariables.getRanks()) 
				deckOfCards.add(new Card(rank,suit));
	}
	
	public void deckShuffle() {
		Collections.shuffle(deckOfCards);
	}

	public LinkedList<Card> getDeckOfCards() {
		return deckOfCards;
	}

	public Card deal() {
		Card dealCard = deckOfCards.pollFirst();
		return dealCard;
	}

}
