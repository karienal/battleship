import java.util.*;
public class Human extends Player{
	private HitOrMiss hitOrMiss = new HitOrMiss();
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
				if (!guiOn) {
					Boolean validAxis = true;
					while (!validAxis) {
						BattleshipBoard.setOrientation();
						BattleshipBoard.getOrientation();
						if (axis != "X" | axis != "Y") {
							validAxis = false;
						}
					}
					BattleshipBoard.setRowAndColumn();
					Boolean validRow = true;
					while (!validRow) {
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
		hitOrMiss.hit(super.getMyBoard(), super.getYourBoard(), row, column);

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
			validTarget = hitOrMiss.repair(super.getMyBoard(), super.getYourBoard(), row, column);
		}
		while (!validTarget);
	}
}
