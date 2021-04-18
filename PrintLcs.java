import java.util.*;

class PrintLcs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				else 
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		int i = str1.length();
		int j = str2.length();
		int index = dp[i][j], temp = index;
		
		char[] lcs = new char[index + 1];
		lcs[index] = '\u0000';

		while (i > 0 && j > 0) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				lcs[index - 1] = str1.charAt(i - 1);
				i--;
				j--;
				index--;
			}
			else if (dp[i - 1][j] > dp[i][j - 1]) i--;
			else j--;
		}
		for (i = 0; i < temp; i++) {
			System.out.print(lcs[i]);
		}
	}
}