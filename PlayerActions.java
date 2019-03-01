import java.util.Arrays;

public class PlayerActions {
	
	int numOfTurns = 3;
	
	public static String[][] moveShip(String[][] aBoard, String aShip, String moveOrientation) {
		String[][] moveShipOnBoard = new String[11][11];
		String orientation = moveOrientation;
		Ship playerShip = new Ship(aShip);
		int shipLength = playerShip.aShipCharList.size();
		int shipListElement = 1;
		
		for (int row = 0; row < 11; row++) {
			for (int column = 0; column < 11; column++) {
				moveShipOnBoard[row][column] = aBoard[row][column];
			}
		}
		
		for (int row = 0; row < 11; row++) {
			for (int column = 0; column < 11; column++) {		
				if(moveShipOnBoard[row][column] == aShip) {
					if (orientation.equals("u")){
						//moveShipOnBoard[row - 1][column] = " " +playerShip.aShipCharList.get(shipListElement-1)+ " ";
						//moveShipOnBoard[row][column] = " . ";
						//--row;
						//moveShipOnBoard[row][column] = " " +playerShip.aShipCharList.get(shipListElement-1)+ " ";
						//++row;
						//moveShipOnBoard[row][column] = " . ";
					}
					
					else if(orientation.equals("d")){
						do{ 
							moveShipOnBoard[row][column] = " . ";
							moveShipOnBoard[row + 1][column]=" "+playerShip.aShipCharList.get(shipListElement-1)+" ";
							row++;
							shipListElement++;
							
							}
						while(shipListElement<=shipLength);
						
						
					}
					
					else if(orientation.equals("l")){
						moveShipOnBoard[row - 1][column] = aShip;
						
					}
					
					else if(orientation.equals("r")){
						moveShipOnBoard[row + 1][column] = aShip;
						
					}
					
					else {
						System.out.print("Try again");
					}
					
				}
				
				System.out.print(moveShipOnBoard[row][column]);
			}
			System.out.println();
		
			
		}
		if (orientation.equals("u")){
			for (int row = 0; row < 11; row++) {
				for (int column = 0; column < 11; column++) {
					
				}
				}
			
		}
		return moveShipOnBoard;
	}
	
	
	public void attack() {
		HitOrMiss.trueHit(0,0);
	}
	

	
	public static void main(String[] args) {

		System.out.println("You have 3 turns");
		String[][] testList = new String[11][11];
		for (int row = 0; row < 11; row++) {
			for (int column = 0; column < 11; column++) {
				if(column == 3 && row == 3) {
					testList[row][column] = "b";
				}
				else {
				testList[row][column] = " c ";
				}
			}
		}
		moveShip(testList, "b", "u");
		

	}

}
