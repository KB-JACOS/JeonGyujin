package 완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class baekjoon_1303 {

	static boolean[][] visited;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static List<Integer> W = new ArrayList<>();

	static List<Integer> B = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		//열
		int N = Integer.parseInt(s[0]);
		//행
		int M = Integer.parseInt(s[1]);

		visited = new boolean[M][N];
		String[][] land = new String[M][N];
		for (int i = 0; i < M; i++) {
			String ss = br.readLine();
			for (int j = 0; j < N; j++) {
				land[i][j] = String.valueOf(ss.charAt(j));
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j, land, land[i][j]);
				}
			}
		}

		int WAnswer = 0;
		for (int i = 0; i < W.size(); i++) {
			WAnswer += W.get(i) * W.get(i);
		}
		int BAnswer = 0;
		for (int i = 0; i < B.size(); i++) {
			BAnswer += B.get(i) * B.get(i);
		}
		System.out.println(WAnswer + " " + BAnswer);
	}

	public static void bfs(int i, int j, String[][] land, String s) {
		int answer = 0;
		if (s.equals("W")) {
			Queue<int[]> queue = new ArrayDeque<>();
			visited[i][j] = true;
			queue.offer(new int[] {i, j});

			while (!queue.isEmpty()) {
				int[] value = queue.poll();
				answer += 1;
				int x = value[0];
				int y = value[1];

				for (int k = 0; k < 4; k++) {
					int ax = x + dx[k];
					int ay = y + dy[k];

					if (ax < 0 || ax > land.length - 1 || ay < 0 || ay > land[0].length - 1) {
						continue;
					}

					if (land[ax][ay].equals("W") && !visited[ax][ay]) {
						visited[ax][ay] = true;
						queue.offer(new int[] {ax, ay});
					}
				}

			}
			W.add(answer);

		} else {
			int answer2 = 0;
			if (s.equals("B")) {
				Queue<int[]> queue = new ArrayDeque<>();
				visited[i][j] = true;
				queue.offer(new int[] {i, j});

				while (!queue.isEmpty()) {
					int[] value = queue.poll();
					answer2 += 1;
					int x = value[0];
					int y = value[1];

					for (int k = 0; k < 4; k++) {
						int ax = x + dx[k];
						int ay = y + dy[k];

						if (ax < 0 || ax > land.length - 1 || ay < 0 || ay > land[0].length - 1) {
							continue;
						}

						if (land[ax][ay].equals("B") && !visited[ax][ay]) {
							visited[ax][ay] = true;
							queue.offer(new int[] {ax, ay});
						}
					}

				}
				B.add(answer2);

			}
		}

	}
}