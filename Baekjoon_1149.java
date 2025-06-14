import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_1149 {

	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int[][] store = new int[N][3];

		for (int i = 0; i < N; i++) {
			String[] a = br.readLine().split(" ");
			store[i] = Arrays.stream(a).mapToInt(Integer::parseInt).toArray();
		}

		for (int i = 1; i < N; i++) {
			store[i][0] += Math.min(store[i - 1][1], store[i - 1][2]);
			store[i][1] += Math.min(store[i - 1][0], store[i - 1][2]);
			store[i][2] += Math.min(store[i - 1][0], store[i - 1][1]);
		}

		System.out.println(Math.min(Math.min(store[N - 1][0], store[N - 1][1]), store[N - 1][2]));
	}
}
