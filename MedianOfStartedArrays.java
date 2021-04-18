import java.util.Scanner;

class MedianOfStartedArrays {

	public static int findMedian(int[] a, int[] b) {
		int n = a.length;
		int m = b.length;
		if (n > m) return findMedian(b, a);

		int low = 0;
		int high = n;
		while (low <= high) {
			int mid = (low + high) / 2;
			int partitionY = ((n + m + 1) / 2) - mid;
			// x || y
			// o to mid || mid to high // maxLeftX || minRightx
			// 0 to partitiony || partitiony to m // maxLefty || minRighty
			int maxLeftx = (mid == 0) ? Integer.MIN_VALUE : a[mid - 1];
			int maxLefty = (partitionY == 0) ? Integer.MIN_VALUE : b[partitionY - 1];
			int minRightx = (mid == n) ? Integer.MAX_VALUE : a[mid];
			int minRighty = (partitionY == m) ? Integer.MAX_VALUE : b[partitionY];
			if (maxLeftx <= minRighty && maxLefty <= minRightx) {
				if ((n + m) % 2 == 0) {
					return (Math.max(maxLeftx, maxLefty) + Math.min(minRightx, minRighty)) / 2;
				}
				else {
					return Math.max(maxLeftx, maxLefty);
				}
			}
			else if (maxLeftx > minRighty) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = sc.nextInt();
		}

		int median = findMedian(a, b);
		System.out.println(median);

	}
} 