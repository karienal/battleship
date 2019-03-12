import java.util.Scanner;

public class GameMain {
	
	public static Scanner keyboard = new Scanner(System.in);
	
	/*A pretty boring main method, but I think it shows that we can create as many boards as we want, and
	*it should be fine. Yet another thing I'm too lazy/afraid to try at the moment.
	*/
	
	
	public static void main(String[] args) {
		
		//Game Set-up
		int turnCount = 1;
		int startRow;
		int startColumn;
		String orientation;
		String shipChar;
		boolean canAShip;
		
		
		BattleshipBoard player1 = new BattleshipBoard();
		BattleshipBoard player2 = new BattleshipBoard();


				
		
		
		
		do{
			 /*canAShip = false;*/
			
			do{
				System.out.println("Player 1 turn");
				System.out.println("What ship do you want to place?");
				shipChar = keyboard.nextLine();
			
				System.out.println("Set the orientation: 'x' for horizontal, 'y' for vertical");
				orientation = keyboard.nextLine();

				System.out.println("Start row of ship?: ");
				startRow=keyboard.nextInt();
			
				System.out.println("Start Colummn of ship?: ");
				startColumn=keyboard.nextInt();
				keyboard.nextLine();
			
				canAShip = player1.validPlaceShip(player1 , startColumn , startRow , shipChar, orientation);
				System.out.println(canAShip);
			}
			
			while(canAShip == false);
					
			player1.placeShip(player1, shipChar, orientation, startRow, startColumn);
			
			
			player1.boardPrint();
			
			
			
			canAShip = false;
			
			do{
				System.out.println("Player 2 turn");
				System.out.println("What ship do you want to place?");
				shipChar = keyboard.nextLine();
			
				System.out.println("Set the orientation: 'x' for horizontal, 'y' for vertical");
				orientation = keyboard.nextLine();

				System.out.println("Start row of ship?: ");
				startRow=keyboard.nextInt();
			
				System.out.println("Start Colummn of ship?: ");
				startColumn=keyboard.nextInt();
				keyboard.nextLine();
				
				canAShip = player2.validPlaceShip(player2, startColumn, startRow, shipChar, orientation);
				System.out.println(canAShip);
			
				
				}
			
			while(canAShip == false);
			
			player2.placeShip(player2, shipChar, orientation, startRow, startColumn);
			player2.boardPrint();
			++turnCount;
			
				
			}
		
		while (turnCount<=2);		
		System.out.println("Time to play!");
		
		
		boolean winCondition=false;
		//Game Play for Player 1's Turn:
		do{
			int didWin = 0;
			boolean p1Turn = true;
			
			int arbitraryTurnCount=0;
			
			if (p1Turn ==true){
				System.out.println("Player 1. You have 1 turn. Do you want to attack the enemy ship or heal your ship?");
				if (arbitraryTurnCount>0){String yJava=keyboard.nextLine();}
				String playerActionRequest = keyboard.nextLine();
		
		
		
		
				int numberOfTurns = 1;
				boolean actionEqualsAttack = playerActionRequest.contentEquals("attack");
				
				if(actionEqualsAttack) {
					System.out.println("Enter the row to attack:");
					int attackRow = keyboard.nextInt();
					System.out.println("Enter the column to attack:");
					int attackColumn = keyboard.nextInt();
					PlayerActions.attack(player2, attackRow, attackColumn);
					--numberOfTurns;
					}
				else {
					System.out.println("Enter the row to heal:");
					int healRow = keyboard.nextInt();
					System.out.println("Enter the column to heal:");
					int healColumn = keyboard.nextInt();
					PlayerActions.heal(player1, healRow, healColumn);
					--numberOfTurns;
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
				arbitraryTurnCount++;
				}
		
			else{
			
					System.out.println("Player 2. You have 1 turn. Do you want to attack the enemy ship or heal your ship?");
					if (arbitraryTurnCount>0){String yJava=keyboard.nextLine();}
					String playerActionRequest = keyboard.nextLine();
		
		
		
		
					int numberOfTurns = 1;
					boolean actionEqualsAttack = playerActionRequest.contentEquals("attack");
			
					if(actionEqualsAttack) {
						System.out.println("Enter the row to attack:");
						int attackRow = keyboard.nextInt();
						System.out.println("Enter the column to attack:");
						int attackColumn = keyboard.nextInt();
						PlayerActions.attack(player1, attackRow, attackColumn);
						--numberOfTurns;
						}
					else {
						System.out.println("Enter the row to heal:");
						int healRow = keyboard.nextInt();
						System.out.println("Enter the column to heal:");
						int healColumn = keyboard.nextInt();
						PlayerActions.heal(player2, healRow, healColumn);
						--numberOfTurns;
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
				System.out.println("Player 1");
				player1.boardPrint();
				System.out.println("Player2");
				player2.boardPrint();
				
				/*Sketchy incomplete win condition. Kind of works sometimes though*/	
				if (didWin==0){
					System.out.println("a player has won!");
					winCondition = true;}
				
				

				
				
				
				
				
				
			}
		while(winCondition==false);
	
	}
	
}
