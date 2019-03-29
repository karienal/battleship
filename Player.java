import java.util.ArrayList;
import java.util.Scanner;

public abstract class Player{
	
	public static Scanner keyboard = new Scanner(System.in);
	
	public BattleshipBoard playerBoard;
	public BattleshipBoard playerDisplayBoard;
	
	public static ArrayList<String> shipList = new ArrayList<String>();
	public static ArrayList<String> shipNameList = new ArrayList<String>();
	
	
	
	
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
	

	public abstract void setUp(BattleshipBoard aPlayerBoard);
	
	public abstract void playerTurn(BattleshipBoard aPlayerBoard, BattleshipBoard aPlayerDisplayBoard, BattleshipBoard anEnemyBoard);
	
}