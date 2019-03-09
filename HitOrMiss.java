
public class HitOrMiss {
	
	static Boolean hitToken;
	
	public static Boolean hitOrMiss(String[][] enemyBoard, int row, int column) {
		String selectedTile = enemyBoard[row][column];
		if(row > 0 && row < 12) {
			if(column > 0 && column < 12) {
				if(selectedTile == " . ") {
					hitToken = false;
					enemyBoard[row][column] = " O ";
					System.out.println("Miss!");
				}
				else {
					hitToken = true;
					enemyBoard[row][column] = " X ";
					System.out.println("Hit!");
				}
			}
		}
		return hitToken;
	}
	
}
