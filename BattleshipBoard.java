
public class BattleshipBoard{
	static String [] [] grid;
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
	
	/*
	*And make a ship to be placed. It is to be noted that aShipCharList comes from 
	*the Ship class
	*/

	public static void placeShip(BattleshipBoard aBoard, String shipChar, String orientation, int startRow, int startColumn){
		Ship playerShip = new Ship(shipChar);
		shipLength = playerShip.aShipCharList.size();
			
		/*
		*Start working with the input.
		*/
		
		if (orientation.equals("y")){
			do{ 
				grid[startRow][startColumn]=" "+playerShip.aShipCharList.get(shipListElement-1)+" ";
				startRow++;
				shipListElement++;
				
				}
			while(shipListElement<=shipLength);	
		}
			
			
		/*
		*The same thing, except here the token exchange moves through the columns instead of the rows. I think something about
		*what is a row and what is a column is a bit backwards here, but it works so...
		*/
		else if(orientation.equals("x")){	
			do{ 
				grid[startRow][startColumn] = " " + playerShip.aShipCharList.get(shipListElement - 1) + " ";
				startColumn++;
				shipListElement++;
				
				}
			while(shipListElement<=shipLength);
		}
	shipListElement=1;
	playerShip.aShipCharList.clear();			
	aBoard.boardPrint();
	}
	
	/* boardPrint prints the board. Go figure.*/
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
