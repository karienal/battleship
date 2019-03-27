public class Shipcheckplace {
	
	public  boolean validShipCol(BattleshipBoard aBoard, String orientation, int startRow,int startCol,  String shipChar ) {
		boolean placShip = false;
		String shipCheck = shipChar;
		shipCheck.toUpperCase();
		if (orientation.equals("y")|| orientation.equals("Y")) {
			if(shipCheck.equals("D") && startRow<=9) {
				return placShip = true;
			}
			else if(shipCheck.contentEquals("S")&& startRow<=8) {
				return placShip = true;
			}
			else if(shipCheck.equals("C")&& startRow<=8) {
				return  placShip = true;
			}
			else if(shipCheck.equals("B")&& startRow<=7) {
			 	return  placShip = true;
			}
			else if(shipCheck.equals("A")&& startRow<=6) {
				return  placShip = true;
			}
		}
		
		return placShip;
		
	}
	/*
	 * this checks for bounds for the bounds on the y axis
	 */
	public  boolean validShipRow(BattleshipBoard aBoard,int startCol, int startRow, String shipChar , String orientation) {
		boolean placeShip = false;
		String shipCheck = shipChar;
		shipCheck.toUpperCase();
		
		if (orientation.equals("x")|| orientation.equals("X")) {
			if(shipCheck.equals("D") && startCol<=9) {
				return placeShip==true;
			}
			else if(shipCheck.contentEquals("S") && startCol<=8) {
				return placeShip==true;
			}
			else if(shipCheck.equals("C")&& startCol<=8) {
				return placeShip==true;
			}
			else if(shipCheck.equals("B")&&startCol<=7) {
				return placeShip==true;
			}
			else if(shipCheck.equals("A")&&startCol<=6) {
				return placeShip==true;
			}
		}
		return placeShip;
	}
	public boolean overlapCheck(BattleshipBoard aBoard,int startCol, int startRow, String shipChar , String orientation) {
		boolean overlapCheck = false;
		int shipSpot;
		
		Ship playerShip = new Ship(shipChar);
		
		int shipLength = playerShip.aShipCharList.size()+1;
		/*
		 * this is a for loop that checks for overlap for the ships
		 * the loop will break and return the overlapCheck if it has found a overlap.
		 * this only checks if the y orientation is over laping with another ship.
		 */
		if (orientation.equals("y") == true){
			for (shipSpot = startRow; shipSpot <= startRow+shipLength; shipSpot++){
					if (aBoard.getBoard()[shipSpot][startCol]!=" . "){
						overlapCheck=false;}
					/*
					 * this breaks the loop
					 */
					else{
						overlapCheck=true;
						shipSpot = startRow+shipLength + 1;
						
						}
					}
				}
		if (orientation.equals("x") == true){
			for (shipSpot = startCol; shipSpot <= startCol+shipLength; shipSpot++){
					if (aBoard.getBoard()[startRow][shipSpot]!=" . "){
						overlapCheck=false;}
					/*
					 * this breaks the loop
					 */
					else{
						overlapCheck=true;
						shipSpot = startCol+shipLength + 1;
						
						}
					}
				}
		return overlapCheck;
	}
	
	
	
}