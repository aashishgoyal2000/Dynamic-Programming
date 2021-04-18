import java.util.Scanner;

class coinChangeTopToBottom {

	static int numberOfCoins(int n, int[] coins, int[] dp) { // n is for cash
		if (n == 0) {
			return 0;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			if (n - coins[i] >= 0) {
				int subprob = numberOfCoins(n - coins[i], coins, dp);
				ans = Math.min(ans, subprob + 1);
			}
		}
		dp[n] = ans;
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}
		

		int cash = sc.nextInt();
		int[] dp = new int[cash + 1];
		int out = numberOfCoins(cash, coins, dp);
		System.out.println(out);
	}
}