package GreatLearning;

import java.util.Arrays;

public class FibonnaciDY {
	private static int[] memo;

	public static int nthFibonacci(int n) {
		memo = new int[n + 1];
		Arrays.fill(memo, -1); // Initialize all elements to -1
		fib(n);
		return memo[n];

	}

	public static int fib(int n) {
		// If the value is already computed, return it from the memo table
		if (memo[n] != -1) {
			return memo[n];
		}
		if (n <= 1) {
			memo[n] = n;
			return n;
		}

		// Otherwise, compute the value and store it in the memo table
		memo[n] = fib(n - 1) + fib(n - 2);
		return memo[n];

	}

	public static void main(String[] args) {
		System.out.println(nthFibonacci(5));
	}
}
