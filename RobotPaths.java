import java.util.*;

class RobotPaths {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int p = sc.nextInt();

		int[][] arr = new int[n][m];
		for (int i = 0; i < p; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			arr[a][b] = -1;
		}

		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			if (arr[i][0] != -1) {
				dp[i][0] = 1;
			}
			else break;
		}
		for (int i = 0; i < m; i++) {
			if (arr[0][i] != -1) {
				dp[0][i] = 1;
			}
			else break;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (arr[i][j] != -1)
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
			}
		}

		System.out.println(dp[n - 1][m - 1]);
	}
}