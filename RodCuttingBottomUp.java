import java.util.*;

class RodCuttingBottomUp {
	public static int maxProfit(int[] prices, int n, int[] dp) {
		dp[0] = 0;

		for (int j = 1; j <= n; j++) {
			
			int ans = Integer.MIN_VALUE;
			for (int i = 0; i < j; i++) {
				int cut = i + 1;
				int current_ans = prices[i] + dp[j - cut];
				ans = Math.max(ans, current_ans);
			}

			dp[j] = ans;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int[] prices = {3, 5, 8, 9, 10, 17, 17, 20};
		int[] dp = new int[prices.length + 1];

		int out = maxProfit(prices, prices.length, dp);
		System.out.println(out);
	}
}