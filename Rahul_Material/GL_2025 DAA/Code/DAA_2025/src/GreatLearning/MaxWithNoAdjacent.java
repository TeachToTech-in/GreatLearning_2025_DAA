package GreatLearning;

import java.util.Arrays;

public class MaxWithNoAdjacent {
	 int findMaxSum(int arr[]) {
	     int dp[] = new int [arr.length];
	     Arrays.fill(dp, -1);
		 return findMaxResult(arr.length-1, arr, dp);
	        
	    }
	public int findMaxResult(int index , int arr[],int dp[]){
		 if(index<0) return 0;
		 if(index==0) return dp[index] = arr[index];
		 if(dp[index]!=-1) return dp[index];
		 int take = arr[index] + findMaxResult(index-2,arr,dp);
		 int nottake = findMaxResult(index-1, arr,dp);
		 return dp[index] = Math.max(take, nottake);
	 }
}
