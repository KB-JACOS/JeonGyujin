package 완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class baekjoon_14500 {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int answer = 0;
	static int answer2 = 0;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] num = br.readLine().split(" ");
		int[][] board = new int[Integer.parseInt(num[0])][Integer.parseInt(num[1])];
		for (int i = 0; i < Integer.parseInt(num[0]); i++) {
			String[] num1 = br.readLine().split(" ");
			board[i] = Arrays.stream(num1).mapToInt(Integer::parseInt).toArray();
		}
		visited = new boolean[Integer.parseInt(num[0])][Integer.parseInt(num[1])];
		for (int i = 0; i < Integer.parseInt(num[0]); i++) {
			for (int j = 0; j < Integer.parseInt(num[1]); j++) {

				visited[i][j] = true;
				dfs(0, board, board[i][j], i, j);
				visited[i][j] = false;

				check(i, j, board);
			}
		}
		bw.write(String.valueOf(Math.max(answer, answer2)));
		bw.flush();
		bw.close();

	}

	public static void check(int i, int j, int[][] board) {

		for (int k = 0; k < 4; k++) {
			int sum = board[i][j];
			boolean value = true;
			for (int l = 0; l < 4; l++) {
				if (k == l)
					continue;
				int nx = i + dx[l];
				int ny = j + dy[l];

				if (nx < 0 || nx > board.length - 1 || ny < 0 || ny > board[0].length - 1) {
					value = false;
					break;
				}
				sum += board[nx][ny];
			}

			if (value)
				answer2 = Math.max(answer2, sum);
		}
	}

	public static void dfs(int depth, int[][] board, int sum, int i, int j) {
		if (depth == 3) {

			answer = Math.max(answer, sum);
			return;
		}

		for (int k = 0; k < 4; k++) {

			int x = i + dx[k];
			int y = j + dy[k];

			if (x < 0 || x > board.length - 1 || y < 0 || y > board[i].length - 1) {
				continue;
			}
			if (!visited[x][y]) {
				visited[x][y] = true;
				dfs(depth + 1, board, sum + board[x][y], x, y);
				visited[x][y] = false;
			}

		}

	}

}
