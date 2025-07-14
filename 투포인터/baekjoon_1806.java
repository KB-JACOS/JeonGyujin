package 투포인터;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_1806 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int S = Integer.parseInt(s[1]);
		String[] ss = br.readLine().split(" ");
		int[] store = Arrays.stream(ss).mapToInt(Integer::parseInt).toArray();

		int left = 0;
		int right = 0;
		int sum = 0;
		int answer = Integer.MAX_VALUE;
		while (right < store.length) {
			if (sum < S) {
				sum += store[right];
				right += 1;
			}

			while (sum >= S && left < store.length && left < right) {
				answer = Math.min(answer, right - left);
				sum -= store[left];
				left += 1;
			}

		}
		if (answer == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(answer);
		}
	}
}
