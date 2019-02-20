import java.util.Scanner;




public class BattleshipBoard{
	String [] [] grid;
	Scanner keyboard = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		/*String[][] grid = new String[10][10];
		for (int row = 0; row < 10; row++) {
			for (int column = 0; column < 10; column++) {
				grid [row][column] = args[row*10+column].charAt(0);
			}*/
		
		BattleshipBoard b1 = new BattleshipBoard();
		
		b1.print();
		b1.placeShip(" s ", b1);
		b1.print();



	}
	
	
	public  BattleshipBoard(){
		grid = new String[10][10];
		for (int row = 0; row < 10; row++) {
			for (int column = 0; column < 10; column++) {
				grid[row][column] = " . ";
			}
		}
	}
	public  BattleshipBoard(String [][] newGrid){
		for (int row = 0; row < 10; row++) {
			for (int column = 0; column < 10; column++) {
				if (newGrid[row][column]!= ".")
				{
					grid[row][column] = newGrid[row][column];
				}
			}
		}
	}

	
	
	
	/*When Placing ships, the "Start" variables must be a smaller integer than "End" variables. The row variables must be the same if 
	 the ship is to be placed horizontally, the column variables must be the same if ship is to be placed vertically. All elements in the 1 dimensional subset of the two dimensional space, between
	 deined endpoints, will be transformed into the current placeholder ship token 's' . */
	
	
	public  void placeShip(String shipChar,BattleshipBoard b1){
		
	
		System.out.println("Place ship of length 4 MOTHER FUCKKAAAAA");
		System.out.println("");
		
		System.out.println("Start Colummn of ship?: ");
		int startColumn=keyboard.nextInt();
		
		System.out.println("Start row of ship?: ");
		int startRow=keyboard.nextInt();
		
		System.out.println("End Colummn of ship?: ");
		int endColumn=keyboard.nextInt();
		
		System.out.println("End row of ship?: ");
		int endRow=keyboard.nextInt();
		
		
		
	
		if (  startColumn == endColumn)
		{
			
			do{ 
				grid[startColumn-1][startRow-1]=shipChar;
				startRow++;
			}
			while (startRow<=endRow);			
		}
			

			
		else if (  startRow == endRow)
		{
			
			do{ 
				grid[startColumn-1][startRow-1]=shipChar;
				startColumn++;
			}
			while (startColumn<=endColumn);
			
		}
		
		else{
			System.out.println("You blew it");
			}
		}

	
	
/*	public boolean isEmpty(int row, int column){
		return grid[row][column] == " . ";
	}*/
	
	
	public void print(){
		for (int row = 0; row < 10; row++){
			for (int column = 0; column < 10; column++){
				System.out.print(grid[row][column]);
			}
			System.out.println();
		}
	}
	
}