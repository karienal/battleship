import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Player class is an abstract class that contains the methods for game play that are required
 * for both human-user input and AI generated input.
 * @author Team21
 *
 */
public abstract class Player{
	
	public static Scanner keyboard = new Scanner(System.in);
	
	public BattleshipBoard playerBoard;
	public BattleshipBoard playerDisplayBoard;
	
	public static ArrayList<String> shipList = new ArrayList<String>();
	public static ArrayList<String> shipNameList = new ArrayList<String>();
	
	/**
	 * This method adds the ships to the player board and display board.
	 * @param aPlayerBoard
	 * @param aPlayerDisplayBoard
	 */	
	
	Player (BattleshipBoard aPlayerBoard,BattleshipBoard aPlayerDisplayBoard){
		
		shipNameList.add(0,"Destroyer (Length 2)");
		shipNameList.add(1,"Submarine (Length 3)");
		shipNameList.add(2,"Cruiser (Length 3)");
		shipNameList.add(3,"Battleship (Length 4)");
		shipNameList.add(4,"Aircraft Carrier (Length 5)");
		
		shipList.add("D");
		shipList.add("S");
		shipList.add("C");
		shipList.add("B");
		shipList.add("A");
		
		this.playerBoard= aPlayerBoard;
		this.playerDisplayBoard = aPlayerDisplayBoard;
	}
	
	/**
	 * This method verifies the player's selection for placing the ship on the board is valid, and then saves a
	 * shipChar in the selected tile on the board.
	 * @param aBoard
	 * @param shipChar
	 * @param orientation
	 * @param startRow
	 * @param startColumn
	 */
	public void placeShip(BattleshipBoard aBoard, String shipChar, String orientation, int startRow, int startColumn){

		Ship playerShip = new Ship(shipChar);
		int shipLength = playerShip.aShipCharList.size();

		
		int shipListElement = 1;
	
		if (orientation.equals("y")){
			do{
				aBoard.getBoard()[startRow][startColumn]=" "+shipChar+" ";
				startRow++;
				shipListElement++;
				
				}
			while(shipListElement<=shipLength);	
		}
			
			

		else if(orientation.equals("x")){	
			do{ 
				aBoard.getBoard()[startRow][startColumn] = " " + shipChar + " ";
				startColumn++;
				shipListElement++;
				
				}
			while(shipListElement<=shipLength);
		}
		shipListElement=0;
		playerShip.aShipCharList.clear();			


	}
	/**
	 * This is an abstract method for setting up a board, which is overridden by either the Human or AI class
	 * depending on the type of user that is playing.
	 * @param aPlayerBoard
	 */
	public abstract void setUp(BattleshipBoard aPlayerBoard);
	
	/**
	 * This is an abstract method for running a player's turn, which is overriden by either the Human or AI class
	 * depending on the type of user that is playing.
	 * @param aPlayerBoard
	 * @param aPlayerDisplayBoard
	 * @param anEnemyBoard
	 * @param anEnemyDisplayBoard
	 */
	public abstract void playerTurn(BattleshipBoard aPlayerBoard, BattleshipBoard aPlayerDisplayBoard, BattleshipBoard anEnemyBoard,BattleshipBoard anEnemyDisplayBoard);
	
}