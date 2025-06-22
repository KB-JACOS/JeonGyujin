package 완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class baekjoon_1497 {

	static List<List<String>> store = new ArrayList<>();

	static int N, M;

	static int targetNumber = 0;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		for (int i = 0; i < N; i++) {
			String[] ss = br.readLine().split(" ");
			List<String> store2 = new ArrayList<>();
			store2.add(ss[0]);
			store2.add(ss[1]);
			store.add(store2);
		}

		dfs(0, "", 0);
		if (targetNumber == 0) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}

	}

	public static int check(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'Y') {
				sum += 1;
			}
		}
		return sum;
	}

	public static void dfs(int depth, String s, int count) {
		if (depth == N) {
			if (targetNumber <= check(s)) {
				targetNumber = check(s);
				answer = Math.min(answer, count);
			}
			return;
		}
		dfs(depth + 1, find(s, store.get(depth)), count + 1);
		dfs(depth + 1, s, count);
	}

	public static String find(String s, List<String> store) {
		String str = store.get(1);

		if (s.equals("")) {
			return str;
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				if (s.charAt(i) == 'N' && str.charAt(i) == 'N') {
					sb.append("N");
				} else {
					sb.append("Y");
				}
			}

			return sb.toString();
		}
	}
}
