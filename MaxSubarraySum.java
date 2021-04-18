import java.util.Scanner;

class MaxSubarraySum {

	public static int maxSum (int[] arr, int n) {
		int[] dp = new int[n + 1];
		dp[0] = arr[0] > 0 ? arr[0] : 0; 
		int maxSoFar = dp[0];
		for (int i = 1; i < n; i++) {
			dp[i] = dp[i - 1] + arr[i];
			if (dp[i] < 0) {
				dp[i] = 0;
			}
			maxSoFar = Math.max(maxSoFar, dp[i]);
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		int[] arr = {-3, 2, 5, -1, 6, 3, -2, 7, -5, 2};
		System.out.println(maxSum(arr, arr.length));
		
	}
}