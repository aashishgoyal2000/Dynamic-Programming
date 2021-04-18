import java.util.*;
class LongestPathGraph {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			al.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			al.get(a).add(b);
		}
		int[] visited = new int[n];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, iterateOverGraph(al, i, visited));
			// System.out.println(visited[i]);
		}

		System.out.println(ans);

	}
	public static int iterateOverGraph(ArrayList<ArrayList<Integer>> al, int vertex, int[] visited) {
		if (visited[vertex] != 0) return visited[vertex];
		if (al.get(vertex).size() == 0) return 0;
		
		int maxSize = 0;
		for (int i = 0; i < al.get(vertex).size(); i++) {
			maxSize = Math.max(maxSize, 1 + iterateOverGraph(al, al.get(vertex).get(i), visited));
		}
		visited[vertex] = maxSize;
		// System.out.println(maxSize);
		return maxSize;
	}
}