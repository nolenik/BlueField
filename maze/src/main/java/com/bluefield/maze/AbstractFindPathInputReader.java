package com.bluefield.maze;

public abstract class AbstractFindPathInputReader {
       protected char[][] maze = null;
       
       
       public boolean checkCorrect(char[][] maze) {
    	   for (int i = 1; i<maze.length;i++)
    		   if (maze[i].length!=maze[0].length)
    			   return false;
    	   for (int i = 0; i<maze.length; i++)
    		   for (int k = 0 ; k<maze[i].length;k++)
    			   if (maze[i][k]!='S' && maze[i][k]!='X' &&
    			   maze[i][k]!='.' && maze[i][k]!='#')
    				   return false;
    	   return true;
       }
       
       
       public abstract void inputMaze();
       
       
       public char[][] getMaze() {
    	   if (!checkCorrect(this.maze))
    		   throw new IllegalArgumentException("Incorrect maze");
    	   return this.maze;
       }
}
