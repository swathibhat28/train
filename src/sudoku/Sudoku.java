package sudoku;

import java.util.HashSet;
import java.util.Set;

/*
 * Make numbers 1-9 unique on a 9 by 9 grid in:
 * 1.Every row
 * 2.Every column
 * 3. Every 3x3 grid
 */
public class Sudoku {
	
	public static void main(String []args){
		int[][] grid = new int[][]{
				 {3, 0, 6, 5, 0, 8, 4, 0, 0},
                 {5, 2, 0, 0, 0, 0, 0, 0, 0},
                 {0, 8, 7, 0, 0, 0, 0, 3, 1},
                 {0, 0, 3, 0, 1, 0, 0, 8, 0},
                 {9, 0, 0, 8, 6, 3, 0, 0, 5},
                 {0, 5, 0, 0, 9, 0, 6, 0, 0},
                 {1, 3, 0, 0, 0, 0, 2, 5, 0},
                 {0, 0, 0, 0, 0, 0, 0, 7, 4},
                 {0, 0, 5, 2, 0, 6, 3, 0, 0}
                 };
		if(solveSudoku(grid)){
			printGrid(grid);
		}else{
			System.out.println("Solution doesnt exist for this sudoku");
		}
	}

	private static boolean solveSudoku(int[][] grid) {
		
		CurrentGrid currentGrid = new CurrentGrid();
		
		//stopping condition - all unfilled grids are filled
		if(!findUnfilledGrid(grid,currentGrid)){
			return true;
		}
		
		//iterate through 1-9 and assign the current grid the value and check if valid
		for(int num=1;num<=9;num++){
			if(isSafe(grid,currentGrid,num)){
				grid[currentGrid.row][currentGrid.col] = num;
				
				if(solveSudoku(grid)){
					return true;
				}
				grid[currentGrid.row][currentGrid.col] = 0;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] grid, CurrentGrid currentGrid, int num) {
		
		if(!usedInRow(grid,currentGrid,num) && !usedInColumn(grid,currentGrid,num) && !usedInSubGrid(grid,currentGrid,num)){
			return true;
		}
		return false;
	}

	private static boolean usedInSubGrid(int[][] grid, CurrentGrid currentGrid,
			int num) {
		int startRow = currentGrid.row-currentGrid.row%3;
		int startCol = currentGrid.col-currentGrid.col%3;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(grid[i+startRow][j+startCol]==num){
					return true;
				}
			}
			
		}
		return false;
	}

	private static boolean usedInColumn(int[][] grid, CurrentGrid currentGrid,
			int num) {
		for(int col = 0;col<currentGrid.col;col++){
			if(grid[currentGrid.row][col] == num){
				return true;
			}
		}
		return false;
	}

	private static boolean usedInRow(int[][] grid, CurrentGrid currentGrid,
			int num) {
		int col = currentGrid.col;
		for(int row=0;row<currentGrid.row;row++){
			if(grid[row][col] == num){
				return true;
			}
		}
		return false;
	}

	private static boolean findUnfilledGrid(int[][] grid,
			CurrentGrid currentGrid) {
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(grid[i][j] == 0){
					currentGrid.row=i;
					currentGrid.col=j;
					return true;
				}
			}
		}
		return false;
	}

	private static void printGrid(int[][] grid) {
		for (int i = 0; i < 9; i++) {
			for(int j=0;j<9;j++){
				System.out.print(grid[i][j]);
			}	
			System.out.println();
		}
	}

}
