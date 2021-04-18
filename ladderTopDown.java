import java.util.*;

class ladderTopDown {

	public static int numberOfWays(int n, int k, int[] dp) {
		if (n == 0) return 1;
		if (dp[n] != 0) return dp[n];
		int sum = 0;
		for (int i = 1; i <= k; i++) {
			if (n - i >= 0) {
				sum += numberOfWays(n - i, k, dp);
			}
		}
		dp[n] = sum;
		return dp[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] dp = new int[n + 1];
		int out = numberOfWays(n, k, dp);
		System.out.println(out);
	}
}