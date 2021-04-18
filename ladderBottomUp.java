import java.util.*;

class ladderBottomUp {

	public static int numberOfWays(int n, int k, int[] dp) {
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (i - j >= 0) {
					dp[i] += dp[i - j];
				}
			}
		}
		// dp[n] = sum;
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