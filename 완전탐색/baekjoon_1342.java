package 완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon_1342 {

	static int[] alpha = new int[26];

	static int N;

	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		N = input.length();

		for (char c : input.toCharArray()) {
			alpha[c - 'a'] += 1;
		}
		dfs(0, ' ');
		System.out.println(result);

	}
	//빈도수로 문자열을 생성하여 중복 순열을 차단함
	public static void dfs(int depth, char prev) {
		if (depth == N) {
			result += 1;
			return;
		}
		for (int i = 0; i < 26; i++) {
			if (alpha[i] == 0)
				continue;
			char curr = (char)('a' + i);
			if (prev == curr)
				continue;

			alpha[i]--;
			dfs(depth + 1, curr);
			alpha[i]++;
		}
	}
}



