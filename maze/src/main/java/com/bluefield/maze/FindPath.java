package com.bluefield.maze;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindPath {
	
	final static int [] directionX={-1,0,0,1}, directionY={0,-1,1,0};
	final static char [] direction={'r','d','u','l'};
	
	static class Node {
		public int x,y,k;
		Node(int x,int y, int k) {
			this.x=x;
			this.y=y;
			this.k=k;
		}
	}
	
     private int[][] maze;
     private int sX=0,sY=0,fX=0,fY=0;
     
     FindPath(char [][] maze) throws Exception {
    	 this.convertMaze(maze);
    	 boolean startFinded = false, finishFinded=false;
    	 for (int i = 0; i<this.maze.length;i++) {
         	for (int k = 0; k<this.maze[i].length;k++) {
         		if (this.maze[i][k]==-2 && !startFinded) {
         			this.sX=k;
         			this.sY=i;
         			startFinded=!startFinded;
         		}
         		if (this.maze[i][k]==-3 && !finishFinded) {
         			this.fX=k;
         			this.fY=i;
         			finishFinded=!finishFinded;
         		}
         	}
         	if (startFinded && finishFinded)
         		break;
         }
    	 if(!startFinded || !finishFinded)
    		 throw new Exception ("Start and/or finish is not founded");
     }
     
     private boolean checkBounds(int x, int y, int i) {
 		return x+directionX[i]>=0 && x+directionX[i]<this.maze[0].length 
 				&& y+directionY[i]>=0 && y+directionY[i]<this.maze.length &&
 				this.maze[y+directionY[i]][x+directionX[i]]!=-1;
 	}
     
     private void convertMaze(char[][] charMaze) throws Exception {
    	 this.maze = new int[charMaze.length][charMaze[0].length];
         for (int i=0; i<charMaze.length;i++)
         	for (int k=0; k<charMaze[0].length;k++)
         		if (charMaze[i][k]=='.')
         			this.maze[i][k]=0;
         		else if (charMaze[i][k]=='#')
         			this.maze[i][k]=-1;
         		else if (charMaze[i][k]=='S')
         			this.maze[i][k]=-2;
         		else if (charMaze[i][k]=='X')
         			this.maze[i][k]=-3;
         		else 
         			throw new Exception();
     }
     private void findAllPaths() {
     	Queue<Node> q = new ArrayDeque<>();
     	q.add(new Node(this.sX,this.sY,1));
     	while (!q.isEmpty()) {
     		
     		Node n = q.poll();
     		int x = n.x;
 			int y = n.y;

     		for (int i=0;i<4;i++)
     		{  
     			if (checkBounds(x,y,i) && this.maze[y+directionY[i]][x+directionX[i]]==0) {
     			    this.maze[y+directionY[i]][x+directionX[i]]=n.k;
     				q.add(new Node(x+directionX[i],y+directionY[i],n.k+1));
     			}
     		}
     	}
     }
 	
     public char[] findShortestPath() throws Exception {
    	findAllPaths();
     	int shortestDistance=this.maze[0].length*this.maze.length;
     	int x=this.fX,y=this.fY;
     	for (int i = 0; i<4; i++)
     	{
     		
     		if (checkBounds(x,y,i) &&
     				shortestDistance>this.maze[y+directionY[i]][x+directionX[i]])
     			shortestDistance=this.maze[y+directionY[i]][x+directionX[i]];
     			
     	}
     	if (shortestDistance==this.maze[0].length*this.maze.length)
     		throw new Exception("Maze don't have exit");
     	shortestDistance++;
     	char[] shortestPath = new char[shortestDistance];
     	int k=shortestPath.length-1;
     	while (this.maze[y][x]!=-2) {
     		for(int i = 0; i<4;i++) {
     			if (checkBounds(x,y,i) &&
     				    shortestDistance>this.maze[y+directionY[i]][x+directionX[i]]) {
     				shortestDistance=this.maze[y+directionY[i]][x+directionX[i]]+1;
     				shortestPath[k--]=direction[i];
     				x=x+directionX[i];
     				y=y+directionY[i];
     			    break;
     			}
     		}
     	} 
     	return shortestPath;
     }     
}
