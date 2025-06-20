package 구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 풀이방식 : 문자열의 최대 길이가 50이므로 브루트 포스로 풀어도 시간복잡도를 넘지 않는다고 판단
 변수 i를 인덱스로 사용하여 기존에 주어진 문자열을 앞에서부터 차례대로 그 문자열의 끝에 붙여주는 방식
 계속 변경되는 문자열과 그 문자열을 뒤집은 값이 같다면 while 루프문 탈출 후, 길이 값 출력

 배운점: sb.reverse( )는 변수에 배정해주지 않아도 sb 값이 바뀜
 		StringBuilder 변수와 String 변수를 비교하면 값의 일치 여부에 관계없이 무조건 false
 **/
public class baekjoon_1254 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String a = br.readLine();
		StringBuilder sb = new StringBuilder(a);
		int i = 0;
		String aa = sb.reverse().toString();
		sb.reverse();
		while (!sb.toString().equals(aa)) {

			sb = new StringBuilder(sb.substring(0, sb.length() - i) + sb.charAt(i) + sb.substring(sb.length() - i ));

			aa = sb.reverse().toString();
			sb.reverse();
			i += 1;
		}
		bw.write(String.valueOf(sb.toString().length()));
		bw.flush();
		bw.close();

	}
}
