import java.util.ArrayList;
import java.util.*;
import java.util.Dictionary;
public class shipdictionary {
	static int shipLength;
	static int shipListElement = 1;
	
	/**
	 * this creates dictionaries that hold the ship coordinates for rows
	 */
	Hashtable<String, Integer> Dship_row = new Hashtable<String, Integer>();
	Hashtable<String, Integer> Sship_row = new Hashtable<String, Integer>();
	Hashtable<String, Integer> Cship_row = new Hashtable<String, Integer>();
	Hashtable<String, Integer> Bship_row = new Hashtable<String, Integer>();
	Hashtable<String, Integer> Aship_row = new Hashtable<String, Integer>();
	/**
	 * this creates dictionaries that hold the ship coordinates for columns
	 */
	Hashtable<String, Integer> Dship_column = new Hashtable<String, Integer>();
	Hashtable<String, Integer> Sship_column = new Hashtable<String, Integer>();
	Hashtable<String, Integer> Cship_column = new Hashtable<String, Integer>();
	Hashtable<String, Integer> Bship_column = new Hashtable<String, Integer>();
	Hashtable<String, Integer> Aship_column = new Hashtable<String, Integer>();
	/**
	 * This is supposed to get the ship coordinates from ship board before they get placed in. 
	 * I stole this method from battleship board. I am still trying to make it work. 
	 */
	public void ShipCheck(BattleshipBoard aBoard, String shipChar, String orientation, int startRow, int startColumn){
		Ship playerShip = new Ship(shipChar);
		
		shipLength = playerShip.aShipCharList.size();
		/**
		 * this part of the code adds the rows of the ships into the dictionaries.
		 * I use the length of the ship and the orientation with for loops to add the stuff in.
		 * this is used to keep track of where the ship is.
		 */
		if(shipLength==2 && orientation.equals("y")) {
			 for(int i=0; i<2; i++){
	              Dship_row.put("i",startRow);
	              Dship_column.put("i", startColumn);
	              startColumn++;
	         }	
		}
		else if (shipLength==3 && orientation.equals("y") && shipChar.equals("S")||shipChar.equals("s")) {
			 for(int i=0; i<3; i++){
	              Sship_row.put("i",startRow);
	              Sship_column.put("i", startColumn);
	              startColumn++;
	         }	
		}
		else if(shipLength==3 && orientation.equals("y") && shipChar.equals("C") || shipChar.equals("c")) {
			 for(int i=0; i<3; i++){
	              Sship_row.put("i",startRow);
	              Sship_column.put("i", startColumn);
	              startColumn++;
	         }	
		}
		else if (shipLength==4 && orientation.equals("y")&& shipChar.equals("B") || shipChar.equals("b")) {
			 for(int i=0; i<4; i++){
	              Dship_row.put("i",startRow);
	              Dship_column.put("i", startColumn);
	              startColumn++;
	         }	
		}
		else if (shipLength==5 && orientation.equals("y")&& shipChar.equals("A") || shipChar.equals("a")) {
			 for(int i=0; i<5; i++){
	              Dship_row.put("i",startRow);
	              Dship_column.put("i", startColumn);
	              startColumn++;
	         }	
		}
		/**
		 * This part is for when the ships are orientated in the 
		 */
		if(shipLength==2 && orientation.equals("x")) {
			 for(int i=0; i<2; i++){
	              Dship_row.put("i",startRow);
	              Dship_column.put("i", startColumn);
	              startRow++;
	         }	
		}
		else if (shipLength==3 && orientation.equals("x") && shipChar.equals("S")||shipChar.equals("s")) {
			 for(int i=0; i<3; i++){
	              Sship_row.put("i",startRow);
	              Sship_column.put("i", startColumn);
	              startRow++;
	         }	
		}
		else if(shipLength==3 && orientation.equals("x") && shipChar.equals("C") || shipChar.equals("c")) {
			 for(int i=0; i<3; i++){
	              Sship_row.put("i",startRow);
	              Sship_column.put("i", startColumn);
	              startRow++;
	         }	
		}
		else if (shipLength==4 && orientation.equals("x")&& shipChar.equals("B") || shipChar.equals("b")) {
			 for(int i=0; i<4; i++){
	              Dship_row.put("i",startRow);
	              Dship_column.put("i", startColumn);
	              startRow++;
	         }	
		}
		else if (shipLength==5 && orientation.equals("x")&& shipChar.equals("A") || shipChar.equals("a")) {
			 for(int i=0; i<5; i++){
	              Dship_row.put("i",startRow);
	              Dship_column.put("i", startColumn);
	              startRow++;
	         }	
		}
	}

}
