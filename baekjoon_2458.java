import java.io.*;
import java.util.*;

public class baekjoon_2458 {
	static int N, M;
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static int[][] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);

		result = new int[N + 1][2];

		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

		for (int i = 0; i < M; i++) {
			String[] edge = br.readLine().split(" ");
			int a = Integer.parseInt(edge[0]);
			int b = Integer.parseInt(edge[1]);
			graph.get(a).add(b);
		}

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			dfs(i, i);
		}

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (result[i][0] + result[i][1] == N - 1) answer++;
		}
		System.out.println(answer);
	}

	// 나보다 큰 애들 탐색
	public static void dfs(int start, int curr) {
		visited[curr] = true;

		for (int next : graph.get(curr)) {
			if (!visited[next]) {
				result[start][1]++;
				result[next][0]++;
				dfs(start, next);
			}
		}
	}
}
