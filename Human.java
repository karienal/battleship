import java.util.Scanner;

/**
 * The Human class extends the Player class, and contains the methods for game play that will require
 * human-user input.
 * @author Team21
 *
 */

public class Human extends Player {
	
	public static Scanner keyboard = new Scanner(System.in);
	
	public BattleshipBoard playerBoard;
	public BattleshipBoard playerDisplayBoard;
	
	/**
	 * This method takes 2 boards to set-up a human-user in the game. The first board will be 
	 * the human-user's own board on which they will place their own ships. The second board will display the human-user's
	 * moves on the enemy board.		
	 * @param aPlayerBoard
	 * @param aPlayerDisplayBoard
	 */
	
	public Human (BattleshipBoard aPlayerBoard, BattleshipBoard aPlayerDisplayBoard){
		
		super(aPlayerBoard,aPlayerDisplayBoard);
		
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
	}
	
	/**
	 * This method sets up the human-user's ships on their board, and verifies that the 
	 * human-user's selection for ship placement is valid.
	 */
	public void setUp(BattleshipBoard aPlayerBoard){
		
		ShipCheckPlace checker = new ShipCheckPlace();
		

		
		for (int i = 0; i<5 ; i++){
			boolean validPlace;
			
			
			
			do{
			System.out.println("Place your "+shipNameList.get(i));
			
			System.out.println("Orientation (x/y):");
			String orientation = keyboard.nextLine();
			System.out.println("Starting Row (1-10):");
			int row = keyboard.nextInt();
			keyboard.nextLine();
			System.out.println("Starting Columm (1-10):");
			int column = keyboard.nextInt();
			keyboard.nextLine();
			
			validPlace = checker.shipCheckPlace(aPlayerBoard, shipList.get(i), orientation, row, column);
			if(validPlace){
				super.placeShip(aPlayerBoard, shipList.get(i), orientation, row, column);
				}
			}
			while (!validPlace);
							
			
			aPlayerBoard.boardPrint();
			
						
		}
		
		
	}

	/**
	 * This method play's the human-user's turn, and prompts them to attack or repair. An attack will display on the 
	 * enemy board, and the human-user's display board.
	 * @param aPlayerBoard
	 * @param aPlayerDisplayBoard
	 * @param anEnemyBoard
	 * @param anEnemyDisplayBoard
	 */
	public void playerTurn(BattleshipBoard aPlayerBoard, BattleshipBoard aPlayerDisplayBoard, 
			BattleshipBoard anEnemyBoard, BattleshipBoard anEnemyDisplayBoard){
		
			System.out.println("Action (Attack/repair):");
			String action = keyboard.nextLine();
			System.out.println("Row (1-10):");
			int row = keyboard.nextInt();
			keyboard.nextLine();
			System.out.println("Columm (1-10):");
			int column = keyboard.nextInt();
			keyboard.nextLine();
			
			if (action.equals("attack")){
				attack(anEnemyBoard,aPlayerDisplayBoard,row,column);
				
				
			}
			else{
				repair(aPlayerBoard,anEnemyDisplayBoard,row,column);
			}
			System.out.println("Your enemy's board");
			aPlayerDisplayBoard.boardPrint();
			System.out.println("Your board");
			aPlayerBoard.boardPrint();
		
		
		
	}
		
/**
 * This method determines if the user's attack was a hit or miss, and returns true if attack was a hit.
 * @param enemyBoard
 * @param displayEnemyBoard
 * @param row
 * @param column
 * @return hit
 */
	public static boolean attack(BattleshipBoard enemyBoard, BattleshipBoard displayEnemyBoard, int row, int column) {
		boolean hit = false;
		
		
		String selectedTile = enemyBoard.getBoard()[row][column];
		if(row > 0 && row < 12) {
			if(column > 0 && column < 12) {
				if(selectedTile == " . ") {
					enemyBoard.getBoard()[row][column] = " O ";
					displayEnemyBoard.getBoard()[row][column] = " O ";
					System.out.println("Miss!");
				}
				else if(selectedTile == " O "){
					hit = true;
					enemyBoard.getBoard()[row][column] = " O ";
					displayEnemyBoard.getBoard()[row][column] = " O ";
					
					}
				else if(selectedTile == " R "){
					hit = true;
					enemyBoard.getBoard()[row][column] = " X ";
					displayEnemyBoard.getBoard()[row][column] = " X ";
					System.out.println("Hit!");
				}
				
				else if(selectedTile == " x "){
					hit =true;
					enemyBoard.getBoard()[row][column] = " X ";
					displayEnemyBoard.getBoard()[row][column] = " X ";
					System.out.println("Hit!");
					}
					
				else {
					hit = true;
					enemyBoard.getBoard()[row][column] = " x ";
					displayEnemyBoard.getBoard()[row][column] = " x ";
					System.out.println("Hit!");
				}
			}
		}
		
		return hit;

		
	}
	/**
	 * This method determines if the user's selection to repair the ship is valid, and if so it will repair the
	 * ship tile by changing the token from an x to an R.
	 * @param playersBoard
	 * @param displayBoard
	 * @param row
	 * @param column
	 */
	public static void repair(BattleshipBoard playersBoard,BattleshipBoard displayBoard, int row, int column) {
		if(playersBoard.getBoard()[row][column]== " . " || playersBoard.getBoard()[row][column]== " O "){
			
			System.out.println("Invalid selection, must select a ship tile.");			
			}
		
		else if(playersBoard.getBoard()[row][column]!= " x " && playersBoard.getBoard()[row][column]!= " X "){
			
			System.out.println("Invalid selection, no damage to repair.");
			
			
		}
		else if (playersBoard.getBoard()[row][column] == " x "){
			playersBoard.getBoard()[row][column]= " R " ;
			displayBoard.getBoard()[row][column]= " . " ;
			System.out.println("Ship has been repaired");
				
			}
		
		
		else{System.out.println("Ship is unrepairable. Sorry!");}
		
		}

}