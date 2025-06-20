package 구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 풀이방식 : friend 배열에 N,Y에 맞게 값을 집어 넣는다. 루프를 돌면서 이 배열의 값을 확인하면서
 2-친구의 수를 구한다. 본인이 아닌 다른 사람과 직접 친구라면 친구-2에 카운트를 하고, 만약 직접 친구가 아니라면
 check 함수를 호출한다. check 함수는 직접 친구가 아닌 두 사람의 인덱스를 넘겨서 friend 배열에서
 두 사람의 친구가 있는지 확인한다. 친구가 있다면 친구-2에 카운트를 한다. 모든 사람의 친구-2의 수를
 리스트에 넣어서 리스트에서 가장 큰수를 출력한다.
 **/
public class baekjoon_1058 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> answer = new ArrayList<>();
		int a = Integer.parseInt(br.readLine());
		int[][] friend = new int[a][a];
		for (int i = 0; i < a; i++) {
			String alphabet = br.readLine();
			for (int j = 0; j < alphabet.length(); j++) {
				if (String.valueOf(alphabet.charAt(j)).equals("Y")) {
					friend[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < a; i++) {
			int number = 0;
			for (int j = 0; j < a; j++) {
				if (i == j)
					continue;
				if (friend[i][j] == 1) {
					number += 1;
				} else {
					if (check(friend, i, j)) {
						number += 1;
					}
				}
			}
			answer.add(number);
		}
		bw.write(String.valueOf(Collections.max(answer)));

		bw.flush();
		bw.close();
	}

	public static boolean check(int[][] friend, int i, int j) {
		for (int k = 0; k < friend.length; k++) {
			if (k == i || k == j)
				continue;
			if (friend[k][i] == 1 && friend[k][j] == 1) {
				return true;
			}
		}
		return false;
	}

}
