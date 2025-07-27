package GreatLearning;

import java.util.Arrays;

public class Frogjump {
	int minCost(int[] height) {
		// code here
		int dp[] = new int[height.length];
		Arrays.fill(dp, -1);
		return FrogMin(height.length-1,height,dp);
	}

	private int FrogMin(int index,int[] height, int[] dp) {
		if(index == 0 ) return dp[0]=0;
		int right=Integer.MAX_VALUE;
		if(dp[index]!=-1) return dp[index];
		  int left = FrogMin(index-1, height, dp) + Math.abs(height[index]-height[index-1]);
		  if(index>1)
		  right = FrogMin(index-2, height, dp) + Math.abs(height[index]-height[index-2]);
		  return dp[index]= Math.min(left, right);
	}
}
