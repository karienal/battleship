import java.util.Random;

public class AI {
	int difficulty = 1;
	//https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
	Random rand = new Random();
	int randomNumber = rand.nextInt((10 - 1) + 1) + 1;
	
	
	public AI(BattleshipBoard enemyBoard, BattleshipBoard displayEnemyBoard, int diff) {
		String orientation = getOrientation(randomNumber);
		BattleshipBoard aiBoard = new BattleshipBoard();
		aiBoard.placeShip(aiBoard, "A", orientation, randomNumber, randomNumber);
		aiBoard.placeShip(aiBoard, "B", orientation, randomNumber, randomNumber);
		aiBoard.placeShip(aiBoard, "S", orientation, randomNumber, randomNumber);
		aiBoard.placeShip(aiBoard, "C", orientation, randomNumber, randomNumber);
		aiBoard.placeShip(aiBoard, "D", orientation, randomNumber, randomNumber);
		
		if(diff >=1 && diff <= 3) {
			if(diff == 1) {
				difficulty = 1;
				PlayerActions.aiAttack(enemyBoard, displayEnemyBoard, randomNumber, randomNumber);
					//aiAttack recieves randomNumber for now
			}
			else if(diff == 2) {
				difficulty = 2;
				if(randomNumber % 2 == 0) {
					PlayerActions.aiAttack(enemyBoard, displayEnemyBoard, randomNumber, randomNumber);
					//aiAttack recieves randomNumber for now
					
				}
				else {
					int row = 0;
					int column = 0;
					PlayerActions.aiAttack(enemyBoard, displayEnemyBoard, randomNumber, randomNumber);
					//aiAttack recieves randomNumber for now
				}
			}
			else {
				difficulty = 3;
				for (int row = 0; row < 11; row++){
					for (int column = 0; column < 11; column++){
						if(PlayerActions.hitOrMiss(aiBoard, displayEnemyBoard, row, column)) {
							PlayerActions.repair(aiBoard, displayEnemyBoard);
						}
						else {
							if(randomNumber % 2 == 0) {
								PlayerActions.aiAttack(enemyBoard, displayEnemyBoard, randomNumber, randomNumber);
								//aiAttack recieves randomNumber for now
							}
							else {
								row = randomNumber;
								column = randomNumber;
								PlayerActions.aiAttack(enemyBoard, displayEnemyBoard, randomNumber, randomNumber);
								//aiAttack recieves randomNumber for now
							}
					
						}
					}
				}
			}
		}
	}
	
	public String getOrientation(int rand) {
		String orientation = "x";
		if(rand % 2 == 0) {
			orientation = "y";
		}
		return orientation;
	}
}
