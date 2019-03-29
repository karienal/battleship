import java.util.Scanner;

public class Human extends Player {
	
	public static Scanner keyboard = new Scanner(System.in);
	
	public BattleshipBoard playerBoard;
	public BattleshipBoard playerDisplayBoard;
	
	
	
	
	
	
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

	
	public void playerTurn(BattleshipBoard aPlayerBoard, BattleshipBoard aPlayerDisplayBoard, BattleshipBoard anEnemyBoard, BattleshipBoard anEnemyDisplayBoard){
		
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
	
	public static void repair(BattleshipBoard playersBoard,BattleshipBoard displayBoard, int row, int column) {
		if(playersBoard.getBoard()[row][column]== " . " || playersBoard.getBoard()[row][column]== " O "){
			
			System.out.println("You cant repair water though...");			
			}
		
		else if(playersBoard.getBoard()[row][column]!= " x " && playersBoard.getBoard()[row][column]!= " X "){
			
			System.out.println("Chill, your ship is fine.");
			
			
		}
		else if (playersBoard.getBoard()[row][column] == " x "){
			playersBoard.getBoard()[row][column]= " R " ;
			displayBoard.getBoard()[row][column]= " . " ;
				
			}
		
		
		else{System.out.println("She broke.");}
		
		}

}