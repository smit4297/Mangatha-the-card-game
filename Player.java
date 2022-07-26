package mangatha;

public class Player {
	
	private String name;
	private int coins;
	private String chosenOrientation;
	private Card chosenCard;
	
	public Player(String name, int coins, String chosenOrientation, Card chosenCard) {
		super();
		this.name = name;
		this.coins = coins;
		this.chosenOrientation = chosenOrientation;
		this.chosenCard = chosenCard;
	}
	
	public Player(String name, int coins) {
		super();
		this.name = name;
		this.coins = coins;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public String getChosenOrientation() {
		return chosenOrientation;
	}

	public void setChosenOrientation(String chosenOrientation) {
		this.chosenOrientation = chosenOrientation;
	}

	public Card getChosenCard() {
		return chosenCard;
	}

	public void setChosenCard(Card chosenCard) {
		this.chosenCard = chosenCard;
	}
	
	public void bet(int betCoins) throws NotEnoughCoins {
		if(this.coins < betCoins)
			throw new NotEnoughCoins("You don't have enough coins to play the game."); 
		this.coins -= betCoins;
	}
	
	public void addWinnings(int coins) {
		this.coins += coins;
	}
	
}
