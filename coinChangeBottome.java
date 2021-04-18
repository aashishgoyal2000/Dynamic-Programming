import java.util.Scanner;

class coinChangeBottome {
	static int numberOfCoins(int n, int[] coins, int[] dp) { // n is for cash
		if (n == 0) {
			return 0;
		}
		for (int j = 1; j <= n; j++) {
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < coins.length; i++) {
				if (j - coins[i] >= 0) {
					int subprob = dp[j-coins[i]];
					ans = Math.min(ans, subprob + 1);
				}
			}	
			dp[j] = ans;
		}
		
		
		
		return dp[n];
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