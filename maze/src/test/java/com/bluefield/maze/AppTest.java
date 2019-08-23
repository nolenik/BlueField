package com.bluefield.maze;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue() throws Exception
    {
    	FindPathInputReaderFile fpirf = new FindPathInputReaderFile("test.txt");
    	fpirf.inputMaze();
    	FindPath fp = new FindPath(fpirf.getMaze());
    	String result = "";
    	for (char c:fp.findShortestPath())
    		result+=c;
        assertEquals("ddddddddrrrrrrrrrrrrrrrrrrrrddrrrr",result);
    }
}
