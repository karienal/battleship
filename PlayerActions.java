import java.util.*;
public class PlayerActions {
	
	
	public static void attack(BattleshipBoard enemyBoard, int row, int column) {
		hitOrMiss(enemyBoard, row, column);
		
	}
	
	public static void hitOrMiss(BattleshipBoard enemyBoard, int row, int column) {
		String selectedTile = enemyBoard.getBoard()[row][column];
		if(row > 0 && row < 12) {
			if(column > 0 && column < 12) {
				if(selectedTile == " . ") {
					enemyBoard.getBoard()[row][column] = " O ";
				}
				else if(selectedTile == " O "){
					enemyBoard.getBoard()[row][column] = " O ";
					}
					else if(selectedTile == " R "){
					enemyBoard.getBoard()[row][column] = " X ";
					}
				else {
					enemyBoard.getBoard()[row][column] = " x ";
				}
			}
		}
		
	}
	
	public static void heal(BattleshipBoard playersBoard, int row, int column) {
		if(playersBoard.getBoard()[row][column]== " . " || playersBoard.getBoard()[row][column]== " O "){
			
			System.out.println("You cant heal water though...");			
			}
		
		else if(playersBoard.getBoard()[row][column]!= " x " && playersBoard.getBoard()[row][column]!= " X "){
			
			System.out.println("Chill, your ship is fine.");
			
			
		}
		else if (playersBoard.getBoard()[row][column] == " x "){
			playersBoard.getBoard()[row][column]= " R " ;
				
			}
		
		
		else{System.out.println("She broke.");}
		
		}

}
