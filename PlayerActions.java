import java.util.*;
public class PlayerActions {
	
	public static Scanner keyboard = new Scanner(System.in);
	
	
	public static void setUp(BattleshipBoard playerBoard) {
		boolean canAShip;
		System.out.println("What ship do you want to place?");
		String shipChar = keyboard.nextLine();
	
		System.out.println("Set the orientation: 'x' for horizontal, 'y' for vertical");
		String orientation = keyboard.nextLine();

		System.out.println("Start row of ship?: ");
		int startRow=keyboard.nextInt();
	
		System.out.println("Start Column of ship?: ");
		int startColumn=keyboard.nextInt();
		keyboard.nextLine();
	
		canAShip = playerBoard.validPlaceShip(playerBoard , startColumn , startRow , shipChar, orientation);
		if(canAShip) {
			playerBoard.placeShip(playerBoard, shipChar, orientation, startRow, startColumn);
			playerBoard.boardPrint();
		}
		else {
			System.out.println("Your ship will not fit there. Please try again.");
			setUp(playerBoard);
		}
		
			
	}
	
	public static void attack(BattleshipBoard enemyBoard, BattleshipBoard displayEnemyBoard, int row, int column) {
		
		hitOrMiss(enemyBoard, displayEnemyBoard, row, column);
		
	}
	
	public static Boolean hitOrMiss(BattleshipBoard enemyBoard, BattleshipBoard displayEnemyBoard, int row, int column) {
		Boolean hitToken = false;
		String selectedTile = enemyBoard.getBoard()[row][column];
		if(row > 0 && row < 12) {
			if(column > 0 && column < 12) {
				if(selectedTile == " . ") {
					enemyBoard.getBoard()[row][column] = " O ";
					displayEnemyBoard.getBoard()[row][column] = " O ";
					System.out.println("Miss!");
										
				}
				else if(selectedTile == " O "){
					enemyBoard.getBoard()[row][column] = " O ";
					displayEnemyBoard.getBoard()[row][column] = " O ";
					}
					else if(selectedTile == " R "){
					enemyBoard.getBoard()[row][column] = " X ";
					displayEnemyBoard.getBoard()[row][column] = " X ";
					}
				else {
					enemyBoard.getBoard()[row][column] = " x ";
					displayEnemyBoard.getBoard()[row][column] = " x ";
					hitToken = true;
					System.out.println("Hit!");

				}
			}
		}
		return hitToken;
	}
	

	public static void repair(BattleshipBoard playersBoard,BattleshipBoard displayBoard, int row, int column) {

		if(playersBoard.getBoard()[row][column]== " . " || playersBoard.getBoard()[row][column]== " O "){
			
			System.out.println("You cant heal water though...");			
			}
		
		else if(playersBoard.getBoard()[row][column]!= " x " && playersBoard.getBoard()[row][column]!= " X "){
			
			System.out.println("Chill, your ship is fine.");
			
			
		}
		else if (playersBoard.getBoard()[row][column] == " x "){
			playersBoard.getBoard()[row][column]= " R " ;

			displayBoard.getBoard()[row][column]= " . " ;

				
			}
		
		
		else{System.out.println("She broke.");}
		
		}

}
