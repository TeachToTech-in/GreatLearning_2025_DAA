package GreatLearning;

import java.util.Arrays;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
	        int dp[][] = new int [m][n];
	        for(int i = 0 ; i<m ;i++)
	        	Arrays.fill(dp[i], -1);
	        return calculate(m-1, n-1, dp,grid);
	        	
	    }

	private int calculate(int i, int j, int[][] dp, int grid[][]) {
		if(i==0 && j==0)
			return dp[i][j]= grid[i][j];
		if(i<0 || j<0)
			return Integer.MAX_VALUE;
		if(dp[i][j]!=-1) return dp[i][j];
		int left = calculate(i, j-1, dp, grid)+grid[i][j];
		int up = calculate(i-1,j,dp,grid)+grid[i][j];
		return dp[i][j]= Math.min(left, up);
	}
}
