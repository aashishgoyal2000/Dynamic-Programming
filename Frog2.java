import java.util.Scanner;

class Frog2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			int temp = Integer.MAX_VALUE;
			for (int j = 1; j <= k; j++) {
				if (i - j >= 0) {
					temp = Math.min(temp, Math.abs(arr[i - j] - arr[i]) + dp[i - j]);
				}
			}
			if (temp != Integer.MAX_VALUE)
			dp[i] = temp;
		}
		System.out.println(dp[n - 1]);
	}
}