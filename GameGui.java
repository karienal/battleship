import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Our GameGui class creates 2 scenes to display to the user for the Battleship Board Game. It also includes getter
 * methods for color, orientation, and ship length.
 * @author Team 21
 *
 */
    
    public class GameGui extends Application {   
    	public Button tf;
    	public static Button[][] gridButtons = new Button[11][11];
    	public static int shipLength;
    	public static int lengthShip;
    	public static String color;
    	public static String orientation;
		public int confirmClick = 0;
    	MenuItem menuD = new MenuItem("Destroyer");
    	MenuItem menuS = new MenuItem("Submarine");
    	MenuItem menuC = new MenuItem("Cruiser");
    	MenuItem menuB = new MenuItem("Battleship");
    	MenuItem menuA = new MenuItem("Aircraft Carrier");
    	
    	MenuItem x = new MenuItem("Along the row");
    	MenuItem y = new MenuItem("Along the column");
		
	   	
    	/**
    	 * This method creates the first introductory screen displayed to the user, the second scene that 
    	 * displays the board to the user to allow for game set-up and game play
    	 */

        @Override
        public void start(Stage primaryStage) {

            int SIZE = 11;
            int length = SIZE;
            int width = SIZE;
            
            //Scene 1
            
            StackPane root2 = new StackPane();
    		//https://stackoverflow.com/questions/9738146/javafx-how-to-set-scene-background-image
    		StackPane sp = new StackPane();
    		//http://blog.adw.org/2018/05/church-cruise-ship-battleship/
            BackgroundImage myBI= new BackgroundImage(new Image("battleship_image.jpg",1000, 900,false,true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                      BackgroundSize.DEFAULT);
            sp.setBackground(new Background(myBI));
            root2.getChildren().add(sp);

            BorderPane border2 = new BorderPane();
            Label label1 = new Label("BattleShip");
            label1.setPadding(new Insets(100, 10, 10, 210));
            label1.setFont(Font.font("Copperplate", FontWeight.EXTRA_BOLD, 100));
            label1.setTextFill(Color.WHITE);
            border2.setTop(label1);
            
            HBox hbox = new HBox();
            Button button = new Button("Play");
            //http://www.learningaboutelectronics.com/Articles/How-to-create-multiple-scenes-and-switch-between-scenes-in-JavaFX.php
//            button.setOnAction(e -> primaryStage.setScene(scene2));
            
            hbox.setPadding(new Insets(100, 10, 371, 435));
            //http://tutorials.jenkov.com/javafx/button.html
            button.setStyle("-fx-text-fill: navy; -fx-font-size: 4em; -fx-background-color: white");
            border2.setBottom(hbox);
            hbox.getChildren().add(button);
            root2.getChildren().add(border2);
            
    		Scene scene1 = new Scene(root2, 1000, 900);
            
            // Scene 2
            
            BorderPane border = new BorderPane();
            HBox titlePane = new HBox();
            titlePane.setPadding(new Insets(50, 100, 50, 100));
            titlePane.setSpacing(50);
            /*titlePane.getChildren().add(new Label ("Main Game Play Board"));*/
			Label boardTitle = new Label ("Player 1 Set Up");
            titlePane.getChildren().add(boardTitle);
            border.setTop(titlePane);
            GridPane root = new GridPane();
            border.setCenter(root);
            VBox leftPane = new VBox();
            leftPane.setPadding(new Insets(50, 50, 50, 50));
            leftPane.setSpacing(10);
            border.setLeft(leftPane);

            
            for(int y = 0; y < length; y++){
                for(int x = 0; x < width; x++){
                	

                	tf = new Button();
                    tf.setPrefHeight(50);
                    tf.setPrefWidth(50);
                    tf.setAlignment(Pos.CENTER);
                    tf.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-background-color: white;");

                    if (y == 0) {
    					tf.setText(" " + Integer.toString(x) + " ");

    				}
    				else if(x == 0) {
    					tf.setText(" " + Integer.toString(y) + " ");
    					
    					    				}
    					    					
    				else {
    					tf.setText("   ");
 						HandleButtonClick handle = new HandleButtonClick(tf);
    					tf.setOnAction(handle);
   
    				}
                  
                    gridButtons[y][x] = tf;
                    root.add(gridButtons[y][x], y, x); 

//                    
                    // Iterate the Index using the loops
                    root.setRowIndex(tf,y);
                    root.setColumnIndex(tf,x);   
                    
    				}
            }
            
                HBox playerConsole = new HBox();
                playerConsole.setPadding(new Insets(50, 100, 50, 100));
                playerConsole.setSpacing(10);
                border.setBottom(playerConsole);
				Button confirmButton = new Button("Confirm");
                playerConsole.getChildren().addAll(new Button("Attack Enemy"), new Button("Heal Ship"),confirmButton);
                
				
				
                VBox place = new VBox();
                place.setPadding(new Insets(10, 100, 10, 10));
                place.setSpacing(10);
                border.setRight(place);
                
                //https://stackoverflow.com/questions/39163881/javafx-drop-down-button
                MenuButton menuButton = new MenuButton("Ships");

                menuButton.getItems().add(menuD);
                menuD.setOnAction(event -> {color = "-fx-background-color: purple; -fx-border-color: black; -fx-border-width: 2px;";
                lengthShip = 2;
				menuButton.setText("Destroyer");
                });
                menuButton.getItems().add(menuS);
                menuS.setOnAction(event -> {color = "-fx-background-color: green; -fx-border-color: black; -fx-border-width: 2px;";
				menuButton.setText("Submarine");
                lengthShip = 3;
                });
                menuButton.getItems().add(menuC);
                menuC.setOnAction(event -> {color = "-fx-background-color: orange; -fx-border-color: black; -fx-border-width: 2px;";
				menuButton.setText("Cruiser");
                lengthShip = 3;
                });
                menuButton.getItems().add(menuB);
                menuB.setOnAction(event -> {color = "-fx-background-color: pink; -fx-border-color: black; -fx-border-width: 2px;";
				menuButton.setText("Battleship");
                lengthShip = 4;
                });
                menuButton.getItems().add(menuA);
                menuA.setOnAction(event -> {color = "-fx-background-color: lime; -fx-border-color: black; -fx-border-width: 2px;";
				menuButton.setText("Aircraft Carrier");
                lengthShip = 5;
                });
                
                MenuButton rotate = new MenuButton("Orientation");
                rotate.getItems().add(x);
                x.setOnAction(event -> {
					rotate.setText("Along Row");
					orientation = "x";});
                rotate.getItems().add(y);
                y.setOnAction(event -> {
					rotate.setText("Along Column");
					orientation = "y";});

                place.getChildren().add(rotate);
                place.getChildren().add(menuButton);
                
            
            Scene scene2 = new Scene(border, 900, 900);  
  
            button.setOnAction(e -> primaryStage.setScene(scene2));
			
			

			confirmButton.setOnAction(e -> {
			if (confirmClick == 0){
					
				for(int y = 0; y < length; y++){
					for(int x = 0; x < width; x++){
						
						gridButtons[x][y].setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-background-color: white;");
						
						
					}
				}

				boardTitle.setText("Player 2 Set Up");
				confirmClick++;
			}
			else{boardTitle.setText("Time to play!");}
			
			});
			
			
			
            
            primaryStage.setTitle("Awesome Battleship Game");
            primaryStage.setScene(scene1);
            primaryStage.show();
            
        }
		
	       
        /**
         * This method returns the colour that the button will be changed to in HandleButtonClick when one
         * of the grid buttons is clicked.
         * @return color
         */
        
        public static String getColor() {
        	return color;
        }
        
        /**
         * This method returns the orientation that is selected by the user during game set-up.
         * @return orientation
         */
        public static String getOrientation() {
        	return orientation;
        }
        
        
        /**
         * This method returns the length of the ship being placed so the correct number of buttons change
         * colour during set-up.
         * @return lengthShip
         */
        public static int getLength() {
        	return lengthShip;
        }
              
        public static void main(String[] args) {    
            launch(args);
        }    
    }
