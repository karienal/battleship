import java.util.ArrayList;

public class Ship {
	/*Some instance stuff. A list and whatever. Note that the list */
	ArrayList<String> aShipCharList= new ArrayList<String>();
	public String shipChar;	
	
	/*the ship constructor*/
	Ship(String shipChar){
		
		/*
		*Some super elegant list creation. Hope it doesnt blow your minds.
		*/
			
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
		
		else{
			/*A sarcastic error message I used in debugging*/
			System.out.println("nice try");
		}
	}
}
