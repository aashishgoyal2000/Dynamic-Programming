import java.util.*;

class RodCuttingTopDown {

	public static int maxProfit(int[] prices, int n, int[] dp) {
		if (n <= 0) return 0;
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int cut = i + 1;
			int currentAns = prices[i] + maxProfit(prices, n - cut, dp);
			ans = Math.max(currentAns, ans);
		}
		dp[n] = ans;
		return ans;
	}

	public static void main(String[] args) {
		int[] prices = {3, 5, 8, 9, 10, 17, 17, 20};
		int[] dp = new int[prices.length + 1];

		int out = maxProfit(prices, prices.length, dp);
		System.out.println(out);
	}
}