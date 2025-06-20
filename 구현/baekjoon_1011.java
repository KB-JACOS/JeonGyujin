package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
풀이방식: 처음에는 dp 문제인가 싶었지만, 수학적으로 빡구현을 해보기로 했다.
 제시된 x지점과 y지점은 각각 1로 시작하거나 1로 도착하는 경우의 수 밖에 없으므로 result 변수에
 2를 넣어주고 시작지점 + 1, 도착지점 + 1을 변수로 사용했다. 입력값으로 주어진 x지점과 y지점의
 예외처리는 따로 해주었다. ex) E-S == 1이라면 1 만큼 움직이고 끝나기 때문에 1 출력하고 종료)
 예외처리를 당하지 않은 변수들은 최소 1번이라도 2 만큼 움직일 수 있는 것들이기 때문에, while 루프를
 돌면서 result 의 값을 올려준다. 주된 로직은 최소 거리를 가려고 한다면 최대한 멀리 뛰어야 하지만,
 아래의 규정 때문에 이동하는 값을 단계를 밟아서 차근차근 올리고 차근차근 내려야 할 것이다.
 2로 초기 지정한 current 변수로 value 값을 빼면서 result 를 올린다. 만약 value가 0보다 작아진다면
 break 를 걸어 result 변수가 업데이트 되지 못하게 한다.

 규정 : 예를 들어, 이 장치를 처음 작동시킬 경우 -1 , 0 , 1 광년을 이론상 이동할 수 있으나
 사실상 음수 혹은 0 거리만큼의 이동은 의미가 없으므로 1 광년을 이동할 수 있으며,
 그 다음에는 0 , 1 , 2 광년을 이동할 수 있는 것이다.
 ( 여기서 다시 2광년을 이동한다면 다음 시기엔 1, 2, 3 광년을 이동할 수 있다. )


 **/
public class baekjoon_1011 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int result = 2;
			String[] a = br.readLine().split(" ");
			int S = Integer.parseInt(a[0]);
			int E = Integer.parseInt(a[1]);
			if (E - S == 1) {
				System.out.println(1);
				continue;
			} else if (E - S == 2) {
				System.out.println(2);
				continue;
			}

			S += 1;
			E -= 1;
			if (E - S == 1) {
				System.out.println(result + 1);
				continue;
			}

			int value = E - S;
			int current = 2;
			while (0 < value) {
				System.out.println(result);
				for (int j = 0; j < 2; j++) {
					if (value <= 0){
						break;
					}
					value -= current;
					result += 1;

				}
				current +=1;
			}
			System.out.println(result);
		}
	}
}
