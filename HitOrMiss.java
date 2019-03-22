import java.util.Random;

public class HitOrMiss{

	public Boolean hit(BattleshipBoard enemyBoard, BattleshipBoard displayEnemyBoard, int row, int column) {
		String selectedTile = enemyBoard.getBoard()[row][column];
		Boolean hitToken = false;
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
	public Boolean repair(BattleshipBoard playersBoard,BattleshipBoard displayEnemyBoard, int row, int column) {
		Boolean repairToken = false;
		if(playersBoard.getBoard()[row][column]== " . " || playersBoard.getBoard()[row][column]== " O "){
			System.out.println("You cant heal water though...");			
		}
		else if(playersBoard.getBoard()[row][column]!= " x " && playersBoard.getBoard()[row][column]!= " X "){
			System.out.println("Chill, your ship is fine.");
		}
		else if (playersBoard.getBoard()[row][column] == " x "){
			playersBoard.getBoard()[row][column]= " R " ;
			displayEnemyBoard.getBoard()[row][column]= " . " ;
			repairToken = true;
			}
		else {
			System.out.println("She broke.");
		}
		return repairToken;
	}
}