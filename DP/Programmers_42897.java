package DP;

import java.util.Arrays;

public class Programmers_42897 {

	public static int solution(int[] money) {

		int[] dp = new int[money.length + 1];

		dp[1] = money[0];
		if (money.length == 1) {
			return dp[1];
		}
		dp[2] = Math.max(money[0], money[1]);
		if (money.length == 2){
			return dp[2];
		}
		int max1 = 0;
		int max2 = 0;

		for (int i = 3; i < money.length; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + money[i-1]);
		}
		max1 = Arrays.stream(dp).max().getAsInt();

		dp = new int[money.length + 1];
		dp[1] = 0;
		dp[2] = money[1];
		for (int i = 3; i <= money.length; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + money[i-1]);
		}
		max2 = Arrays.stream(dp).max().getAsInt();

		return Math.max(max1,max2);
	}

	public static void main(String[] args) {
		int[] money = {10,2,5,15,18,6};
		System.out.println(solution(money));
	}
}
