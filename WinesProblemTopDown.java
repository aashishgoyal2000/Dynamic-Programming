import java.util.Scanner;

class WinesProblemTopDown {

	public static int totalCost(int[] wines, int i, int j, int y, int[][] arr) {
		if (i > j) {
			return 0;
		}
		else if (i == j) {
			return wines[i] * y;
		}
		if (arr[i][j] != 0) { // } != Integer.MIN_VALUE && arr[j] != Integer.MIN_VALUE) {
			return arr[i][j];
		}

		int tempCost = 0;
		if (i < arr.length - 1) {
			tempCost = Math.max(tempCost,  totalCost(wines, i + 1, j, y + 1, arr) + (wines[i] * y));
		}
		if (j > 0) {
			tempCost = Math.max(tempCost,  totalCost(wines, i, j - 1, y + 1, arr) + (wines[j] * y));
		}
		arr[i][j] = tempCost;
		return tempCost;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] wines = new int[n];
		for (int i = 0; i < n; i++) {
			wines[i] = sc.nextInt();
		}
		int[][] arr = new int[n + 1][n + 1];
		// for (int i = 0; i < n; i++) {
		// 	arr[i] = Integer.MIN_VALUE;
		// }
		System.out.println(totalCost(wines, 0, n - 1, 1, arr));
	}
}
/*
  
*/