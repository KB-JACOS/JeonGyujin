import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class baekjoon_2565 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<List<Integer>> a = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			List<Integer> aa = Arrays.stream(s).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
			a.add(aa);
		}
		a.sort((a1, b1) -> a1.get(0) - b1.get(0));

		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (a.get(j).get(1) < a.get(i).get(1)) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}
		int max = Arrays.stream(dp).max().getAsInt();
		System.out.println(N - max);
	}
}
