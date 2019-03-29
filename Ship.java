import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;


public class Ship {

	ArrayList<String> aShipCharList= new ArrayList<String>();
	public String shipChar;	
	
	/*The method used to generate ships to be placed on the board.
	@param shipChar A string containing a single character,  used  generate ships of appropriate size and character
	*/
	Ship(String shipChar){
		
		
		if (shipChar.equals("D") || shipChar.equals("d")){
			
			aShipCharList.add("D");
			aShipCharList.add("D");
		}
		
		else if (shipChar.equals("s") || shipChar.equals("S")){
				
			aShipCharList.add("S");
			aShipCharList.add("S");
			aShipCharList.add("S");
			
		}
		else if (shipChar.equals("c") || shipChar.equals("C")){
		
			aShipCharList.add("C");
			aShipCharList.add("C");
			aShipCharList.add("C");
			
		}
		
		else if (shipChar.equals("B") || shipChar.equals("b")){
		
			aShipCharList.add("B");
			aShipCharList.add("B");
			aShipCharList.add("B");
			aShipCharList.add("B");
			
		}
		
		else if (shipChar.equals("A") || shipChar.equals("a")){
		
			aShipCharList.add("A");
			aShipCharList.add("A");
			aShipCharList.add("A");
			aShipCharList.add("A");
			aShipCharList.add("A");
		}
		
		
	}
}