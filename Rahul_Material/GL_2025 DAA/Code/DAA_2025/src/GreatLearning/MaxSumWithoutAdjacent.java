package GreatLearning;

import java.util.Arrays;

public class MaxSumWithoutAdjacent {
	
	  int findMaxSum(int arr[]) {
	        // code here
		  int dp[] = new int[arr.length];
	        
	        // Initialize the dp array with -1 to indicate that values are not calculated yet.
	        Arrays.fill(dp, -1);
	        
	        // Call the recursive solver for the last index (n-1).
	        return solveUtil(arr.length-1, arr, dp);
	        
	    }
	int solveUtil(int ind, int[] arr, int[] dp) {
		// If the index is negative, there are no elements left to consider.
		if (ind < 0)
			return 0;

		// If the index is 0, there is only one element to consider, so return its
		// value.
		if (ind == 0)
			return arr[ind];

		// If we have already calculated the result for this index, return it.
		if (dp[ind] != -1)
			return dp[ind];

		// Calculate the maximum sum by either picking the current element or not
		// picking it.
		int pick = arr[ind] + solveUtil(ind - 2, arr, dp);
		int nonPick = solveUtil(ind - 1, arr, dp);

		// Store the maximum of the two options in the dp array for future reference.
		return dp[ind] = Math.max(pick, nonPick);
	}
}
