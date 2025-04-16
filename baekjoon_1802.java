import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class baekjoon_1802 {
	static List<String> answer = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			String str = br.readLine();
			answer.add(check(str));
		}
		for (int i = 0; i < answer.size(); i++) {
			bw.write(answer.get(i));
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}

	public static String check(String a) {
		Queue<String> store = new ArrayDeque<>();
		store.offer(a);
		boolean checkValue = true;
		while (!store.isEmpty()) {
			String aa = store.poll();
			int mid = aa.length() / 2;
			if (aa.length() == 1) {
				break;
			}
			String str1 = aa.substring(0, mid);
			String str2 = aa.substring(mid + 1);
			if (!compare(str1, str2)) {
				checkValue = false;
				break;

			}
			store.offer(str1);
			store.offer(str2);

		}
		return checkValue ? "YES" : "NO";
		
	}

	public static boolean compare(String s1, String s2) {
		boolean checkValue = true;
		for (int i = 0; i < s1.length(); i++) {
			if (String.valueOf(s1.charAt(i)).equals(String.valueOf(s2.charAt(s1.length() - i - 1)))) {
				checkValue = false;
				break;
			}
		}
		return checkValue;
	}

}
