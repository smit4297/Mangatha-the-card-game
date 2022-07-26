package mangatha;

public class CardVariables {

	private static final String[] suits = {"spades","hearts","clubs","diamonds"};
	private static final String[] ranks = {"ace","two","three","four","five","six","seven","eight","nine","ten","jack","queen","king"};
	
	//no setters because this values i don't want any one to change.
	
	public static String[] getSuits() {
		return suits;
	}
	
	public static String[] getRanks() {
		return ranks;
	}
	
}
