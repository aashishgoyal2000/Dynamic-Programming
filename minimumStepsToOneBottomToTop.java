import java.util.Scanner;

class minimumStepsToOneBottomToTop {

	public static int bottomToTop(int n, int[] arr) {
		for (int i = 2; i <= n; i++) {
			int mod3 = Integer.MAX_VALUE, mod2 = Integer.MAX_VALUE, sub1 = Integer.MAX_VALUE;
			if (i % 3 == 0) 
				mod3 = arr[i / 3] + 1;
			if (i % 2 == 0) mod2 = arr[i / 2] + 1;
			sub1 = arr[i - 1] + 1;
			arr[i] = Math.min(mod3, Math.min(mod2, sub1));
		}
		return arr[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n + 1];

		int out = bottomToTop(n, arr);
		System.out.println(out);
	}
}