package GreatLearning;

import java.util.Arrays;

public class UniquePaths {
	  public int uniquePaths(int m, int n) {
	        int dp[][] = new int [m][n];
	        for(int i = 0 ; i<m ;i++)
	        	Arrays.fill(dp[i], -1);
	        return calculate(m-1, n-1, dp);
	        	
	    }

	private int calculate(int i, int j, int[][] dp) {
		if(i==0 && j==0)
			return 1;
		if(i<0 || j<0)
			return 0;
		if(dp[i][j]!=-1) return dp[i][j];
		int left = calculate(i, j-1, dp);
		int up = calculate(i-1,j,dp);
		return dp[i][j]= left + up;
	}
}
