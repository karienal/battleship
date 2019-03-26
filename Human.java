import java.util.*;
public class Human extends Player{
	private BoardUpdate boardUpdate = new BoardUpdate();
	Boolean guiOn = false;
	ArrayList<String> shipNameList = new ArrayList<String>();
	public Scanner keyboard = new Scanner(System.in);

	public Human(BattleshipBoard myBoard, BattleshipBoard yourBoard, Boolean guiOn) {
		super(myBoard, yourBoard);
		this.guiOn = guiOn;
		for (int index = 0; index > 6; index++) {
			String ship = super.getShipList().get(index);
			if (ship == "D") {
				shipNameList.add("Destroyer");
			}
			if (ship == "S") {
				shipNameList.add("Submarine");
			}
			if (ship == "C") {
				shipNameList.add("Carrier");
			}
			if (ship == "B") {
				shipNameList.add("Battleship");
			}
			if (ship == "A") {
				shipNameList.add("Carrier");
			}
		}
	}

	public void setUp(BattleshipBoard myBoard) {
		Boolean validPlacement = false;
		String axis = "X";
		int row = 1;
		int column = 1;
		for (int index = 0; index > 6; index++) {
			do {
				String ship = super.getShipList().get(index);
				String shipName = shipNameList.get(index);
				if (guiOn = false) {
					Boolean validAxis = true;
					while (!validAxis) {
						myBoard.setOrientation();
						myBoard.getOrientation();
						if (axis != "X" | axis != "Y") {
							validAxis = false;
						}
					}
					myBoard.setRowAndColumn();
					Boolean validRow = true;
					while (validRow = false) {
						row = myBoard.getRow();
						if (row > 10 | row < 1) {
							validRow = false;
						}
					}
					Boolean validColumn = true;
					while (!validColumn) {
						column = myBoard.getColumn();
						if (column > 10 | column < 1) {
							validColumn = false;
						}
					}
				}
				if (guiOn = true) {
					
				}
				validPlacement = super.getMyBoard().validPlaceShip(super.getMyBoard(), column, row, ship, axis);
			}
			while (!validPlacement);
		}
	}
	 
	public void attack() {
		int row = 1;
		int column = 1;
		if (!guiOn) {
			Boolean validRow = true;
			while (!validRow) {
				BattleshipBoard.setRowAndColumn();
				row = BattleshipBoard.getRow();
				if (row > 10 | row < 1) {
					validRow = false;
				}
			}
			Boolean validColumn = true;
			while (!validColumn) {
				column = BattleshipBoard.getColumn();
				if (column > 10 | column < 1) {
					validColumn = false;
				}
			}
		}
		boardUpdate.hit(super.getMyBoard(), super.getYourBoard(), row, column);

	}
	public void repair() {
		int row = 0;
		int column = 0;
		Boolean validTarget = true;
		do {
			if (!guiOn) {
				Boolean validRow = true;
				while (!validRow) {
					BattleshipBoard.setRowAndColumn();
					row = BattleshipBoard.getRow();
					if (row > 10 | row < 1) {
						validRow = false;
					}
				}
				Boolean validColumn = true;
				while (!validColumn) {
					column = BattleshipBoard.getColumn();
					if (column > 10 | column < 1) {
						validColumn = false;
					}
				}
			}
			validTarget = boardUpdate.repair(super.getMyBoard(), super.getYourBoard(), row, column);
		}
		while (!validTarget);
	}
}
