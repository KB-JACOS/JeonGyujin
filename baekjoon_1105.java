import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 풀이방식 : 숫자의 길이가 최대 10자이기 때문에 완전탐색으로 풀어도 시간복잡도를 통과 할 것이라 생각했다.
 숫자 2개의 길이가 같거나 다른 상황으로 조건을 걸었다.
 숫자 2개의 길이가 다른 상황 --> 숫자의 길이가 커지는 상황(ex) 99 -> 100) 에서 모든 자릿수를 8이 아닌 숫자들로 만들 수 있기 때문에 무조건 0
 숫자 2개의 길이가 같은 상황 --> 숫자가 같다면 8을 가진 개수만큼이 정답일 것이고, 같지 않다면 앞 자리 부터 체크 하면서 두 숫자가 다른 값의 자릿수를
 가지고 있다면 여태까지 저장된 answer를 반환한다. 여기서 answer는 두 숫자의 자릿수가 같을 시, 8이라면 count 하여 저장된 값이다.
 **/

public class baekjoon_1105 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] a = br.readLine().split(" ");
		String number1 = a[0];
		String number2 = a[1];
		int answer = 0;

		if (number1.length() != number2.length()) {
			answer = 0;
		} else {
			if ((Integer.parseInt(number1) == Integer.parseInt(number2))) {
				for (int i = number1.length() - 1; i >= 0; i--) {
					if (Integer.parseInt(String.valueOf(number1.charAt(i))) == 8) {
						answer += 1;
					}
				}
			} else {
				for (int i = 0; i < number1.length(); i++) {
					if (number1.charAt(i) != number2.charAt(i)) {
						break;
					}
					if (Integer.parseInt(String.valueOf(number1.charAt(i))) == 8) {
						answer++;
					}
				}
			}

			bw.write(String.valueOf(answer));

			bw.flush();
			bw.close();

		}
	}
}

