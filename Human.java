import java.util.*;
public class Human extends Player{
	ShipCheckPlace checkShips = new ShipCheckPlace();
	private BoardUpdate BoardUpdate = new BoardUpdate();
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
		/**
		Boolean validPlacement = false;
		String axis = "X";
		String shipChar = "";
		int row = 0;
		int column = 0;
		for (int index = 0; index > 6; index++) {
			do {
				String ship = super.getShipList().get(index);
				String shipName = shipNameList.get(index);
				if (!guiOn) {
					Boolean validAxis = false;
					while (!validAxis) {
						Player.setOrientation();
						Player.getOrientation();
						if (axis != "X" | axis != "Y") {
							validAxis = false;
						}
					}
					Player.setRowAndColumn();
					Boolean validRow = false;
					while (!validRow) {
						row = Player.getRow();
						if (row > 10 | row < 1) {
							validRow = false;
						}
					}
					Boolean validColumn = false;
					while (!validColumn) {
						column = Player.getColumn();
						if (column > 10 | column < 1) {
							validColumn = false;
						}
					}
				}
				validPlacement = checkShips.shipCheckPlace(super.getMyBoard(), shipChar, Player.getOrientation(), Player.getRow(), Player.getColumn());
			}
			while (!validPlacement);
		} */
		for (int i=0; i<6; i++){
			System.out.println("Where to you want to place your "+ shipNameList[i]);
			myBoard.setRowAndColumn();
			
		}
		System.out.print(myBoard.getRow()+ myBoard.getColumn());
	}
	 
	public void attack() {
		int row = 1;
		int column = 1;
		if (!guiOn) {
			Boolean validRow = true;
			while (!validRow) {
				Player.setRowAndColumn();
				row = Player.getRow();
				if (row > 10 | row < 1) {
					validRow = false;
				}
			}
			Boolean validColumn = true;
			while (!validColumn) {
				column = Player.getColumn();
				if (column > 10 | column < 1) {
					validColumn = false;
				}
			}
		}
		BoardUpdate.hit(super.getMyBoard(), super.getYourBoard(), row, column);

	}
	public void repair() {
		int row = 0;
		int column = 0;
		Boolean validTarget = true;
		do {
			if (!guiOn) {
				Boolean validRow = true;
				while (!validRow) {
					Player.setRowAndColumn();
					row = Player.getRow();
					if (row > 10 | row < 1) {
						validRow = false;
					}
				}
				Boolean validColumn = true;
				while (!validColumn) {
					column = Player.getColumn();
					if (column > 10 | column < 1) {
						validColumn = false;
					}
				}
			}
			validTarget = BoardUpdate.repair(super.getMyBoard(), super.getYourBoard(), row, column);
		}
		while (!validTarget);
	}
}
