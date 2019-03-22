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
