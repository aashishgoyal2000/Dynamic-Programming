import java.util.Scanner;

class minimumStepsToOneTopToBottom {

	// n = n / 3
	// n = n / 2
	// n = n - 1

	public static int topToBottom(int n, int[] arr) {
		// base case
		if (n <= 1) return 0;

		if (arr[n] != 0) return arr[n];
		int mod3 = Integer.MAX_VALUE, mod2 = Integer.MAX_VALUE, sub1 = Integer.MAX_VALUE;

		if (n % 3 == 0)
		mod3 = topToBottom(n / 3, arr) + 1;

		if (n % 2 == 0)
		mod2 = topToBottom(n / 2, arr) + 1;
		
		sub1 = topToBottom(n - 1, arr) + 1;

		arr[n] = Math.min(mod3, Math.min(mod2, sub1));
		return arr[n];

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n + 1];

		int out = topToBottom(n, arr);
		System.out.println(out);
	}
}