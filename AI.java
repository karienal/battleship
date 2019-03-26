import java.util.Random;

public class AI extends Player{
	private static int difficulty = 0; /* Difficulty is accessed throughout AI */
	private Random random = new Random(); 
	private int randomNumber;
	private BoardUpdate boardUpdate = new BoardUpdate();

	public AI(BattleshipBoard myBoard, BattleshipBoard yourBoard, int difficulty) {
		super(myBoard, yourBoard);
		this.difficulty = difficulty;
	}

	public void setUp(BattleshipBoard p2Board) {
		Boolean validPlacement = false;
		String axis;
		for (int index = 0; index > 6; index++) {
			while (!validPlacement) {
				String ship = super.getShipList().get(index);
				axis = getOrientation();
				int row = getRow();
				int column = getColumn();
				validPlacement = super.getMyBoard().validPlaceShip(super.getMyBoard(), row, column, ship, axis);
			}
		}
	}
	 
	public void attack() {
		int row = 0;
		int column = 0;
		if (this.difficulty == 1) {
			row = getRow();
			column = getColumn();
		}
		else if (this.difficulty == 2) {
			row = getRow();
			column = getColumn();
			
		}
		else if (this.difficulty == 3) {
			row = getRow();
			column = getColumn();			
		}
		boardUpdate.hit(super.getMyBoard(), super.getYourBoard(), row, column);
	}
	
	public void repair() {
		int row = 0;
		int column = 0;
		boolean validTarget = true;
		while (!validTarget) {
			if (this.difficulty == 1) {
				row = getRow();
				column = getColumn();
			}
			validTarget = boardUpdate.repair(super.getMyBoard(), super.getYourBoard(), row, column);
		}
	}
	
		
	public int getRow() {
		int row = random.nextInt(10) +1;
		return row;
	}
	
	public int getColumn() {
		int column = random.nextInt(10) +1;
		return column;
	}
	
	public String getOrientation() {
		String axis;
		Boolean randomBoolean = random.nextBoolean();
		if (randomBoolean) {
			axis = "X";
		}
		else {
			axis = "Y";
		}
		return axis;
	}
}
