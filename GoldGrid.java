import java.util.Scanner;

class GoldGrid {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			arr[a][b] = 1;
		}

		int[][] dp = new int[n][n];
		dp[0][0] = arr[0][0] == 1 ? 1 : 0;
		for (int i = 1; i < n; i++) {
			dp[0][i] = dp[0][i - 1] + (arr[0][i] == 1 ? 1 : 0);
			dp[i][0] = dp[i - 1][0] + (arr[i][0] == 1 ? 1 : 0);
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + (arr[i][j] == 1 ? 1 : 0);
			}
		}
		
		int quad1, quad2, quad3, quad4, localMin, max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				quad1 = dp[i][j];
				quad2 = dp[i][n - 1] - quad1;
				quad3 = dp[n - 1][j] - quad1;
				quad4 = dp[n - 1][n - 1] - quad1 - quad2 - quad3;
				localMin = Math.min(quad1, Math.min(quad2, Math.min(quad3, quad4)));
				max = Math.max(localMin, max);
			}
		}
		System.out.println(max);
	}
}