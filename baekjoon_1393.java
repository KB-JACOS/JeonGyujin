import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class baekjoon_1393 {

	static int max = Integer.MAX_VALUE;
	static List<Integer> answer = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] a = br.readLine().split(" ");
		int stationX = Integer.parseInt(a[0]);
		int stationY = Integer.parseInt(a[1]);

		String[] b = br.readLine().split(" ");
		int currentX = Integer.parseInt(b[0]);
		int currentY = Integer.parseInt(b[1]);
		int max = (stationX - currentX) * (stationX - currentX) + (stationY - currentY) * (stationY - currentY);

		int dx = Integer.parseInt(b[2]);
		int dy = Integer.parseInt(b[3]);
		int gcdNumber = gcd(Math.min(dx,dy), Math.max(dx, dy));
		int newDx = dx / gcdNumber;
		int newDy = dy / gcdNumber;
		int answerX = currentX;
		int answerY = currentY;

		while (true) {
			currentX += newDx;
			currentY += newDy;
			int value = (stationX - currentX) * (stationX - currentX) + (stationY - currentY) * (stationY - currentY);
			if (value >= max){
				break;
			}
			max = value;
			answerX = currentX;
			answerY = currentY;

		}

		bw.write(String.format("%d %d", answerX, answerY));
		bw.flush();
		bw.close();
	}
	public static int gcd(int a, int b){
		if(a == 0){
			return b;
		}
		return gcd(b%a, a);
	}
}
