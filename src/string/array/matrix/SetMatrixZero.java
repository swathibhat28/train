package string.array.matrix;

/*
 * Set row and column of a matrix to zero if element is zero.
 * Do this in place. 
 * eg.
 * 1 0 2 3 4 5
   2 0 2 3 4 5
   3 1 2 3 4 5
   First check 102345 and
1
2
3
use two flags storing the status.  fr0 = true, fc0=false;
then check the rest of matrix, use the 1st col and 1st row store the status.
1 0 2 3 4 5
0 0 2 3 4 5

1 1 2 3 4 5
Then set 0s to sub-matrix(excludes 1st row and 1st column), according to the values in 1st row and 1st 
column, and finally set 1st row and 1st column according to flags.

 */
public class SetMatrixZero {
	
	public static void main(String[] args){
		int [][]matrix = {{1, 0, 2, 3, 4, 5},
						  {2, 0, 2, 3, 4, 5},
						  {3, 1, 2, 3, 4, 5}};
		
		boolean zeroesInFirstRow = false,zeroesInFirstColumn = false;
		
		//find out if any elements in the first row are zero
		for(int i =0;i<matrix.length;i++){
			if(matrix[i][0] == 0){
					zeroesInFirstRow = true;
					break;
			}
		}
		
		//find out of any elementin the first column is zero
		for(int i =0;i<matrix.length;i++){
			if(matrix[0][i] == 0){
					zeroesInFirstColumn = true;
					break;
			}
		}
		
		//set marker
		for(int i =0;i<matrix.length;i++){
			for(int j =0;j<matrix.length;j++){
				if(matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		
		//mark matrix zeros based on set marker
		for(int i =0;i<matrix.length;i++){
			for(int j =0;j<matrix.length;j++){
				if(matrix[i][0] == 0 || matrix[0][j] == 0 ){
					matrix[i][j] = 0;
				}
			}
		}
		
		if(zeroesInFirstRow){
			for(int i =0;i<matrix.length;i++){
				matrix[0][i] = 0;
			}
		}
		
		if(zeroesInFirstColumn){
			for(int i =0;i<matrix.length;i++){
				matrix[i][0] = 0;
			}
		}
		
		
		
	}

}
