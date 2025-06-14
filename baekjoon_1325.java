import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class baekjoon_1325 {

	static List<List<Integer>> store = new ArrayList<>();
	static boolean [] visited;
	static List<Integer> answerList = new ArrayList<>();

	static int [] result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);

		for (int i = 0; i < N + 1; i++) {
			store.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			String [] input = br.readLine().split(" ");
			store.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
		}
		result = new int[N+1];
		for (int i = 1; i <= N ; i++) {
			visited = new boolean[N+1];
			bfs(i, store);
		}
		int max = Arrays.stream(result).max().getAsInt();
		//System.out.println(Arrays.toString(result));
		for (int i = 1; i <= N; i++) {
			if (result[i] == max) {
				System.out.print(i + " ");
			}
		}
	}
	public static void bfs(int i, List<List<Integer>> store){

		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(i);
		visited[i] = true;


		while(!queue.isEmpty()){
			int value = queue.poll();
			visited[value] = true;
			for(int next : store.get(value)){
				if (!visited[next]){
					result[next] ++;
					visited[next] = true;
					queue.offer(next);
				}
			}


		}

	}
}
