import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class baekjoon_2512 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a = Integer.parseInt(br.readLine());
		String[] store = br.readLine().split(" ");
		int[] nums = new int[store.length];
		for (int i = 0; i < store.length; i++) {
			nums[i] = Integer.parseInt(store[i]);
		}
		long maxLine = Long.parseLong(br.readLine());
		int left = 1;
		int right = Arrays.stream(nums).max().getAsInt();
		int result = 0;
		int mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			int answer = 0;
			for (int i = 0; i < a; i++) {
				if (nums[i] <= mid) {
					answer += nums[i];
				} else {
					answer += mid;
				}
			}
			if (answer > maxLine) {
				right = mid - 1;
			} else {
				result = mid;
				left = mid + 1;
			}

		}
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
}
