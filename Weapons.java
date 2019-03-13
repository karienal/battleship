
public class Weapons {
	
	
	public static void placeBeacon(BattleshipBoard enemyBoard, BattleshipBoard displayEnemyBoard, int row, int column) {
		String selectedTile = enemyBoard.getBoard()[row][column];
		if(row > 0 && row < 12) {
			if(column > 0 && column < 12) {
				int rowPlus2 = row + 2;
				int columnPlus2 = column + 2;
				while(row <= rowPlus2) {
					while(column <= columnPlus2) {
						if(selectedTile == " . ") {
							enemyBoard.getBoard()[row][column] = " O ";
							displayEnemyBoard.getBoard()[row][column] = " . ";
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
						}
					}
				}
			}
		}
	}
}
