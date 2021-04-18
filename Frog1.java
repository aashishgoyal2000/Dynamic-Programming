import java.util.Scanner;

class Frog1 {
	
	public static int bottomUp(int[] arr, int n) {
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			int temp = Integer.MAX_VALUE;
			if (i - 1 >= 0) {
				temp = Math.min(temp, Math.abs(arr[i - 1] - arr[i]) + dp[i - 1]);
			}
			if (i - 2 >= 0) {
				temp = Math.min(temp, Math.abs(arr[i - 2] - arr[i]) + dp[i - 2]);
			}
			if (temp != Integer.MAX_VALUE) 
			dp[i] = temp;
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] dp = new int[n];
		int out = bottomUp(arr, n);
		System.out.println(out);
	}

}