The 2048 Game
The game 2048 is built using JavaFX 19 and Java 18. This is a simple gui version of the 2048 game.


# Running Project
It is better to use IntelliJ Idea but you can choose any IDE you want. The 2048 is JavaFX project.
Please Make Sure to Include JavaFX Labiraries.

# Run
* Open Game2048 Project in Your IDE
* Right-click on Game2048
* Run [All test] (In intelliJ)

# Classes
Account (For user records)
Cell (To Make cells 2D array Like rectangle)
EndGame (A Scene Show when game Ends)
GameScene ( Start templete of the game)
TextMaker ( To Place the text in Score Areas)
Move (To move the Boxes Only arrow keys)


# Task 2
* added Readme.md
* Created javaDocs
* Made Test Packege

# Task 3
* Created module-info.java
* made change to Endgame screen added restart button
* Modified functionality of quit btn

# A1
* Enchanced the maintainability 
* In GameScene Class removed the bugs
* Allowing All keys(Now Only Arrow keys)
* calculation of Score was Not Good Also Improved that
* New Class Called Moves Separated All the moves
* Old  Game Scene Stays the same

# A2
* Added HighScore Module
* The Score in Store in file(highSore.txt)
* Read and Write Operations are perform using Writer and Reader Clsses
* IF player scores best then Privous best Score we Replace it with New Score

# A3
* ReStart Game
* At the End of Every Game There is Given choices of Quit and Restart
* IF QUIT game closes
* ELSE Game Restarts from begining

# A4
* Added jUnit Test
* jUnit 5.9.1 is used
* All the neccesary Test Classes are in tests package
* BestScoreTest (To make sure bestscore is saved in file)
* CellTest 
* EndGameTest
* GameSceneTest
* MoveTest (To make sure only arrow keys works)


#  A5
* used build file
* Now Project Can pe run as Ant Project.
