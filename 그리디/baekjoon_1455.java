package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;

public class baekjoon_1455 {

	static int [][] board;

	static int N,M;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String [] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			String ss = br.readLine();
			for (int j = 0; j < ss.length(); j++) {
				board[i][j] = Integer.parseInt(String.valueOf(ss.charAt(j)));
			}
		}
		//System.out.println(Arrays.deepToString(board));
		int answer = 0;
		while(true) {
			if (check()){
				break;
			}
			int value = 0;
			int x = 0;
			int y = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] == 1) {
						if (i + j > value){
							x = i;
							y = j;
							value = i + j;
						}
					}
				}
			}
			change(x,y);
			answer +=1;
		}
		System.out.println(answer);
	}
	
	public static boolean check(){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1){
					return false;
				}
			}
		}
		return true;
	}
	public static void change(int i, int j){
		for (int k = 0; k <= i ; k++) {
			for (int l = 0; l <= j ; l++) {
				if (board[k][l] == 0){
					board[k][l] = 1;
				}else{
					board[k][l] = 0;
				}
			}
		}
	}
}
