import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class baekjoon_1421 {

	static long answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String [] input = br.readLine().split(" ");
		//나무의 개수
		int N = Integer.parseInt(input[0]);
		//자를때 드는 비용
		int C = Integer.parseInt(input[1]);
		//나무 한 단위의 가격
		int W = Integer.parseInt(input[2]);

		List<Integer> store = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			store.add(Integer.parseInt(br.readLine()));
		}
		int max = Collections.max(store);
		for (long i = 1; i <= max ; i++) {
			long sum = 0;
			for (int j = 0; j < store.size(); j++) {

				long cutCount = 0;
				long woodCount = 0;
				if (store.get(j) % i == 0){
					cutCount = store.get(j) / i - 1;
				}else{
					cutCount = store.get(j) / i;
				}
				woodCount = store.get(j) / i;
				long profit = woodCount * W * i - cutCount * C;
				//음수 값이 더해지는 상황을 막기 위함, 어떤 정답케이스는 나무들 중 profit 이
				// 음수가 나오는 경우도 있을 것인데, 그것을 막 더해버리면 최종 sum 이 작아져서
				// 최댓값으로 채택이 안되는 경우도 있다. 그런 경우를 막기 위해서, profit 이 양수인 것만 더한다.
				if (profit > 0){
					sum += profit;
				}
			}
			if (sum > answer){
				//System.out.println(sum);
				answer = sum;
			}
		}
		System.out.println(answer);
	}
}
