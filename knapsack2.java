import java.util.Scanner;

class knapsack2 {
	static int inf = (int)1e9 + 1;
	public static int solve(int[] val, int[] weight, int n, int w) {
		long[][] dp = new long[n + 1][(n * 1000) + 1];
		for (int i = 0; i <= (n * 1000); i++) {
			dp[1][i] = inf;
		} 
		dp[1][0] = 0;
		dp[1][val[1]] = weight[1];

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= (n * 1000); j++) {
				dp[i][j] = dp[i - 1][j];
				if (val[i] > j) {
					continue;
				}
				dp[i][j] = Math.min(dp[i][j], weight[i] + dp[i - 1][j - val[i]]);
			}
		}
		int ans = 0;
		for (int i = 0; i <= (n * 1000); i++) {
			if (dp[n][i] <= w) {
				ans = i;
			}
		}
		
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();

		int[] weight = new int[n + 1];
		int[] val = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			weight[i] = sc.nextInt();
			val[i] = sc.nextInt();
		}

		int out = solve(val, weight, n, w);
		System.out.println(out);

	}
}