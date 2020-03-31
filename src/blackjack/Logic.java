package blackjack;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Logic {
	   
	   //최대참가 가능한 수8로 유저 배열 생성 
	   Client[] user = new Client[8];
	   Card card = new Card();
	   int next;

	   
	   Logic() {
	      for (int i = 0; i < user.length; i++) {
	         user[i] = null;
	      }
	      next = 0;
	   }
	   
	   //유저 추가
	   public void AddUser(int usersum) {
	      for (int j = 0; j < usersum; j++) {
	         user[j] = new Client();
	         user[j].usernum = j;
	         user[j].use = 1;
	         System.out.println(j+"번째 유저가 참가하였습니다.");
	      }
	      
	   }
	 
	   //회
	   public void turn() {
		   if(next == 0)//1회차 
		   {
			   for (int i = 0; i < user.length; i++) {
				   if(user[i] != null) {
					   int ca =card.drow();
					   user[i].card.add(ca);
					   
				   }
				   
			}
			
		   }
		   else
		   {
			   for (int i = 0; i < user.length; i++) {
				   if(user[i] != null) {
					   if(user[i].use == 1)
					   {
					   int ca =card.drow();
					   user[i].card.add(ca);
					   int sum = 0;
					   for(Integer c : user[i].card) {
							sum=c+sum;
						}
					   if(sum > 21) {
						   user[i].use = 0;
					   }
					   
					   
					   }
				   }
				   }
		   }
		   
	   }
	  
	   
	  public void AlluserCard() {
		  for (int i = 0; i < user.length; i++) {
			  if(user[i] != null) {
				   user[i].ShowCard();
				   
			   }
		}
		//next = next+1;//턴 증
	  }
	   
	  public void gostop()
	  {
		  for (int i = 0; i < user.length; i++) {
			  if(user[i] != null) {
				  if(user[i].use == 1)
				  {
				  System.out.println(i+"번째 유저가 go,stop 입력 .");
				  Scanner sc2 = new Scanner(System.in);
			      String results = sc2.nextLine();
			      if((results).equals("go")) {
			    	  user[i].use = 1;
			      }
			      else if((results).equals("stop"))
			      {
			    	  user[i].use = 0;
			      }
			      System.out.println(i+"번째 유저가 "+results+"입력했습니다  .");
				  }
			   }
			  }
		  next = next +1;
		  System.out.println("최종점수 계산. ");
		  int end=0;
		  for (int i = 0; i < user.length; i++) {
			  if(user[i] != null) {
			  if(user[i].use == 0)
			  {
				  end=end+1;
			  }
			  }
		  }
		 int usercnt = usercount();
		 int win = -1;
		  int winpoint = 0;
		  
		  if(usercnt == end) {
			 //종료  
			  next = -1;
			  for (int i = 0; i < user.length; i++) {
				  if(user[i] != null) {
				  int sum = 0;
				for(Integer c : user[i].card) {
					sum=c+sum;
				}
				System.out.println(i+"유저의 카드합 "+sum);
					if(i==0)
					{
						if(sum < 22) {
						win = i;
						winpoint = sum;
						}
					}
					else
					{
						if(sum <22 && win == -1)
						{
							if(winpoint < sum)
							{
								win = i;
								winpoint = sum;
							}
						}
					}
				
				//최종승
				
				  
				  }
			  }
		  }
		  if(win != -1)
			  System.out.println(win+"번째 유저가 최종승 .");
		  else
			  System.out.println("무승부 ");
		 return;
	  }
	  
	  public int usercount() {
		  int usercnt = 0;
		  for (int i = 0; i < user.length; i++) {
			  if(user[i] != null) {
				  usercnt++;
			  }
		  }
		  return usercnt;
	  }
	  
	  
}
