package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_2156 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] array = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		int [] dp = new int[N+3];
		dp[0] = 0;

		dp[1] = array[1];
		if (N == 1){
			System.out.println(dp[1]);
			return;
		}

		dp[2] = array[1] + array[2];
		if (N == 2){
			System.out.println(dp[2]);
			return;
		}
		dp[3] = Math.max(Math.max(array[1] + array[2], array[2] + array[3]),array[1] + array[3]);
		for (int i = 4; i <= N ; i++) {
			dp[i] = Math.max(Math.max(dp[i-3] + array[i] + array[i-1] , array[i] + dp[i-2]) , dp[i-1]);
		}

		System.out.println(Arrays.stream(dp).max().getAsInt());

	}
}
