/**
 * This class verifies that the tile that is selected by the user is a valid place to set up their ship on their board.
 * @author Team21
 *
 */

public class ShipCheckPlace {
	/**
	 * This method calls the validShipCol, validShipRow, and overlapCheck methods in the ShipCheckPlace class to ensure that all
	 * three allow the ship's valid placement. 
	 * @param aBoard
	 * @param shipChar
	 * @param orientation
	 * @param startRow
	 * @param startCol
	 * @return
	 */
	public boolean shipCheckPlace(BattleshipBoard aBoard, String shipChar, String orientation, int startRow,int startCol){
		boolean validShip=true;
		if(orientation.toUpperCase().equals("Y")) {
			
			validShip = validShipCol(aBoard,shipChar, orientation,startRow,startCol);
			if (validShip == true){
				
			validShip = overlapCheck(aBoard,shipChar,orientation,startRow,startCol);
			}
		}
		else if(orientation.toUpperCase().equals("X")) {
			validShip = validShipRow(aBoard,shipChar, orientation,startRow,startCol);
			
			if (validShip== true){
				
			validShip = overlapCheck(aBoard,shipChar, orientation,startRow,startCol);
			}
		}
		return validShip;
	}
	/**
	 * This method verifies that the column selected by the user is an appropriate column to place this ship (along the x axis).
	 * It returns true if the user has selected an appropriate column.
	 * @param aBoard
	 * @param shipChar
	 * @param orientation
	 * @param startRow
	 * @param startCol
	 * @return
	 */
	public  boolean validShipCol(BattleshipBoard aBoard, String shipChar, String orientation, int startRow,int startCol) {
		boolean placShip = false;
		String shipCheck = shipChar;
		shipCheck.toUpperCase();
		if (orientation.equals("y")|| orientation.equals("Y")) {
			if(shipCheck.equals("D") && startRow<=9) {
				placShip = true;
			}
			else if(shipCheck.contentEquals("S")&& startRow<=8) {
				placShip = true;
			}
			else if(shipCheck.equals("C")&& startRow<=8) {
				 placShip = true;
			}
			else if(shipCheck.equals("B")&& startRow<=7) {
			 	placShip = true;
			}
			else if(shipCheck.equals("A")&& startRow<=6) {
				 placShip = true;
			}
		}
		
		return placShip;
		
	}

	/**
	 * This method verifies that the row selected by the user is an appropriate row to place the ship (along the y axis).
	 * It returns true if the user has selected an appropriate row.
	 * @param aBoard
	 * @param shipChar
	 * @param orientation
	 * @param startRow
	 * @param startCol
	 * @return placeShip
	 */
	public  boolean validShipRow(BattleshipBoard aBoard, String shipChar, String orientation, int startRow, int startCol) {
		boolean placeShip = false;
		String shipCheck = shipChar;
		shipCheck.toUpperCase();
		
		if (orientation.equals("x")|| orientation.equals("X")) {
			if(shipCheck.equals("D") && startCol<=9) {
				 placeShip = true;
			}
			else if(shipCheck.contentEquals("S") && startCol<=8) {
				 placeShip = true;
			}
			else if(shipCheck.equals("C")&& startCol<=8) {
				 placeShip = true;
			}
			else if(shipCheck.equals("B")&&startCol<=7) {
				placeShip = true;
			}
			else if(shipCheck.equals("A")&&startCol<=6) {
				 placeShip = true;
			}
		}
		return placeShip;
	}
	
	/**
	 * This method ensures that the user has not selected a place for the ship that would require the ships overlap
	 * on the board. It returns false if the ships would overlap with the user's selection.
	 * @param aBoard
	 * @param shipChar
	 * @param orientation
	 * @param startRow
	 * @param startCol
	 * @return overlapCheck
	 */
	public boolean overlapCheck(BattleshipBoard aBoard , String shipChar, String orientation,int startRow, int startCol) {
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
			for (shipSpot = startRow; shipSpot <= startRow+shipLength-2; shipSpot++){
					if (aBoard.getBoard()[shipSpot][startCol].equals(" . ")){
						overlapCheck=true;}
					/*
					 * this breaks the loop
					 */
					else{
						overlapCheck=false;
						shipSpot = startRow+shipLength + 1;
						
						}
					}
				}
		if (orientation.equals("x") == true){
			for (shipSpot = startCol; shipSpot <= startCol+shipLength-2; shipSpot++){
					if (aBoard.getBoard()[startRow][shipSpot].equals(" . ")){
						overlapCheck=true;}
					/*
					 * this breaks the loop
					 */
					else{
						overlapCheck=false;
						shipSpot = startCol+shipLength + 1;
						
						}
					}
				}
		return overlapCheck;
	}
	
	
	
}