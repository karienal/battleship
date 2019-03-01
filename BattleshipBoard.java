import java.util.Scanner;
import java.util.ArrayList;




public class BattleshipBoard{
	String [] [] grid;
	Scanner keyboard = new Scanner(System.in);
	
	/*
	*We make a board.
	*/
	
	public  BattleshipBoard(){
		grid = new String[10][10];
		for (int row = 0; row < 10; row++) {
			for (int column = 0; column < 10; column++) {
				grid[row][column] = " . ";
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
		
		boolean anotherShip= true;
		int shipLength;
		int shipListElement = 1;

		
		
		do{
			/*
			* Get some input 
			*/
			System.out.println("What the ship?!");
			String shipChar = keyboard.nextLine();
			
			System.out.println(" 'x' for horizontal, 'y' for vertical");
			String orientation = keyboard.nextLine();
		
			System.out.println("Start Colummn of ship?: ");
			int startColumn=keyboard.nextInt();
		
			System.out.println("Start row of ship?: ");
			int startRow=keyboard.nextInt();
			
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
			
			/*
			*I cant remember exactly why I set the element to 1 originally and now am subtracting 1 in use, but I'm too lazy
			* and afraid to change it now to see if it still works or if this is necessary still.
			*/
				do{ 
					grid[startRow-1][startColumn-1]=" "+playerShip.aShipCharList.get(shipListElement-1)+" ";
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
					grid[startRow-1][startColumn-1]=" "+playerShip.aShipCharList.get(shipListElement-1)+" ";
					startColumn++;
					shipListElement++;
				
				}
				while(shipListElement<=shipLength);
			}
			
			/* Look at the board*/
			aBoard.boardPrint();

			
			

			/*You wannanotha ship? */
			System.out.println("u wannanotha?");
			/*This line does virtually nothing, but without it, java skips over the nex input line because java makes the rules
			* and doesnt care if they make any sense.*/
			String whyUDoThisJava=keyboard.nextLine();
			
			
			String anotha=keyboard.nextLine();
			
			
			if (anotha.equals("n")){
				
				anotherShip=false;
			}
			/*when prompted, only 'n' finishes the ship placemeent. anything else lets you keep goin*/
			
			else{
				anotherShip=true;
				shipListElement=1;
				playerShip.aShipCharList.clear();
			}
			
			
		}
		while(anotherShip==true);
		
		aBoard.boardPrint();
	}
	
	/* boardPrint prints the board. Go figure.*/
	public void boardPrint(){
		for (int row = 0; row < 10; row++){
			for (int column = 0; column < 10; column++){
				System.out.print(grid[row][column]);
			}
			System.out.println();
		}
	}
	
	
	
	/*A pretty boring main method, but I think it shows that we can create as many boards as we want, and
	*it should be fine. Yet another thing I'm too lazy/afraid to try at the moment.
	*/
	public static void main(String[] args) {

		BattleshipBoard b1 = new BattleshipBoard();
		b1.placeShip(b1);
		

	}
}