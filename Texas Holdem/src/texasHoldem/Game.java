package texasHoldem;

public class Game {
	int[][] cards = new int[4][13];
	public Game(){
		//0-3 is Diamond, Club, Heart, and Spade, respectively
		//0-12 is 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, and Ace, respectively.
		for(int loopCards1 = 0; loopCards1 < 4; loopCards1++){
			for(int loopCards2 = 0; loopCards2 < 13; loopCards2++){
				cards[loopCards1][loopCards2] = loopCards2 % 13;
				//System.out.println(cards[loopCards1][loopCards2]);
			}
		}
		
	}
}
