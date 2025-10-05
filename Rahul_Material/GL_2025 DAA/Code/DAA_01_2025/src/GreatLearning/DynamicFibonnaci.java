package GreatLearning;

public class DynamicFibonnaci {

	    // Memoization table, initialized with -1 to indicate uncomputed values
	    private static long[] memo;

	    public static long fib(int n) {
	    	memo = new long[n+1];
	        if (n < 0) {
	            throw new IllegalArgumentException("Input cannot be negative");
	        }
	        if (n <= 1) {
	            return n;
	        }
	        

	        // If the value is already computed, return it from the memo table
	        if (memo[n] != -1) {
	            return memo[n];
	        }

	        // Otherwise, compute the value and store it in the memo table
	        memo[n] = fib(n - 1) + fib(n - 2);
	        return memo[n];
	    }

   public static void main() {
	        int n1 = 10;
	        memo = new long[n1 + 1];
	        Arrays.fill(memo, -1); // Initialize all elements to -1
	        System.out.println("Fibonacci(" + n1 + ") (Memoization): " + fib(n1)); // Output: 55

	        int n2 = 50; // Larger value
	        memo = new long[n2 + 1];
	        Arrays.fill(memo, -1);
	        System.out.println("Fibonacci(" + n2 + ") (Memoization): " + fib(n2)); // Output: 12586269025
	    }
	}

