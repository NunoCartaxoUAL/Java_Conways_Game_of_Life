"# Java_Conways_Game_of_Life" 

Random Conway's Game of Life in java project

plan:
Object Oriented Programming with java Swing GUI that plays Conway's Game of Life

Conway's Game of Life:

A grid of Cells that can be Dead or Alive that interact with its neighbors to know if it stays alive or dead.

Rules:
1 - Any live cell with fewer than two live neighbours dies, as if by underpopulation.

2 - Any live cell with two or three live neighbours lives on to the next generation.

3 - Any live cell with more than three live neighbours dies, as if by overpopulation.

4 - Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.


mini-Project Conclusion:
	
The simulation works however i couldn't get the GUI to work with paint function so i had to resort to a duct tape solution that was JButtons, all the cells in my GUI are JButtons that you can interact with, after the 1000 cell count things start to get slow in therms of load time since its creating 1000 buttons.

As far as the Classes themselves go i am pretty satisfied but i feel there is a way to abandon the Grid Class(which restricts the game to only X by X cells) and only use Cells and its neighbors(kind of like a linked list) to do an infinite grid of the true Conway's Game of Life.

All in all i learned alot about Java swing and Layouts so i would say in general it was a successful mini-Project.
