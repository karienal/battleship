
public class PlayerActions {
	
	int numOfTurns = 1;
	
	public void attack(String[][] enemyBoard, int row, int column) {
		hitOrMiss(enemyBoard, row, column);
		--numOfTurns;
	}
	
	public void hitOrMiss(String[][] enemyBoard, int row, int column) {
		String selectedTile = enemyBoard[row][column];
		if(row > 0 && row < 12) {
			if(column > 0 && column < 12) {
				if(selectedTile == " . ") {
					enemyBoard[row][column] = " O ";
				}
				else {
					enemyBoard[row][column] = " X ";
				}
			}
		}
		
	}
	
	public void heal(String[][] playersBoard, int row, int column) {
		playersBoard[row][column] = " S ";
		--numOfTurns;
	}

}
