import java.util.*;
public class PlayerActions {
	
	
	public static void attack(BattleshipBoard enemyBoard, BattleshipBoard displayEnemyBoard, int row, int column) {
		hitOrMiss(enemyBoard, displayEnemyBoard, row, column);
		
	}
	
	public static void hitOrMiss(BattleshipBoard enemyBoard, BattleshipBoard displayEnemyBoard, int row, int column) {
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
				System.out.println("Hit!");
				}
				
				else if(selectedTile == " x "){
				enemyBoard.getBoard()[row][column] = " X ";
				displayEnemyBoard.getBoard()[row][column] = " X ";
				System.out.println("Hit!");
					}
					
				else {
					enemyBoard.getBoard()[row][column] = " x ";
					displayEnemyBoard.getBoard()[row][column] = " x ";
					System.out.println("Hit!");
				}
			}
		}
		
	}
	
	public static void heal(BattleshipBoard playersBoard,BattleshipBoard displayBoard, int row, int column) {
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
