import java.util.Scanner;

class Knapsack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		long[] val = new long[n + 1];
		long[] weight = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			weight[i] = sc.nextLong();
			val[i] = sc.nextLong();
		}
		long[][] dp = new long[n + 1][w + 1];
		dp[1][(int)weight[1]] = val[1];
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				dp[i][j] = dp[i - 1][j];

				if (weight[i] <= j) 
				dp[i][j] = Math.max(dp[i - 1][(int)(j - weight[i])] + val[i], dp[i][j]);				
			}
		}
		long max = dp[n][w];
		for (int i = 1; i <= w; i++) {
			max = Math.max(max, dp[n][i]);
		}
		System.out.println(max);
	}
}