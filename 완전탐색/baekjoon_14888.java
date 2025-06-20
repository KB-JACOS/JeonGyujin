package 완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class baekjoon_14888 {

	static List<Integer> answer = new ArrayList<>();
	static boolean[] visited;

	static List<String> op = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a = Integer.parseInt(br.readLine());
		String [] aaa = br.readLine().split(" ");
		int[] store = Arrays.stream(aaa).mapToInt(Integer::parseInt).toArray();

		String[] aa = br.readLine().split(" ");
		int[] operator = Arrays.stream(aa).mapToInt(Integer::parseInt).toArray();
		int value = 0;
		for (int i = 0; i < operator.length; i++) {
			value += operator[i];
		}
		if (operator[0] >= 1){
			for (int i = 0; i < operator[0]; i++) {
				op.add("+");
			}
		}

		if (operator[1] >= 1) {
			for (int i = 0; i < operator[1]; i++) {
				op.add("-");
			}
		}
		if (operator[2] >= 1){
			for (int i = 0; i < operator[2]; i++) {
				op.add("*");
			}
		}

		if (operator[3] >= 1) {
			for (int i = 0; i < operator[3]; i++) {
				op.add("/");
			}

		}
		visited = new boolean[value];


		dfs(0, store, store[0], op);

		List<Integer> realAnswer = new ArrayList<>();
		realAnswer.add(Collections.max(answer));
		realAnswer.add(Collections.min(answer));
		for (int i = 0; i < realAnswer.size(); i++) {
			bw.write(String.valueOf(realAnswer.get(i)));
			if (i < realAnswer.size() - 1) {
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();

	}

	public static void dfs(int depth, int[] store, int sum, List<String> op) {
		if (depth == store.length - 1) {
			answer.add(sum);
			return;
		}
		for (int i = 0; i < op.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				if (op.get(i).equals("+")) {
					dfs(depth + 1, store, sum + store[depth + 1], op);
				} else if (op.get(i).equals("-")) {
					dfs(depth+1, store, sum - store[depth+1], op);
				} else if (op.get(i).equals("*")){
					dfs(depth+1, store, sum * store[depth+1], op);
				} else if (op.get(i).equals("/")) {
					dfs(depth+1, store, sum / store[depth+1], op);
				}
				visited[i] = false;
			}
		}

	}
}
