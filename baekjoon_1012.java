import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 풀이방식 : bfs 를 사용하여 상하좌우에 인접한 1을 모두 찾아내는 방식을 선택했다.
 ground 배열 -> 배추가 존재하는 땅에 1이라는 값이 배정된 배열.
 가로, 세로 크기만큼의 이중 for 문을 돌면서 ground 배열이 1이면서, visited 배열이 false 인 땅을 찾아서
 bfs 를 호출한다. bfs 안에서 인접한 땅을 최대한으로 찾고 다 찾았으면 리턴된다. bfs 가 호출된 횟수가 필요한 배추 흰지렁이 수다.
 **/
public class baekjoon_1012 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a = Integer.parseInt(br.readLine());
		Queue<Integer> realAnswer = new ArrayDeque<>();
		for (int i = 0; i < a; i++) {
			String[] store = br.readLine().split(" ");
			int[][] ground = new int[Integer.parseInt(store[0])][Integer.parseInt(store[1])];
			for (int j = 0; j < Integer.parseInt(store[2]); j++) {
				String[] bugs = br.readLine().split(" ");
				ground[Integer.parseInt(bugs[0])][Integer.parseInt(bugs[1])] = 1;
			}

			visited = new boolean[Integer.parseInt(store[0])][Integer.parseInt(store[1])];
			int answer = 0;
			for (int j = 0; j < Integer.parseInt(store[0]); j++) {
				for (int k = 0; k < Integer.parseInt(store[1]); k++) {
					if (ground[j][k] == 1 && !visited[j][k]) {
						bfs(ground, j, k, Integer.parseInt(store[0]), Integer.parseInt(store[1]));
						answer += 1;
					}
				}

			}
			realAnswer.offer(answer);
		}
		int size = realAnswer.size();
		for (int i = 0; i < size; i++) {
			bw.write(String.valueOf(realAnswer.poll()));
			if (i != size - 1) {
				bw.newLine(); // 마지막이 아닌 경우에만 줄바꿈
			}
		}
		bw.flush();
		bw.close();

		 // 리소스 정리

	}

	public static void bfs(int[][] ground, int i, int j, int garo, int sero) {
		Queue<int[]> queue = new ArrayDeque<>();
		visited[i][j] = true;
		queue.offer(new int[] {i, j});

		while (!queue.isEmpty()) {
			int[] a = queue.poll();

			int x = a[0];
			int y = a[1];

			for (int k = 0; k < 4; k++) {
				int ax = x + dx[k];
				int ay = y + dy[k];

				if (ax < 0 || ax > garo - 1 || ay < 0 || ay > sero - 1) {
					continue;
				}
				if (ground[ax][ay] == 1 && !visited[ax][ay]) {
					visited[ax][ay] = true;
					queue.offer(new int[] {ax, ay});
				}
			}
		}
	}

}
