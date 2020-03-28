package blackjack;

import java.util.Scanner;

public class Application {

   public static void main(String[] args) {
   //testtest
      Logic logic = new Logic();
      System.out.println("참가할 유저 인원 수를 입력해주세요.");
      Scanner sc = new Scanner(System.in);
      int usersum = sc.nextInt();
      if(logic.next == 0) {
    	  
    	  logic.AddUser(usersum);
          logic.turn();
          logic.AlluserCard();
          logic.gostop();
      }
     while(logic.next > 0 || logic.next != -1) { 
      logic.turn();
      logic.AlluserCard();
      logic.gostop();
     }
   }

}