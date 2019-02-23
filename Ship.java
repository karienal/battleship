
public class Ship extends BattleshipBoard {
	
	private int shipLength = 0;
	private int startColumn = 0;	
	private int startRow = 0;	
	private int endColumn = 0;	
	private int endRow = 0;
	private String shipChar = "0";
	private String shipName = "default ship";
	//private int health = 0;
	//private int beacon = 0;
	
	private Ship() {
		shipLength = 0;
		shipChar = "default ship";
		
	}
	
	private Ship(int lengthGiven) {
		Boolean makeSubmarine = true;
		if(lengthGiven == 2) {
			shipLength = 2;
			shipChar = "1";
			shipName = "Destroyer";
		}
		else if(lengthGiven == 3) {
			shipLength = 3;
			
			if(makeSubmarine) {
				shipChar = "2";
				shipName = "Submarine";
				makeSubmarine = false;
			}
			else {
				shipChar = "3";
				shipName = "Cruiser";
				makeSubmarine = true;
			}
			
		}
		else if(lengthGiven == 4) {
			shipLength = 4;
			shipChar = "4";
			shipName = "Battleship";
		}
		else if(lengthGiven == 5) {
			shipLength = 5;
			shipChar = "5";
			shipName = "Carrier";
		}
		
		
	}	
}
