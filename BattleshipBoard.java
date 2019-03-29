import java.util.Scanner;

public class BattleshipBoard{
	String [] [] grid;
	
	static int shipLength;
	static int shipListElement = 1;
	
	/*
	*We make a board.
	*/
	
	public  BattleshipBoard(){
		grid = new String[11][11];
		for (int row = 0; row < 11; row++) {
			for (int column = 0; column < 11; column++) {
				if (row == 0) {
					grid[row][column] = " " + Integer.toString(column) + " ";
				}
				else if(column == 0) {
					grid[row][column] = " " + Integer.toString(row) + " ";
					if(row == 10) {
						grid[row][column] = Integer.toString(row) + " ";
					}
				}
				else {
				grid[row][column] = " . ";
				}
			}
		}
	}
	
	public void boardPrint(){
		for (int row = 0; row < 11; row++){
			for (int column = 0; column < 11; column++){
				System.out.print(grid[row][column]);
			}
			System.out.println();
		}
	}
	
	public String[][] getBoard() {
		return grid;
	}
}