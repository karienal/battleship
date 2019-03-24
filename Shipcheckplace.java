
public class Shipcheckplace {
	
	public  boolean validShip(BattleshipBoard aBoard,int startCol, int startRow, String shipChar , String orientation) {
		boolean placeship = false;
		String shipCheck = shipChar;
		shipCheck.toUpperCase();
		if (orientation.equals("y")|| orientation.equals("Y")) {
			if(shipCheck.equals("D") && startCol<=9) {
				return placeship = true;
			}
			else if(shipCheck.contentEquals("S")&& startCol<=8) {
				return placeship = true;
			}
			else if(shipCheck.equals("C")&& startCol<=8) {
				return  placeship = true;
			}
			else if(shipCheck.equals("B")&& startCol<=7) {
				return  placeship = true;
			}
			else if(shipCheck.equals("A")&& startCol<=6) {
				return  placeship = true;
			}
		}
		if (orientation.equals("x")|| orientation.equals("X")) {
			if(shipCheck.equals("D") && startRow<=9) {
				return placeship==true;
			}
			else if(shipCheck.contentEquals("S") && startRow<=8) {
				return placeship==true;
			}
			else if(shipCheck.equals("C")&& startRow<=8) {
				return placeship==true;
			}
			else if(shipCheck.equals("B")&&startRow<=7) {
				return placeship==true;
			}
			else if(shipCheck.equals("A")&&startRow<=6) {
				return placeship==true;
			}
		}
		return placeship;
	}
	
}
