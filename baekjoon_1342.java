import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class baekjoon_1342 {



	static boolean [] visited;

	static Set<String> store = new HashSet<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		if (check2(input)){
			int answer1 = 1;
			for (int i = input.length(); i >= 2 ; i--) {
				answer1 *= i;
			}
			System.out.println(answer1);
			return;
		}
		visited = new boolean[input.length()];
		dfs(0, input, "");
		int answer = 0;
		for(String value : store){
			if (check(value)){
				answer +=1;
			}
		}
		System.out.println(answer);

	}

	public static void dfs(int depth, String input, String current){
		if (depth == input.length()){
			store.add(current);
			return;
		}
		for (int i = 0; i < input.length(); i++) {
			if(!visited[i]){
				visited[i] = true;
				dfs(depth+1, input, current + input.charAt(i));
				visited[i] = false;
			}
		}
	}

	public static boolean check2(String str){
		List<String> a = new ArrayList<>();
		a.add(String.valueOf(str.charAt(0)));
		for (int i = 1; i < str.length(); i++) {
			if (a.contains(String.valueOf(str.charAt(i)))){
				return false;
			};
			a.add(String.valueOf(str.charAt(i)));
		}
		return true;
	}

	public static boolean check(String str) {
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i-1)){
				return false;
			}
		}
		return true;
	}
}
