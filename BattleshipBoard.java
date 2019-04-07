import java.util.Scanner;

/**
 * Our BattleshipBoard class contains 3 methods that construct a game board, print the
 * game board to the console, and return the game board as a 2D array.
 * @author Team 21
 *
 */

public class BattleshipBoard{
		
	String [] [] grid;
	static int shipLength;
	static int shipListElement = 1;
	
	/**
	*This constructs a 11X11 grid board from a 2D array. The size is 11X11 to account 
	*for 1 numbered row and 1 numbered column, and 10 playable rows and columns. 
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
	
	/**
	 * This method prints the board on the console.
	 */			
	
	public void boardPrint(){
		for (int row = 0; row < 11; row++){
			for (int column = 0; column < 11; column++){
				System.out.print(grid[row][column]);
			}
			System.out.println();
		}
	}
	
	/**
	 * This method returns a 11X11 grid board as a 2D array.
	 */
	public String[][] getBoard() {
		return grid;
	}
}