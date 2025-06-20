package 완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class baekjoon_2178 {

	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};

	static int [][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		List<List<Integer>> store = new ArrayList<>();
		String [] a = br.readLine().split(" ");
		visited = new int[Integer.parseInt(a[0])][Integer.parseInt(a[1])];
		for (int i = 0; i < Integer.parseInt(a[0]); i++) {
			String s = br.readLine();
			List<Integer> aa = new ArrayList<>();
			for (int j = 0; j < s.length(); j++) {
				aa.add(Integer.parseInt(String.valueOf(s.charAt(j))));
			}
			store.add(aa);
		}
		visited[0][0] = 1;

		bfs(store);
		bw.write(String.valueOf(visited[Integer.parseInt(a[0]) - 1][Integer.parseInt(a[1]) - 1]));
		bw.flush();
		bw.close();

	}

	public static void bfs(List<List<Integer>> aa){
		Queue<int []> queue = new ArrayDeque<>();
		queue.offer(new int[]{0,0});
		int value = 0;
		for(List<Integer> aaa : aa){
			value = aaa.size();
			break;
		}

		while(!queue.isEmpty()){
			int [] a = queue.poll();
			int x = a[0];
			int y = a[1];

			for (int i = 0; i < 4; i++) {
				int ax = x + dx[i];
				int ay = y + dy[i];

				if (ax < 0 || ax > aa.size() - 1  || ay < 0 || ay > value - 1){
					continue;
				}

				if (visited[ax][ay] == 0 && aa.get(ax).get(ay) == 1) {
					visited[ax][ay] = visited[x][y] + 1;
					queue.offer(new int[]{ax,ay});
				}
			}

		}
	}
}
