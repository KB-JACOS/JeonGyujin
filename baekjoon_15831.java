import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baekjoon_15831 {

	static int max = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String [] a = br.readLine().split(" ");
		int N = Integer.parseInt(a[0]);
		//원하는 검은 조약돌의 최대 개수
		int B = Integer.parseInt(a[1]);
		//원하는 하얀 조약돌의 최대 개수
		int W = Integer.parseInt(a[2]);
		String line = br.readLine();

		int start = 0;
		int last = 0;

		int blackStone = 0;
		int whiteStone = 0;
		while(last < line.length()){

			if (blackStone <= B){
				if (String.valueOf(line.charAt(last)).equals("W")){
					whiteStone += 1;
				}else{
					blackStone += 1;
				}
				last += 1;
			}
			while(blackStone > B && start < last){
				if (String.valueOf(line.charAt(start)).equals("W")){
					whiteStone -= 1;
				}else{
					blackStone -= 1;
				}
				start += 1;
			}
			if(blackStone <= B && whiteStone >= W){
				max = Math.max(max, last - start);
			}
		}
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();

	}
}
