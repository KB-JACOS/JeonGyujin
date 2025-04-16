import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class baekjoon_11659 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String [] a = br.readLine().split(" ");
		String [] numArray = br.readLine().split(" ");
		int [] num = Arrays.stream(numArray).mapToInt(Integer::parseInt).toArray();

		int [] dp = new int[Integer.parseInt(a[0]) + 1];
		dp[0] = 0;
		for (int i = 1; i <= Integer.parseInt(a[0]); i++) {
			dp[i] = dp[i-1] + num[i-1];
		}

		for (int i = 0; i < Integer.parseInt(a[1]); i++) {
			String [] index = br.readLine().split(" ");
			int start = dp[Integer.parseInt(index[0]) - 1];
			int last = dp[Integer.parseInt(index[1])];
			bw.write(String.valueOf(last - start));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
