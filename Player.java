import java.util.*;
public abstract class Player {
	private BattleshipBoard myBoard = new BattleshipBoard();
	private BattleshipBoard yourBoard = new BattleshipBoard();
	private ArrayList<String> shipList = new ArrayList<String>();
	private ArrayList<String> shipNameList = new ArrayList<String>();
	
	private static int row = 1;
	private static int column = 1;
	private static String axis;
	public static Scanner keyboard = new Scanner(System.in);

	private String destroyer = "D";
	private String submarine = "S";
	private String cruiser =  "C";
	private String battleship = "B";
	private String aircraftCarrier = "A";

	public Player(BattleshipBoard myBoard, BattleshipBoard yourBoard) {

		shipNameList.add("Destroyer (Length 2)");
		shipNameList.add("Submarine (Length 3)");
		shipNameList.add("Cruiser (Length 3)");
		shipNameList.add("Battleship (Length 4)");
		shipNameList.add("Aircraft Carrier (Length 5)");
		
		shipList.add(destroyer);
		shipList.add(submarine);
		shipList.add(cruiser);
		shipList.add(battleship);
		shipList.add(aircraftCarrier);

		this.myBoard = myBoard;
		this.yourBoard = yourBoard;
	}
	
	public abstract void setUp(BattleshipBoard myBoard);

	public abstract void attack();

	public void attack(String weapon) {
		if (weapon == "default") {
			attack();
		}
		if (weapon == "beacon") {
			int row = getRow();
			int column = getColumn();
			placeBeacon(myBoard, yourBoard, row, column);
		}
		/*if (weapon == "plus") { no code for the + attack yet
			plusAttack();
		}*/
	}
	//I suggest moving this to HitOrMiss, but I'm unsure
	public void placeBeacon(BattleshipBoard enemyBoard, BattleshipBoard displayEnemyBoard, int row, int column) {
		String selectedTile = enemyBoard.getBoard()[row][column];
		if(row > 0 && row < 12) {
			if(column > 0 && column < 12) {
				int rowPlus2 = row + 2;
				int columnPlus2 = column + 2;
				while(row <= rowPlus2) {
					while(column <= columnPlus2) {
						if(selectedTile == " . ") {
							enemyBoard.getBoard()[row][column] = " O ";
							displayEnemyBoard.getBoard()[row][column] = " . ";
						}
						else if(selectedTile == " O "){
							enemyBoard.getBoard()[row][column] = " O ";
							displayEnemyBoard.getBoard()[row][column] = " O ";
						}
						else if(selectedTile == " R "){
							enemyBoard.getBoard()[row][column] = " X ";
							displayEnemyBoard.getBoard()[row][column] = " X ";
						}
						else {
							enemyBoard.getBoard()[row][column] = " x ";
							displayEnemyBoard.getBoard()[row][column] = " x ";
						}
					}
				}
			}
		}

	}

	public abstract void repair();
	
	public ArrayList<String> getShipList() {
		return shipList;
	}
	public BattleshipBoard getMyBoard() {
		return myBoard;
	}
	public BattleshipBoard getYourBoard() {
		return yourBoard;
	}
	
	public static void setRowAndColumn() {
		System.out.println("What row do you want to place your ship? (1-10)");
		row = keyboard.nextInt();
		System.out.println("What column do you want to place your ship? (1-10)");
		column = keyboard.nextInt();
	}
	
	public static int getRow() {
		return row;
	}
	
	public static int getColumn() {
		return column;
	}
	
	public static void setOrientation() {
		System.out.println("What orientation do you want to place your ship? (x or y)");
		 axis = keyboard.nextLine().toUpperCase();
	}
	
	public static String getOrientation() {
		return axis;
	}
}
