import java.util.Scanner;

public class GameMain {
	
	public static Scanner keyboard = new Scanner(System.in);
	
	/*A pretty boring main method, but I think it shows that we can create as many boards as we want, and
	*it should be fine. Yet another thing I'm too lazy/afraid to try at the moment.
	*/
	
	public static void main(String[] args) {
		int turnCount = 1;
			
		BattleshipBoard player1 = new BattleshipBoard();
		BattleshipBoard player2 = new BattleshipBoard();
			
		do{
			System.out.println("Player 1 turn");
			System.out.println("What ship do you want to place?");
			String shipChar = keyboard.nextLine();
			
			System.out.println("Set the orientation: 'x' for horizontal, 'y' for vertical");
			String orientation = keyboard.nextLine();

			System.out.println("Start row of ship?: ");
			int startRow=keyboard.nextInt();
			
			System.out.println("Start Colummn of ship?: ");
			int startColumn=keyboard.nextInt();
			keyboard.nextLine();
			
			BattleshipBoard.placeShip(player1, shipChar, orientation, startRow, startColumn);
			
			
			
			System.out.println("Player 2 turn");
			System.out.println("What ship do you want to place?");
			shipChar = keyboard.nextLine();
			
			System.out.println("Set the orientation: 'x' for horizontal, 'y' for vertical");
			orientation = keyboard.nextLine();

			System.out.println("Start row of ship?: ");
			startRow=keyboard.nextInt();
			
			System.out.println("Start Colummn of ship?: ");
			startColumn=keyboard.nextInt();
			keyboard.nextLine();
			BattleshipBoard.placeShip(player2, shipChar, orientation, startRow, startColumn);
			
			++turnCount;
			
				
		}
		while (turnCount<=5);		
		System.out.println("Time to play!");
		}
	
	
	
	

}
