package GreatLearning;

import java.util.Arrays;

public class FrogMinimumCost {
	 int minCost(int[] height) {
		    int dp[] = new int [height.length];
		    Arrays.fill(dp, -1);
			return  frogMiniCost(height.length-1, height,dp);
		        
		    }
		public int  frogMiniCost(int index, int [] height,int dp[]){
			if(index==0) return 0;
			if(dp[index]!=-1) return dp[index];
			
			int one = Integer.MAX_VALUE;
			int two = Integer.MAX_VALUE;
			one = frogMiniCost(index-1,height,dp) + Math.abs(height[index]-height[index-1]);
			if(index>1)
			two = frogMiniCost(index-2,height,dp) + Math.abs(height[index]-height[index-2]);
			 return dp[index] = Math.min(one, two);
		 }
}
