import java.util.Arrays;
import java.util.Scanner;

public class GameMain{
	
	public static Scanner keyboard = new Scanner(System.in);
	private int difficultyLevel;
	/*private boolean player1Turn = true;*/
	private static BattleshipBoard board1 = new BattleshipBoard();
	private static BattleshipBoard displayBoard1 = new BattleshipBoard();
	private	static BattleshipBoard board2 = new BattleshipBoard();
	private static BattleshipBoard displayBoard2 = new BattleshipBoard();
	
	private static Player player1;
	private static Player player2;
	
	
	public GameMain() {
		
		
		player1 = new Human(board1, displayBoard1);
		boolean compPlayer = false;
		System.out.println("Play against computer? (y/n)");
		String messageResponse = keyboard.nextLine().toUpperCase();
		if(messageResponse.equals("Y")) {
			System.out.println("Set difficulty level: (1,2,or 3)");
			difficultyLevel = keyboard.nextInt();
			compPlayer = true;
			
		}
		else {
			compPlayer = false;
		}
		if(compPlayer == true) {
			/*player2 = new AI(board2, displayBoard2);*/
		}else {
			player2 = new Human(board2, displayBoard2);
		}
	}
		
		
	public static boolean gameOver(BattleshipBoard aBoard) {
		boolean gameOver = false;
		BattleshipBoard checkBoard = aBoard;
		if(Arrays.asList(checkBoard).contains(" D ")) {}
		else if(Arrays.asList(checkBoard).contains(" S ")) {}
		else if(Arrays.asList(checkBoard).contains(" C ")) {}
		else if(Arrays.asList(checkBoard).contains(" B ")) {}
		else if(Arrays.asList(checkBoard).contains(" A ")) {}
		else if(Arrays.asList(checkBoard).contains(" R ")) {}
		else {
			gameOver = true;
		}				
		return gameOver;
	}
	
	public static boolean gameOver2(BattleshipBoard aBoard){
		boolean gameOver = true;
		int didWin =0 ;
		for(int row = 1 ; row < 11 ; row++) {
			for(int column = 1 ; column < 11 ; column++) {
				if(aBoard.getBoard()[row][column]!= " . "&& aBoard.getBoard()[row][column]!= " X " && aBoard.getBoard()[row][column]!= " O " && aBoard.getBoard()[row][column]!= " x ") {
					didWin++;
				}
				else {}
			}
		}
		if (didWin>0){ gameOver = false;}
		
		return gameOver;
		
	}

		
	public static void main(String[] args) {
		GameMain game = new GameMain();
		boolean gameContinue=true;
		
		System.out.println("Player 1 Set-Up");
		player1.setUp(board1);
		System.out.println("Player 2 Set-Up");
		player2.setUp(board2);
		
		do{
			System.out.println("Player 1 turn");
			player1.playerTurn(board1,displayBoard1,board2);
			if (!gameOver2(board2)){
				System.out.println("Player 2 turn");
				player2.playerTurn(board2,displayBoard2,board1);
				
				if(gameOver2(board1)){
					gameContinue = false;
				}
			
							
			}
			else{gameContinue = false;}
		
			
		}
		while(gameContinue = true);
		
		System.out.println("Game Over!");
		
		
		
		
	}

	
}