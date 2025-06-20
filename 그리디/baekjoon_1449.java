package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class baekjoon_1449 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String [] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int L = Integer.parseInt(s[1]);

		List<Integer> a = new ArrayList<>();


		String [] input = br.readLine().split(" ");
		for (int i = 0; i < input.length; i++) {
			a.add(Integer.parseInt(input[i]));
		}

		Collections.sort(a);
		int answer = 1;
		int curr = a.get(0);
		for(int value : a){
			if (value - curr >= L){
				curr = value;
				answer +=1;
			}
		}
		System.out.println(answer);
	}
}
