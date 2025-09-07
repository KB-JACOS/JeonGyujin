package 완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class baekjoon_2667_dfs {
	static List<Integer> store2 = new ArrayList<>();
	static int[][] store;
	static boolean[][] visited;

	static int[] x = {-1, 1, 0, 0};
	static int[] y = {0, 0, -1, 1};
	static int N;

	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		store = new int[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				store[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
			}
		}
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && store[i][j] == 1) {
					visited[i][j] = true;
					answer = 1;
					dfs(i, j);
					store2.add(answer);
				}
			}
		}
		System.out.println(store2.size());
		Collections.sort(store2);
		for (int i = 0; i < store2.size(); i++) {
			System.out.println(store2.get(i));
		}

	}

	public static void dfs(int i, int j) {

		for (int k = 0; k < 4; k++) {
			int ax = i + x[k];
			int ay = j + y[k];

			if (ax < 0 || ax > N - 1 || ay < 0 || ay > N - 1 || store[ax][ay] == 0) {
				continue;
			}

			if (!visited[ax][ay]) {
				visited[ax][ay] = true;
				answer += 1;
				dfs(ax, ay);
			}
		}
	}

}
