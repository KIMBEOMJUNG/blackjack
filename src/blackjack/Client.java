package blackjack;

import java.util.LinkedList;

public class Client {
   
   public Client() {
      use = -1;
      usernum = -1;
   }
   
   //유저가 가진 카드 패
   LinkedList<Integer> card = new LinkedList<Integer>();
   int use; //0이면 스톱 1이면 고
   int usernum; //유저번호
   
   public void ShowCard() {
	   System.out.println(usernum+"번 유저"+"보유카드 :"+card);
   }

}