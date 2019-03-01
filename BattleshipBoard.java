import java.util.Scanner;

public class BattleshipBoard{
	String [] [] grid;
	Scanner keyboard = new Scanner(System.in);
	
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
	*...and place a ship
	*/

	public void placeShip(BattleshipBoard aBoard){
		/*
		*Some instance variables. Pretty straightforward I think.
		*/
		int shipLength;
		int shipListElement = 1;

		/*
		* Get some input 
		*/
		System.out.println("What ship do you want to place?");
		String shipChar = keyboard.nextLine();
		
		System.out.println("Set the orientation: 'x' for horizontal, 'y' for vertical");
		String orientation = keyboard.nextLine();
	
		System.out.println("Start Colummn of ship?: ");
		int startColumn=keyboard.nextInt();
		
		System.out.println("Start row of ship?: ");
		int startRow=keyboard.nextInt();
		keyboard.nextLine();
			
		/*
		*And make a ship to be placed. It is to be noted that aShipCharList comes from 
		*the Ship class
		*/
			
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
	
	
	
	/*A pretty boring main method, but I think it shows that we can create as many boards as we want, and
	*it should be fine. Yet another thing I'm too lazy/afraid to try at the moment.
	*/
	public static void main(String[] args) {
	int turnCount = 1;
		
	BattleshipBoard b1 = new BattleshipBoard();
	BattleshipBoard b2 = new BattleshipBoard();
		
	do{
		System.out.println("Player 1 turn");
		b1.placeShip(b1);
		System.out.println("Player 2 turn");
		b2.placeShip(b2);
		++turnCount;
			
	}
	while (turnCount<=5);		
	System.out.println("Time to play!");
	}
}
