import java.util.Random;

public class BoardUpdate{

	public Boolean hit(BattleshipBoard enemyBoard, BattleshipBoard displayEnemyBoard, int row, int column) {
		String selectedTile = enemyBoard.getBoard()[row][column];
		Boolean hitToken = false;
		if(row > 0 && row < 12) {
			if(column > 0 && column < 12) {
				if(selectedTile == " . ") {
					enemyBoard.getBoard()[row][column] = " O ";
					displayEnemyBoard.getBoard()[row][column] = " O ";
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
				}
			}
		}
		return hitToken;
	}

	public Boolean repair(BattleshipBoard playersBoard,BattleshipBoard displayEnemyBoard, int row, int column) {
		String selectedTile = playersBoard.getBoard()[row][column];
		Boolean repairToken = false;
		if (row > 0 & row < 12) {
			if (column > 0 & column < 12)
				if(selectedTile == " . " || playersBoard.getBoard()[row][column]== " O ") {
					repairToken = false;
				}
				else if(selectedTile != " x " && playersBoard.getBoard()[row][column]!= " X ") {
					repairToken = false;
				}
				else if (selectedTile == " x "){
					playersBoard.getBoard()[row][column]= " R " ;
					displayEnemyBoard.getBoard()[row][column]= " . " ;
					repairToken = true;
				}
		}
		return repairToken;
	}

	public Boolean beacon() {
		return true;
		
	}
}