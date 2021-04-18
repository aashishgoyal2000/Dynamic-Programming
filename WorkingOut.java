import java.util.Scanner;

class WorkingOut {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] arr = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int[][] dp1 = new int[n + 2][m + 2];
		int[][] dp2 = new int[n + 2][m + 2];
		int[][] dp3 = new int[n + 2][m + 2];
		int[][] dp4 = new int[n + 2][m + 2];
		

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp1[i][j] = Math.max(dp1[i - 1][j], dp1[i][j - 1]) + arr[i][j];
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = m; j >= 1; j--) {
				dp2[i][j] = Math.max(dp2[i - 1][j], dp2[i][j + 1]) + arr[i][j];
			}
		}
		
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= m; j++) {
				dp3[i][j] = Math.max(dp3[i + 1][j], dp3[i][j - 1]) + arr[i][j];
			}
		}

		for (int i = n; i >= 1; i--) {
			for (int j = m; j >= 1; j--) {
				dp4[i][j] = Math.max(dp4[i + 1][j], dp4[i][j + 1]) + arr[i][j];
			}
		}
		// System.out.println();
		// System.out.println();
		// for (int i = 0; i < n; i++) {
		// 	for (int j = 0; j < m; j++) {
		// 		System.out.print(dp1[i][j] + " ");
		// 	}
		// 	System.out.print("      ");
		// 	for (int j = 0; j < m; j++) {
		// 		System.out.print(dp2[i][j] + " ");
		// 	}
		// 	System.out.print("      ");
		// 	for (int j = 0; j < m; j++) {
		// 		System.out.print(dp3[i][j] + " ");
		// 	}
		// 	System.out.print("      ");
		// 	for (int j = 0; j < m; j++) {
		// 		System.out.print(dp4[i][j] + " ");
		// 	}
		// 	System.out.print("      ");
		// 	System.out.println();
		// }

		int ans = 0;
		for (int i = 2; i <= n - 1; i++) {
			for (int j = 2; j <= m - 1; j++) {
				int a = dp1[i - 1][j] + dp3[i][j - 1] + dp4[i + 1][j] + dp2[i][j + 1];
				int b = dp1[i][j - 1] + dp4[i][j + 1] + dp3[i + 1][j] + dp2[i - 1][j];

				// System.out.println(a + " " + b);
				ans = Math.max(ans, Math.max(a, b));// - arr[0][0] - arr[n - 1][0]);
			}
		}



		System.out.println(ans);

	}
}