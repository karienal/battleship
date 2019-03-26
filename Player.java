import java.util.*;
public abstract class Player {
	private BattleshipBoard myBoard = new BattleshipBoard();
	private BattleshipBoard yourBoard = new BattleshipBoard();
	private ArrayList<String> shipList = new ArrayList<String>();

	private String destroyer = "D";
	private String submarine = "S";
	private String cruiser =  "C";
	private String battleship = "B";
	private String aircraftCarrier = "A";

	public Player(BattleshipBoard myBoard, BattleshipBoard yourBoard) {

		shipList.add(destroyer);
		shipList.add(submarine);
		shipList.add(cruiser);
		shipList.add(battleship);
		shipList.add(aircraftCarrier);

		this.myBoard = myBoard;
		this.yourBoard = yourBoard;
		setUp(myBoard);
	}
	public abstract void setUp(BattleshipBoard myBoard);

	public abstract void attack();

	public void attack(String weapon) {
		if (weapon == "default") {
			attack();
		}
		if (weapon == "beacon") {
			placeBeacon();
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
	
	
}
