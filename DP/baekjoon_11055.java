package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 풀이방식 : 11053번 문제와 비슷하게 이 문제도 dp를 활용해서 풀어야 한다.
 for문으로 루프를 돌면서 현재 숫자보다 이전에 있는 숫자 중 작은 숫자를 찾는다.
 이 작은 숫자들 중 dp 배열에 저장되어 있는 값이 가장 큰 값을 찾아서 그것을 현재 숫자에 더해주는 방식으로 진행한다.
 for문을 다 완료하고 나서, dp 배열에 저장되어 있는 숫자 중 가장 큰 값이, 수열의 증가하는 부분 수열 중에서 합이 가장 클 것이다.

 **/
public class baekjoon_11055 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a = Integer.parseInt(br.readLine());

		String[] arr = br.readLine().split(" ");
		int[] arrNumber = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();

		int[] dp = new int[a + 1];
		for (int i = 0; i < a; i++) {
			dp[i] = arrNumber[i];
		}

		for (int i = 0; i < a; i++) {
			int value = 0;
			for (int j = 0; j < i; j++) {
				if (arrNumber[j] < arrNumber[i]) {
					if (dp[j] > value) {
						value = dp[j];
					}
				}
			}
			dp[i] = Math.max(dp[i] + value, dp[i]);
		}
		int max = Arrays.stream(dp).max().getAsInt();
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}
}