import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baekjoon_1124 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] a = br.readLine().split(" ");
		int answer = 0;
		for (int i = Integer.parseInt(a[0]); i <= Integer.parseInt(a[1]); i++) {
			if (prime(check(i))) {
				answer += 1;
			}
		}
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	public static int check(int i) {
		int answer = 0;
		while (!prime(i) && i != 1) {
			for (int j = 2; j <= i; j++) {
				if (i % j == 0) {
					i = i / j;
					answer += 1;
					break;
				}

			}
		}
		if (i == 1) {
			return answer;
		} else {
			return answer + 1;
		}
	}

	public static boolean prime(int i) {
		if (i < 2)
			return false;
		for (int j = 2; j <= Math.sqrt(i); j++) {
			if (i % j == 0) {
				return false;
			}
		}
		return true;
	}
}