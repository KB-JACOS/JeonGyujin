public class programmers_92344 {
	public static int solution(int[][] board, int[][] skill) {
		int answer = 0;
		int[][] store = new int[board.length + 1][board[0].length + 1];
		for (int i = 0; i < skill.length; i++) {
			if (skill[i][0] == 1) {
				store[skill[i][1]][skill[i][2]] -= skill[i][5];
				store[skill[i][3] + 1][skill[i][2]] += skill[i][5];
				store[skill[i][1]][skill[i][4] + 1] += skill[i][5];
				store[skill[i][3] + 1][skill[i][4] + 1] -= skill[i][5];

			} else if (skill[i][0] == 2) {
				store[skill[i][1]][skill[i][2]] += skill[i][5];
				store[skill[i][3] + 1][skill[i][2]] -= skill[i][5];
				store[skill[i][1]][skill[i][4] + 1] -= skill[i][5];
				store[skill[i][3] + 1][skill[i][4] + 1] += skill[i][5];
			}

		}

		for (int j = 0; j < store[0].length; j++) {
			for (int k = 1; k < store.length; k++) {
				store[k][j] += store[k - 1][j];
			}
		}
		for (int j = 0; j < store.length; j++) {
			for (int k = 1; k < store[0].length; k++) {
				store[j][k] += store[j][k - 1];
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] + store[i][j] > 0) {
					answer += 1;
				}
			}
		}
		return answer;
	}
}
