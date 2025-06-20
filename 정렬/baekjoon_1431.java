package 정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class baekjoon_1431 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<String> a = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			a.add(br.readLine());
		}
		a.sort((a1, b1) -> {
			if (a1.length() == b1.length()) {
				int valueA1 = sum(a1);
				int valueB1 = sum(b1);
				if (valueA1 != valueB1) {
					return valueA1 - valueB1;
				} else {
					return a1.compareTo(b1);
				}

			} else {
				return a1.length() - b1.length();
			}

		});
		for (String value : a) {
			System.out.println(value);
		}
	}

	public static int sum(String str1) {
		int sum = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) == '0' || str1.charAt(i) == '1' || str1.charAt(i) == '2' || str1.charAt(i) == '3'
				|| str1.charAt(i) == '4' || str1.charAt(i) == '5' || str1.charAt(i) == '6' || str1.charAt(i) == '7'
				|| str1.charAt(i) == '8' || str1.charAt(i) == '9') {
				sum += Integer.parseInt(String.valueOf(str1.charAt(i)));
			}
		}
		return sum;
	}

}
