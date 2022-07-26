package mangatha;

public class NotEnoughCoins extends Exception{

	public NotEnoughCoins() {
		
	}
	
	public NotEnoughCoins(String msg) {
		super(msg);
	}
}
