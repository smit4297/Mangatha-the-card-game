package mangatha;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) throws InvalidSuitException, InvalidRankException, NotEnoughCoins {

		Scanner sc = new Scanner(System.in).useDelimiter("\n");
		int round = 0;
		int host = -1;
		System.out.println("==================Welcome to the Game=======================");
		System.out.print("Enter number of players: ");
		int noOfPlayers = sc.nextInt();
		List<Player> players = new ArrayList<>();

		for (int i = 0; i < noOfPlayers; i++) {

			System.out.println("Player " + (i + 1) + " Enter your details:");
			System.out.print("Enter your name: ");
			String name = sc.next();

			System.out.print("Enter coins: ");
			int coins = sc.nextInt();

			players.add(new Player(name, coins));
			System.out.println("Hello " + name + " Enjoy the game.");

		}
		continueGame:

		while (true) {

			round++;
			List<Card> inCards = new ArrayList<>();
			List<Card> outCards = new ArrayList<>();

			System.out.println("==================Round " + round + "=======================");
			Deck deckOfCards = new Deck();

			if (round == 1) {
				System.out.println("This is the first round so host will be choosen randomly.");
				Random rand = new Random();
				host = rand.nextInt(noOfPlayers);
			}

			Player hostPlayer = players.get(host);
			System.out.println(players.get(host).getName() + " You are the host of this round.");
			players.remove(host);
			System.out.println("Shuffling the cards...\nCards Shuffled.");
			deckOfCards.deckShuffle();

			for (Player player : players) {
				System.out.println("Dear " + player.getName() + " guess the card and it's orientation.");
				System.out.print("Enter your chosen card(ex eight of spades):");
				String cardComponents[] = sc.next().toLowerCase().split("of");
				Card chosenCard = new Card(cardComponents[0].strip(), cardComponents[1].strip());
				player.setChosenCard(chosenCard);
				System.out.print("Enter orientation(in or out): ");
				String orientation = sc.next().toLowerCase();
				player.setChosenOrientation(orientation);
			}

			System.out.println("Enter Bet Amount: ");
			int betAmount = sc.nextInt();
			int winningAmount = betAmount * noOfPlayers;

			for (Player player : players)
				player.bet(betAmount);

			List<Player> lostPlayers = new ArrayList<>();

			for (int i = 0; i < 52; i++) {
				
				if ((i + 1) % 2 == 1)
					inCards.add(deckOfCards.getDeckOfCards().get(i));
				else
					outCards.add(deckOfCards.getDeckOfCards().get(i));
				
				for (Player p : players) {
					if (Card.compareCards(p.getChosenCard(), deckOfCards.getDeckOfCards().get(i))) {
						if (((i + 1) % 2 == 1 && p.getChosenOrientation().equals("in"))
								|| ((i + 1) % 2 == 0 && p.getChosenOrientation().equals("out"))) {
							// start new round by making host this player
							host = players.indexOf(p);
							players.add(hostPlayer);
							players.addAll(lostPlayers);
							System.out.println("Congratulations! " + p.getName()
									+ " you won the game. your chosen card is " + p.getChosenCard());
							p.addWinnings(winningAmount);
							System.out.println("You won " + winningAmount + " coins.");
							System.out.println("In cards are : " + inCards);
							System.out.println("Out cards are : " + outCards);
							System.out.print("Do you want to continue the game:(y/n) ");
							String wantToContinue = sc.next().toLowerCase();
							if (wantToContinue.equals("y"))
								continue continueGame;
							else
								break continueGame;
						} else {
							// remove that player from list
							System.out.println("Sorry " + p.getName() + " you lost the game.");
							lostPlayers.add(p);
							players.remove(p);
							break;
						}
					}
				}
			}

			System.out.println("Congratulations! host " + hostPlayer.getName() + " you won the game.");
			hostPlayer.addWinnings(winningAmount);
			System.out.println("You won " + winningAmount + " coins.");
			players.add(hostPlayer);
			players.addAll(lostPlayers);
			host = players.indexOf(hostPlayer);
			System.out.println("In cards are : " + inCards);
			System.out.println("Out cards are : " + outCards);
			System.out.print("Do you want to continue the game:(y/n) ");
			String wantToContinue = sc.next().toLowerCase();
			if (wantToContinue.equals("n"))
				break;

		}
	}


}
