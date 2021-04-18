import java.util.Scanner;

class WinesProblemBottomUp {

    public static int totalCost(int[] wines, int[][] arr) {
        for (int i = 0; i < wines.length; i++) {
            int j = i;
            arr[i][j] = wines[i] * wines.length;
        }
        int y = wines.length - 1;
        for (int i = 0; i < wines.length; i++) {
            for (int j = wines.length - y, k = 0; j < wines.length; j++, k++) {
                int a = wines[k] * y + arr[k + 1][j];
                int b = wines[j] * y + arr[k][j - 1];
                arr[k][j] = Math.max(a, b);
            }
            y--;
        }
        // int a = wines[k] * y + arr[k][j - 1];
        // int b = wines[j] * y + arr[k + 1][j];
        // arr[k][j] = Math.max(a, b);
        // arr[0][wines.length - 1]
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        return arr[0][wines.length - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wines = new int[n];
        for (int i = 0; i < n; i++) {
            wines[i] = sc.nextInt();
        }
        int[][] arr = new int[n + 1][n + 1];
        int out = totalCost(wines, arr);
        System.out.println(out);
    }
}