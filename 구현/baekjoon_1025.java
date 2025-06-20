package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon_1025 {

	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String [] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);

		int [][] store = new int[N][M];
		for (int i = 0; i < N; i++) {
			String ss = br.readLine();
			for (int j = 0; j < M; j++) {
				store[i][j] = Integer.parseInt(String.valueOf(ss.charAt(j)));
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int di = -N; di < N; di++) {
					for (int dj = -M; dj < M; dj++) {
						if (di == 0 && dj == 0){
							continue;
						}

						int num = 0;
						int newRow = i;
						int newCol = j;

						while(newRow >= 0 && newRow < N && newCol >= 0 && newCol < M){
							num = num * 10 + store[newRow][newCol];

							if (check(num)){
								answer = Math.max(answer, num);
							}

							newRow += di;
							newCol += dj;

						}
					}
				}
			}

		}
		if (!check2(store) && answer == 0){
			System.out.println(-1);
			return;
		}
		System.out.println(answer);


	}

	public static boolean check2(int [][] store){

		for (int i = 0; i < store.length; i++) {
			for (int j = 0; j < store[0].length; j++) {
				if (store[i][j] == 0){
					return true;
				}
			}
		}
		return false;

	}
	public static boolean check(int i){
		if ((int)Math.sqrt(i) * (int) Math.sqrt(i) == i){
			return true;
		}
		return false;
	}


}