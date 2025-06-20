package 자료구조;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class baekjoon_1021 {
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);

		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		String[] ss = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			//찾아야할 수
			int K = Integer.parseInt(ss[i]);
			boolean check = find(queue, K);
			//System.out.println("check: " + check);
			if (check) {
				while (!queue.isEmpty() && queue.peekFirst() != K) {
					int value = queue.pollFirst();
					queue.offerLast(value);
					answer += 1;
				}
				queue.pollFirst();
			} else {
				while (!queue.isEmpty() && queue.peekLast() != K) {
					int value = queue.pollLast();
					queue.offerFirst(value);
					answer += 1;
				}
				answer += 1;
				int value = queue.pollLast();
				queue.offerFirst(value);
				queue.pollFirst();
			}
			//System.out.println(answer);
		}
		System.out.println(answer);

	}
	public static boolean find(ArrayDeque<Integer> a ,int i){
		int count = 1;
		for(int value : a){
			if (value == i){
				break;
			}else{
				count +=1;
			}
		}
		// System.out.println("count" + count);
		// System.out.println("a size" + a.size());
		if (count <= a.size() / 2 + 1){
			return true;
		}else{
			return false;
		}
	}

}







