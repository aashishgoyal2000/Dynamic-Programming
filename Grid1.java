import java.util.Scanner;

class Grid1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int modd = (int)1e9 + 7;

		int[][] inp = new int[n][m];
		int[][] dp = new int[n][m];

		String inpChar;
		for (int i = 0; i < n; i++) {
			inpChar = sc.next();
			for (int j = 0; j < m; j++) {
				if (inpChar.charAt(j) == '.') inp[i][j] = 1;
				else inp[i][j] = 0;
			}
		}

		for (int i = 0; i < n; i++) {
			if (inp[i][0] == 1) dp[i][0] = 1;
			else break;
		}

		for (int j = 0; j < m; j++) {
			if (inp[0][j] == 1) dp[0][j] = 1;
			else break;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (inp[i][j] != 0)
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % modd;
			}
		}

		System.out.println(dp[n - 1][m - 1]);
	}
}