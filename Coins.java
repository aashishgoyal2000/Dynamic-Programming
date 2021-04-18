import java.util.Scanner;

class Coins {

	public static double solve(double[] pro, double[][] dp, int n, int x) {
		if (x == 0) return 1;
		if (n == 0) return 0;

		if (dp[n][x] != -1) return dp[n][x];

		dp[n][x] = pro[n] * solve(pro, dp, n - 1, x - 1) + (1 - pro[n]) * solve(pro, dp, n - 1, x);
		return dp[n][x];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[] pro = new double[n + 1];
		for (int i = 1; i <= n; i++) {
			pro[i] = sc.nextDouble();
		}
		int x = (n + 1) / 2;
		double[][] dp = new double[n + 1][x + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= x; j++) {
				dp[i][j] = -1;
			}
		}
		double out = solve(pro, dp, n, x);
		System.out.println(out);
	}
}