package 이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class baekjoon_1654 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] a = br.readLine().split(" ");
		List<Long> store = new ArrayList<>();

		for (int i = 0; i < Integer.parseInt(a[0]); i++) {
			store.add(Long.parseLong(br.readLine()));
		}
		long right = Collections.max(store);
		long left = 1;
		long mid = 0;
		long result = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			long answer = 0;
			for (int i = 0; i < Integer.parseInt(a[0]); i++) {
				answer += store.get(i) / mid;
			}
			if (answer < Integer.parseInt(a[1])) {
				right = mid - 1;
			} else {
				result = mid;
				left = mid + 1;
			}

		}
		bw.write(String.valueOf(result));

		bw.flush();
		bw.close();
	}
}
