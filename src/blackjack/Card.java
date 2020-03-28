package blackjack;

import java.util.Random;

public class Card {
	
	int[] deck = new int[52];
	
	public Card() {
		for (int i=0; i<deck.length; i++) {
			deck[i] = i;
		}
	}
	
	
	
	public int drow() {
		Random rs = new Random();
		int deckidx = rs.nextInt(51)+1;
		
		int pick = deck[deckidx];//나눠준카
		if(pick == 100)
		{
			System.out.println("이미 뽑은카드");
			return drow();
		}
		
		System.out.println("신규카"+pick);
		deck[deckidx] = 100;//뽑아간 카드들은 100으로 변
		if(pick > 13)
		{
			pick = pick % 13;
		}
		
		return pick;
	}
	

}
