package grid;

import java.util.Iterator;

/*
 * A Maze is given as N*N binary matrix of blocks where source block is the upper left most block 
 * i.e., maze[0][0] and destination block is lower rightmost block i.e., 
 * maze[N-1][N-1]. A rat starts from source and has to reach destination. 
 * The rat can move in all four directions: forward and down.
 */

public class RatInMaze {
	
	public static int N = 4;
	
	public static void main(String []args){
		//lets represent the maze as a binary matrix - 0 means the grid is blocked and 1 means the grid is open
		int maze[][] = { 
				{1, 0, 0, 0},
		        {1, 1, 0, 1},
		        {0, 1, 0, 0},
		        {1, 1, 1, 1}
		};
		
		solveMaze(maze);	
		
	}

	private static boolean solveMaze(int[][] maze) {
		int sol[][] = {
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0}
		};
		
		if(solveMazeUtil(maze,0,0,sol) == false){
			System.out.println("Maze cannot be solved");
			return false;
		}
		printSolution(sol);
		return true;
	}

	private static void printSolution(int[][] sol) {
		for(int i = 0; i < 4;i++){
			System.out.println();
			for(int j = 0; j < 4; j++){
				System.out.print(" ");
				System.out.print(sol[i][j]);
			}
		}
	}

	private static boolean solveMazeUtil(int[][] maze, int i, int j, int[][] sol) {
		if(i == N-1 && j == N-1){
			sol[i][j] = 1;
			return true;
		}
		
		if(isSafe(maze,i,j)){
			sol[i][j] = 1;

			if(solveMazeUtil(maze,i+1,j,sol)){
				return true;
			}
			if(solveMazeUtil(maze,i,j+1,sol)){
				return true;
			}
			if(solveMazeUtil(maze,i-1,j,sol)){
				return true;
			}
			
			if(solveMazeUtil(maze,i,j-1,sol)){
				return true;
			}
			
			sol[i][j] = 0;
			return false;
		}
		return false;
	}

	private static boolean isSafe(int[][] maze, int i, int j) {
		if(i >= 0 && i < N && j >=0 && j < N && maze[i][j] == 1 ){
			return true;
		}
		return false;
	}
}
