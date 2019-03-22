import java.util.Random;

public class AI extends Player{
	private static int difficulty = 0; /* Difficulty is accessed throughout AI */
	private Random random = new Random(); 
	private int randomNumber;
	private HitOrMiss hitOrMiss = new HitOrMiss();

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
				Boolean randomBoolean = random.nextBoolean();
				if (randomBoolean) {
					axis = "x";
				}
				else {
					axis = "y";
				}
				int row = random.nextInt(10) + 1;
				int column = random.nextInt(10) + 1;
				validPlacement = super.getMyBoard().validPlaceShip(super.getMyBoard(), column, row, ship, axis);
			}
		}
	}
	 
	public void attack() {
		int row = 0;
		int column = 0;
		if (this.difficulty == 1) {
			row = random.nextInt(10) + 1;
			column = random.nextInt(10) + 1;
		}
		else if (this.difficulty == 2) {
			//unimplemented, need info on intended AI behaviour.
		}
		else if (this.difficulty == 3) {
			//unimplemented, need info on inteded AI behaviour.
		}
		hitOrMiss.hit(super.getMyBoard(), super.getYourBoard(), row, column);
	}
	public void repair() {
		int row = 0;
		int column = 0;
		while (!validTarget) {
			if (this.difficulty == 1) {
				row = random.nextInt(10) + 1;
				column = random.nextInt(10) + 1;
			}
			validTarget = hitOrMiss.repair(super.getMyBoard(), super.getYourBoard(), row, column);
		}
	}
}
