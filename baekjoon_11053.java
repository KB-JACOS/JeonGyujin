import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class baekjoon_11053 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a = Integer.parseInt(br.readLine());

		String [] arr = br.readLine().split(" ");
		int [] arrNumber = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();

		int [] dp = new int[a+1];
		Arrays.fill(dp, 1);
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < i ; j++) {
				if (arrNumber[j] < arrNumber[i]){
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}
		int max = Arrays.stream(dp).max().getAsInt();
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}
}