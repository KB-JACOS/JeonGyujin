import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon_1802 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (solve(s)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	public static boolean solve(String s){
		if (s.length() == 1){
			return true;
		}

		int idx = s.length() / 2 ;
		String str1 = s.substring(0, idx);
		String str2 = s.substring(idx+1);

		if (check(str1, str2)){
			//재귀 계속 돌리기
			return solve(str1) & solve(str2);

		}else{
			return false;
		}


	}

	public static boolean check(String str1, String str2){
		StringBuilder sb = new StringBuilder(str2);
		String a = sb.reverse().toString();

		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) == a.charAt(i)){
				return false;
			}
		}
		return true;
	}
}
