package com.bluefield.maze;

import java.util.Scanner;

public class FindPathInputReaderStdIn extends AbstractFindPathInputReader {

	@Override
	public void inputMaze() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int count = Integer.parseInt(sc.nextLine());
		String[] maze_rows = new String[count];
		for (int i=0;i<count;i++) {
			maze_rows[i]=sc.nextLine();
		}
			
        this.maze = new char[maze_rows.length][maze_rows[0].length()];
        for (int i=0; i<maze_rows.length;i++)
        	for (int k=0; k<maze_rows[i].length();k++)
        		this.maze[i][k]=maze_rows[i].charAt(k);
	}
}

