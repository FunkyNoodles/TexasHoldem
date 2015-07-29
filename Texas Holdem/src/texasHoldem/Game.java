package texasHoldem;

import java.util.ArrayList;
import java.util.Random;

public class Game {
	int[] cards = new int[52];
	// Goes from Spade, Heart, Club, and Diamond
	ArrayList<Integer> cardsSequence = new ArrayList<Integer>();
	// mod #Players to get player identity
	// 0 is player, the rest is CPU
	// then flop, river, and turn
	int index = 0;
	int numPlayers = 7;

	public Game() {
		for (int loopCards1 = 0; loopCards1 < cards.length - 1; loopCards1++) {
			cards[loopCards1] = loopCards1;
		}
		index = cards.length - 1;
		shuffleDeck();
		dealCards();
		pop();
		flopCards();
		pop();
		riverCards();
		pop();
		turnCards();
		for (int loopPrint1 = 0; loopPrint1 < numPlayers; loopPrint1++) {
			//print hands
			if (loopPrint1 == 0) {
				System.out.println("Your Hands: " + translateCards(loopPrint1) + ", " + translateCards(loopPrint1 + numPlayers));
			}else{
				System.out.println("CPU " + loopPrint1 + ": " + translateCards(loopPrint1) + ", " + translateCards(loopPrint1 + numPlayers));
			}
		}
	}

	public void shuffleDeck() {
		Random rnd = new Random();
		for (int loopCards2 = cards.length - 1; loopCards2 > 0; loopCards2--) {
			int indexCard = rnd.nextInt(loopCards2 + 1);
			int tempCard = cards[indexCard];
			cards[indexCard] = cards[loopCards2];
			cards[loopCards2] = tempCard;
		}
	}

	public void dealCards() {
		for (int loopCards3 = 0; loopCards3 < numPlayers * 2; loopCards3++) {
			cardsSequence.add(cards[index]);
			pop();
		}
	}

	public void flopCards() {
		for (int loopCards4 = 0; loopCards4 < 3; loopCards4++) {
			cardsSequence.add(cards[index]);
			pop();
		}
	}

	public void riverCards() {
		cardsSequence.add(cards[index]);
		pop();
	}

	public void turnCards() {
		cardsSequence.add(cards[index]);
		pop();
	}

	public String translateCards(int indexTrans) {

		String cardSuit = "Spades";
		switch ((int) (cardsSequence.get(indexTrans) / 13)) {
		case 0:
			cardSuit = "Spades";
			break;
		case 1:
			cardSuit = "Hearts";
			break;
		case 2:
			cardSuit = "Clubs";
			break;
		case 3:
			cardSuit = "Diamonds";
			break;
		}
		String cardValue;
		switch (cardsSequence.get(indexTrans) % 13) {
		case 10:
			cardValue = "Jack";
			break;
		case 11:
			cardValue = "Queen";
			break;
		case 12:
			cardValue = "King";
			break;
		case 0:
			cardValue = "Ace";
			break;
		default:
			cardValue = String.valueOf(cardsSequence.get(indexTrans) % 13 + 1);
			break;
		}
		return cardValue + " of " + cardSuit;
	}

	public void pop() {
		index--;
	}
}
