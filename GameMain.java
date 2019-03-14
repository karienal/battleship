import java.util.Scanner;

public class GameMain {
	
	public static Scanner keyboard = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		//Game Set-up
		int turnCount = 1;
		boolean p1Turn = true;
		
		BattleshipBoard player1 = new BattleshipBoard();
		BattleshipBoard player1Enemy = new BattleshipBoard();
		
		BattleshipBoard player2 = new BattleshipBoard();
		BattleshipBoard player2Enemy = new BattleshipBoard();
			
		
		
		//Run Set up
		
		do{
			System.out.println("Player 1, your turn");
			PlayerActions.setUp(player1);
			System.out.println("Player 2, your turn");
			PlayerActions.setUp(player2);
			++turnCount;
		}
		while(turnCount <=2);
		System.out.println("Time to play! WOOOOO!!");
		
		
		boolean winCondition=false;
		//Game Play for Player 1's Turn:
		do{
			int didWin = 0;
      
			/*boolean p1Turn = true;*/

			
			
			
			if (p1Turn ==true){
				System.out.println("Player 1. You have 1 turn. You can attack the enemy, or repair your ship. Do you want to attack the enemy? y/n");
				String playerActionRequest = keyboard.nextLine();
				
				
				boolean actionEqualsAttack = playerActionRequest.contentEquals("y");
				
				if(actionEqualsAttack) {
					System.out.println("Your enemy's board:");
					player1Enemy.boardPrint();
			
					PlayerActions.attack(player2, player1Enemy);
					player1Enemy.boardPrint();
					System.out.println("Your results are above");
					
					}
				else {
					System.out.println("Your board:");
					player1.boardPrint();

					PlayerActions.repair(player1, player2Enemy);

					player1.boardPrint();
					System.out.println("Your results are above");

					}
					
					
				/*Sketchy incomplete win condition. Kind of works sometimes though*/	
				for(int row = 1 ; row < 11 ; row++) {
					for(int column = 1 ; column < 11 ; column++) {

						if(player2.getBoard()[row][column]!= " . "&& player2.getBoard()[row][column]!= " X " && player2.getBoard()[row][column]!= " O " /*&& player2.getBoard()[row][column]!= " S "*/) {
							didWin++;
						}
						else {}
					}
				}

				
					
				p1Turn=false;
				

				
				
				
				}
		
			else{
			
					System.out.println("Player 2. You have 1 turn. You can attack the enemy, or repair your ship. Do you want to attack the enemy? y/n");

					
					String playerActionRequest = keyboard.nextLine();
		
		
		
		

					boolean actionEqualsAttack = playerActionRequest.contentEquals("y");

			
					if(actionEqualsAttack) {
						System.out.println("Your enemy's board:");
						player2Enemy.boardPrint();

						PlayerActions.attack(player1, player2Enemy);

						player2Enemy.boardPrint();
						System.out.println("Your results are above");
						
						}
					else {
						System.out.println("Your board:");
						player2.boardPrint();


						PlayerActions.repair(player2, player1Enemy);

						player2.boardPrint();
						System.out.println("Your results are above");

						}
					
						/*Sketchy incomplete win condition. Kind of works sometimes though*/	
						for(int row = 1 ; row < 11 ; row++) {
							for(int column = 1 ; column < 11 ; column++) {
								if(player1.getBoard()[row][column]!= " . "&& player1.getBoard()[row][column]!= " X " && player1.getBoard()[row][column]!= " O " /*&& player1.getBoard()[row][column]!= " S "*/) {
								didWin++;
							}
							else {}
							}
						}
					

					p1Turn=true;
				
					
				}
				

				/*Sketchy incomplete win condition. Kind of works sometimes though*/	
				if (didWin==0){
					System.out.println("a player has won!");
					winCondition = true;}
				
				

				
				
				
				
				
				
			}
		while(winCondition==false);
	
	}
	

}

