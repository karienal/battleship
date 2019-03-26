import java.util.Arrays;
import java.util.Scanner;

public class GameMain {
	
	public static Scanner keyboard = new Scanner(System.in);
	private int difficultyLevel;
	private boolean player1Turn = true;
	private static BattleshipBoard board1 = new BattleshipBoard();
	private static BattleshipBoard displayBoard1 = new BattleshipBoard();
	private	static BattleshipBoard board2 = new BattleshipBoard();
	private static BattleshipBoard displayBoard2 = new BattleshipBoard();
	
	private static Player player1;
	private static Player player2;
	
	public GameMain() {
		player1 = new Human(board1, displayBoard1, false);
		boolean compPlayer = true;
		System.out.println("Play against computer? (y/n)");
		String messageResponse = keyboard.nextLine().toUpperCase();
		if(messageResponse == "Y") {
			System.out.println("Set difficulty level: (1,2,or 3)");
			difficultyLevel = keyboard.nextInt();
			compPlayer = true;
			
		}else {
			compPlayer = false;
		}
		if(compPlayer == true) {
			player2 = new AI(board2, displayBoard2, difficultyLevel);
		}else {
			player2 = new Human(board2, displayBoard2, false);
		}
		
	}
	
	public void playGame() {
		while(!gameOver(board1)) {
			while(!gameOver(board2)) {
			Player currentPlayer;
			if(player1Turn) {
				currentPlayer = player1;
				player1Turn = false;
			}else {
				currentPlayer = player2;
				player1Turn = true;
			}
			currentPlayer.getMyBoard().boardPrint();
			System.out.println("Do you want to attack? y/n");
			String turnSelect = keyboard.nextLine();
			if(turnSelect == "Y") {
			currentPlayer.attack();
			}else {
			currentPlayer.repair();		
			}
			}
		}
	}
		
	//https://stackoverflow.com/questions/3571945/find-if-a-string-is-present-in-an-array
	
	public boolean gameOver(BattleshipBoard aBoard) {
		boolean gameOver = false;
		if(Arrays.asList(aBoard).contains(" D ")) {}
		else if(Arrays.asList(aBoard).contains(" S ")) {}
		else if(Arrays.asList(aBoard).contains(" C ")) {}
		else if(Arrays.asList(aBoard).contains(" B ")) {}
		else if(Arrays.asList(aBoard).contains(" A ")) {}
		else if(Arrays.asList(aBoard).contains(" R ")) {}
		else {
			gameOver = true;
		}				
		return gameOver;
	}
	
	public static void main(String[] args) {
		GameMain game = new GameMain();
		player1.getMyBoard().boardPrint();
		player1.setUp(board1);
		player2.getMyBoard().boardPrint();
		player2.setUp(board2);
		game.playGame();
	}
}
