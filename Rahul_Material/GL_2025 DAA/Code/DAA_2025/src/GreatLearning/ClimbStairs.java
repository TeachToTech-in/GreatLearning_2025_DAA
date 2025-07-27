package GreatLearning;

import java.util.Arrays;

public class ClimbStairs {

	int climb(int n, int dp[]) {
		if (n <= 1)
			return dp[n] = 1;
		if (dp[n] != -1)
			return dp[n];
		int left = climb(n - 1, dp);
		int right = climb(n - 2, dp);
		return dp[n] = left + right;
	}

	public int climbStairs(int n) {
		int dp[] = new int[n + 1];
		Arrays.fill(dp, -1);
		return climb(n, dp);
	}
}
