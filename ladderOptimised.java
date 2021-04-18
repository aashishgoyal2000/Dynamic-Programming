import java.util.*;

class ladderOptimised {

	public static int numberOfWays(int n, int k, int[] dp) {
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = 2 * dp[i - 1];
				if (i - k - 1 >= 0) {
					dp[i] = dp[i] - dp[i - k - 1];
				}
		}
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