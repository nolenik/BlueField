package com.bluefield.maze;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FindPathInputReaderFile extends AbstractFindPathInputReader{
    
	String mazePath;
	FindPathInputReaderFile(String mazePath) {
		this.mazePath=mazePath;
	}
	@Override
	public void inputMaze() {
		String str ="";
		try {
			str = new String (Files.readAllBytes(Paths.get(this.mazePath)),Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
        String[] maze_rows = str.split("\n");
        for (int i=0;i<maze_rows.length-1;i++)
        	maze_rows[i] = maze_rows[i].substring(0, maze_rows[i].length()-1);
        this.maze = new char[maze_rows.length][maze_rows[0].length()];
        for (int i=0; i<maze_rows.length;i++)
        	for (int k=0; k<maze_rows[i].length();k++)
        		this.maze[i][k]=maze_rows[i].charAt(k);
		
	}
 
}
