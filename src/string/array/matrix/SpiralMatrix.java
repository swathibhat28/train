package string.array.matrix;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a matrix return all elements of the matrix in spiral order
 * e.g
 * Given
 *  {
 { 1, 2, 3 },
 { 4, 5, 6 },
 { 7, 8, 9 }
}
Return: [1,2,3,6,9,8,7,4,5]

Soln: Traverse circle if more than one row and column is left 
or else traverse row or column
 */
public class SpiralMatrix {
	
	public static void main(String []args){
		
		int [][]matrix = {
				 { 1, 2, 3 },
				 { 4, 5, 6 },
				 { 7, 8, 9 }
				};
		
		int row = matrix.length;
		int col = matrix[0].length;
		
		List<Integer> result = new ArrayList<Integer>();
		int x=0,y=0;
		
		while( row > 0 && col > 0){
			
			if(row == 1){
				for(int i = 0; i<col;i++){
					result.add(matrix[x][y++]);
				}
			}else if(col == 1){
					for(int i = 0; i<row;i++){
						result.add(matrix[x++][y]);
					}
			}
			
			//move right
			for(int i = 0; i<col-1;i++){
				result.add(matrix[x][y++]);
			}
			
			//move down
			for(int i = 0; i<row-1;i++){
				result.add(matrix[x++][y]);
			}
			
			//move left 
			for(int i = 0; i<col-1;i++){
				result.add(matrix[x][y--]);
			}
			
			//move up
			for(int i = 0; i<row-1;i++){
				result.add(matrix[x--][y]);
			}
			
			x++;
			y++;
			row = row-2;
			col = col-2;
		}
		
		System.out.println(result);
	}

}
