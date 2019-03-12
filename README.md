# [BATTLESHIP](https://github.com/karienal/battleship) 
A board game based off of the hit Hasbro® board game!

Welcome to our little Battleship clone! It has our own little additions compared to the original game, but it should still be just as fun! 

## Installation:
  1. Ensure that the [Java Platform](https://www.oracle.com/technetwork/java/javase/downloads/index.html) is downloaded and installed.
  2. Click the Clone or Download button and choose to download as a zip file.
  3. Open the folder in your Terminal/Command Prompt and run ```javac *.java```.
  4. Run the file with ```java GameMain```.

## Rules of the Game:
1. Each player will place their five ships on the board.
   i) Input is delivered by console commands in the current build. A starting row, column  and orientation will be provided by the user
       and the ship will be placed such that the tiles occupied increase positively. (Board has labled numbers and columns for 
       reference). That is to say, if the starting coordinates are (5,5). A destroyer ship is to be placed horizontally on the board,
       then the occupied tiles will be (5,5) and (6,5). The game will not place the board such that the resulting placement of the 
       board will be (5,5) and (4,5). Therefore, If you tried to place a destroyer, oriented horizontally, at (10,5), you will recieve
       an error message. There is a catch in development, however in the current build the game will crash.
       
   ii) Current build only accepts ship placement in bounds of the board, so for your consideration, a list of available ships and their
        lengths is provided below. Future builds hope to display this information in game in an elegant matter.
        
        Ship            | Character to provide in console |   Length  |
        Destroyer       |_           "D" or "d"           |     2     |
        Submarine       |            "S" or "s"           |     3     |
        Cruiser         |            "C" or "c"           |     3     |
        Battleship      |            "B" or "b"           |     4     |
        Aircraft Carrier|            "A" or "a"           |     5     |
           
   
2. Players will take turns trying to attack and sink enemy ships before their oponent.
    i) Input is delivered by console commands in the current build.

    ii) Each player has one action they may take per turn. This is a choice between firing an attack at the enemy or healing a damaged 
       component of one of their own ships.
       
    iii) Notes on healing; You may only heal a damaged component of a ship once. If it is attacked again it is permanently destroyed.
                           You may heal the water, if you like. It is not recommended by the developer, as it provides no strategic                                advantage.
                          
3. The last player with ships surviving is the winner.

