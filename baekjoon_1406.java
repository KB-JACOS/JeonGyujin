import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class baekjoon_1406{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		int a = Integer.parseInt(br.readLine());
		Stack<String> left = new Stack<>();
		Stack<String> right = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			left.push(String.valueOf(s.charAt(i)));
		}

		for (int i = 0; i < a; i++) {
			String[] store = br.readLine().split(" ");
			if (store[0].equals("P")) {
				left.push(String.valueOf(store[1]));
			} else if (store[0].equals("L")) {
				if (!left.isEmpty()) {
					right.push(left.pop());
				}
			} else if (store[0].equals("D")) {
				if (!right.isEmpty()) {
					left.push(right.pop());
				}
			} else if (store[0].equals("B")) {
				if (!left.isEmpty()) {
					left.pop();
				}
			}
		}

		while (!left.isEmpty()) {
			right.push(left.pop());
		}
		StringBuilder sb = new StringBuilder();
		while (!right.isEmpty()) {
			sb.append(right.pop());
		}

		bw.write(sb.toString());

		bw.flush();
		bw.close();
	}
}

