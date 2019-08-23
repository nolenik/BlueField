package com.bluefield.maze;

public class App 
{
	public static void main( String[] args ) throws Exception
    {
		
//		FindPathInputReaderStdIn fpirsi = new FindPathInputReaderStdIn();
//		fpirsi.inputMaze();
    	FindPathInputReaderFile fpirf = new FindPathInputReaderFile("test.txt");
    	fpirf.inputMaze();
        char[][] maze = fpirf.getMaze();
        FindPath fp = new FindPath(maze);
        System.out.println(fp.findShortestPath());
    }
}
