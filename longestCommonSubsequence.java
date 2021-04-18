import java.util.*;

class longestCommonSubsequence {

	public static int lcs(String s1, String s2, int i, int j, int[][] dp) {
		if (i == s1.length() || j == s2.length()) {
			return 0;
		}
		if (dp[i][j] != -1) return dp[i][j];
		if (s1.charAt(i) == s2.charAt(j)) {
			dp[i][j] = 1 + lcs(s1, s2, i + 1, j + 1, dp);
			return dp[i][j];
		}
		int op1 = lcs(s1, s2, i + 1, j, dp);
		int op2 = lcs(s1, s2, i, j + 1, dp);

		dp[i][j] = Math.max(op1, op2);
		return dp[i][j];
	}

	public static void main(String[] args) {
		String s1 = "ABCD";
		String s2 = "ABEDG";
		int[][] dp = new int[s1.length()][s2.length()];
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println(lcs(s1, s2, 0, 0, dp));
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
}