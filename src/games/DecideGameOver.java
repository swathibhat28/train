package games;

/*
 * 
1 1 1 1 1 1 
1 1 1 0 0 1 
1 0 0 
 0 1 
1 0 0 0 0 1 
1 0 0 0 1 1 
1 1 1 1 1 1 

Game is over when an island of zeros is surrounded by 1's
 */

public class DecideGameOver {

	public static void main(String []args){
		int N = 6;
		int matrix[][] = {
				{1, 1, 1, 1, 1, 1},
				{1, 1, 0, 0, 0, 1}, 
				{1, 0, 0, 0, 0, 1},
				{1, 0, 0, 0, 0, 1},
				{1, 0, 0, 0, 1, 1},
				{1, 1, 1, 1, 1, 1}
		};
		
		int temp[][] = new int[6][6] ;
		int walls = 0;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(matrix[i][j] == 0){
					fillMatrix(matrix,temp,i,j,N);
					if(walls < temp[i][j]){
						walls = temp[i][j];
					}
				}
			}
		}
		
		if(walls == 4){
			System.out.println("Has Island");
		}
	}

	private static void fillMatrix(int[][] matrix, int[][] temp, int i, int j, int n) {
		temp[i][j] = 0;
		if(i==0 || j==0 || i == n-1 || j == n-1) return;
		
		if(matrix[i][j-1] == 1 || temp[i][j-1] > 0){
			temp[i][j] +=1;
		}
		
		if(matrix[i-1][j] == 1 || temp[i-1][j] > 0){
			temp[i][j] +=1;
		}
		
		if(matrix[i][j+1] == 1){
			temp[i][j] +=1;
		}
		if(matrix[i+1][j] == 1){
			temp[i][j] +=1;
		}
	}
}
