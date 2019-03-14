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
       reference). If you place a ship that extends the length of the board, you will be reprompted to place again.
       
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




References for Team 21 Project:

Course Instructor: Nathaly Verwaal 
We used TicTacToeGame example used in several lectures as the basis for building our Battleship Board using For loops in a 2-d array.


Textbook: Savitch, Walter, 2018. Java: An Introduction to Problem Solving & Programming. 8th Edition. Pearson, NewYork.


https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
