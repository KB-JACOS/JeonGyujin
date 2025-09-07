package 완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class baekjoon_2667 {
	static List<Integer> store2 = new ArrayList<>();
	static int [][] store;
	static boolean [][] visited;

	static int [] x = {-1,1,0,0};
	static int [] y = {0,0,-1,1};
	static int N;
	public static void main(String[] args) throws Exception{
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
		System.out.println(Arrays.deepToString(store));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && store[i][j] == 1){
					bfs(i,j);
				}
			}
		}
		System.out.println(store2.size());
		Collections.sort(store2);
		for (int i = 0; i < store2.size(); i++) {
			System.out.println(store2.get(i));
		}

	}
	public static void bfs(int i, int j){
		visited[i][j] = true;
		int answer = 1;
		Queue<int []> queue = new ArrayDeque<>();
		queue.offer(new int[]{i,j});

		while(!queue.isEmpty()){
			int [] cur = queue.poll();
			int dx = cur[0];
			int dy = cur[1];

			for (int k = 0; k < 4; k++) {
				int ax = dx + x[k];
				int ay = dy + y[k];

				if (ax < 0 || ax > N - 1 || ay < 0 || ay > N - 1 || store[ax][ay] == 0){
					continue;
				}

				if (!visited[ax][ay]){
					visited[ax][ay] = true;
					answer +=1;
					queue.offer(new int[]{ax,ay});
				}
			}
		}

		store2.add(answer);
	}
}
