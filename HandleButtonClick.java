import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;

/**
 * This class handles the user's interaction with the graphic interface using mouse button clicks
 * @author Team21
 *
 */

public class HandleButtonClick implements EventHandler<ActionEvent>{
	private Button tf;
	private int row;
	private int column;
	private GameGui gui;
	private String shipChar;
	private String orientation;
	private BattleshipBoard board;
	private int length = GameGui.getLength();
	/*private int shipLength = 5;*/
	private Button[][] gridButtons = new Button[11][11];
	MenuItem menuItem = new MenuItem();
	MenuItem menuD = new MenuItem("Destroyer");
	MenuItem menuS = new MenuItem("Submarine");
	MenuItem menuC = new MenuItem("Cruiser");
	MenuItem menuB = new MenuItem("Battleship");
	MenuItem menuA = new MenuItem("Aircraft Carrier");
	
	
	/**
	 * This method sets the clicked button handle.
	 * @param button
	 */
	public HandleButtonClick(Button button) {
		tf = button;
	}
	
	/**
	 * This method sets the action events for the grid buttons in the game board.
	 */
	public void handle(ActionEvent event) {
		System.out.println("Row: " + GridPane.getRowIndex(tf));
		System.out.println("Column: " + GridPane.getColumnIndex(tf));
		
		row = GridPane.getRowIndex(tf);
		column = GridPane.getColumnIndex(tf);
		/*tf.setStyle(GameGui.getColor());*/
		
		if(GameGui.getOrientation().equals("y")) {
			
			if (row + GameGui.lengthShip < 12){
			
				for(int i = row; i < row + GameGui.lengthShip; i++) {
				
					Button b = GameGui.gridButtons[i][column];
					b.setStyle(GameGui.getColor());
				
				}
			}
		}
		else if(GameGui.getOrientation().equals("x")) {
			
			if (column + GameGui.lengthShip < 12){
			
				for(int i = column; i < column+GameGui.lengthShip; i++) {
					Button b = GameGui.gridButtons[row][i];
					b.setStyle(GameGui.getColor());
				
				}
			}
		}
			
	}
	
}
