import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon_1074 {

	static int ans = 0;

	static int R,C;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String [] s = br.readLine().split(" ");

		int N = Integer.parseInt(s[0]);
		R = Integer.parseInt(s[1]);
		C = Integer.parseInt(s[1]);
		solve(0,0,(int)Math.pow(2,N));

	}

	public static void solve(int r, int c, int size){
		if (size == 1){
			System.out.println(ans);
			return;
		}

		int newSize = size / 2;

		if (R < r + newSize && C < c + newSize){
			solve(r,c,newSize);
		}
		else if (R < r + newSize && c + newSize <= C){
			ans += (size*size) / 4;
			System.out.println(ans);
			solve(r, c+newSize, newSize);
		}
		else if (r+newSize <= R && C < c + newSize){
			ans += ((size * size) / 4) * 2;
			System.out.println(ans);
			solve(r+newSize, c, newSize);
		}
		else if (r + newSize <= R && c + newSize <= C){
			ans += ((size * size) / 4) * 3;
			System.out.println(ans);
			solve(r+newSize, c+newSize, newSize);
		}

	}
}
