import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class baekjoon_1063 {


	static int [] dx = {0,0,1,-1,-1,-1,1,1};
	static int [] dy = {1,-1,0,0,1,-1,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] s = br.readLine().split(" ");
		String king = s[0];
		String stone = s[1];
		int N = Integer.parseInt(s[2]);
		// System.out.println(8 - 1);
		// System.out.println('A' - 64);
		int kingX = 8 - Integer.parseInt(String.valueOf(king.charAt(1)));
		int kingY = king.charAt(0) - 65;

		int stoneX = 8 - Integer.parseInt(String.valueOf(stone.charAt(1)));
		int stoneY = stone.charAt(0) - 65;
		List<String> list = new ArrayList<>();
		list.add("R");
		list.add("L");
		list.add("B");
		list.add("T");
		list.add("RT");
		list.add("LT");
		list.add("RB");
		list.add("LB");

		// System.out.println("kingY: " + kingY);
		// System.out.println("kingX: " + kingX);
		// System.out.println("stoneX: " + stoneX);
		// System.out.println("stoneY: " + stoneY);

		for (int i = 0; i < N; i++) {
			String str1 = br.readLine();
			if (str1.equals("R")){
				int ax = kingX + dx[list.indexOf("R")];
				int ay = kingY + dy[list.indexOf("R")];

				int ax1 = stoneX + dx[list.indexOf("R")];
				int ay1 = stoneY + dy[list.indexOf("R")];

				if (ax < 0 || ax > 7 || ay < 0 || ay > 7) {
					continue;
				}


				if (ax == stoneX && ay == stoneY){
					if (ax1 < 0 || ax1 > 7 || ay1 < 0 || ay1 > 7){
						continue;
					}else{
						kingX = ax;
						kingY = ay;
						stoneX = ax1;
						stoneY = ay1;
					}

				}else{
					kingX = ax;
					kingY = ay;
				}
			}else if (str1.equals("L")){
				int ax = kingX + dx[list.indexOf("L")];
				int ay = kingY + dy[list.indexOf("L")];

				int ax1 = stoneX + dx[list.indexOf("L")];
				int ay1 = stoneY + dy[list.indexOf("L")];

				if (ax < 0 || ax > 7 || ay < 0 || ay > 7) {
					continue;
				}


				if (ax == stoneX && ay == stoneY){
					if (ax1 < 0 || ax1 > 7 || ay1 < 0 || ay1 > 7){
						continue;
					}else{
						kingX = ax;
						kingY = ay;
						stoneX = ax1;
						stoneY = ay1;
					}

				}else{
					kingX = ax;
					kingY = ay;
				}
			}
			else if (str1.equals("B")){

				int ax = kingX + dx[list.indexOf("B")];
				int ay = kingY + dy[list.indexOf("B")];

				int ax1 = stoneX + dx[list.indexOf("B")];
				int ay1 = stoneY + dy[list.indexOf("B")];

				if (ax < 0 || ax > 7 || ay < 0 || ay > 7) {
					continue;
				}


				if (ax == stoneX && ay == stoneY){
					if (ax1 < 0 || ax1 > 7 || ay1 < 0 || ay1 > 7){
						continue;
					}else{
						kingX = ax;
						kingY = ay;
						stoneX = ax1;
						stoneY = ay1;
					}

				}else{
					kingX = ax;
					kingY = ay;
				}
			}
			else if (str1.equals("T")){
				System.out.println("-------");
				int ax = kingX + dx[list.indexOf("T")];
				int ay = kingY + dy[list.indexOf("T")];

				int ax1 = stoneX + dx[list.indexOf("T")];
				int ay1 = stoneY + dy[list.indexOf("T")];

				if (ax < 0 || ax > 7 || ay < 0 || ay > 7) {
					continue;
				}


				if (ax == stoneX && ay == stoneY){
					if (ax1 < 0 || ax1 > 7 || ay1 < 0 || ay1 > 7){
						continue;
					}else{
						kingX = ax;
						kingY = ay;
						stoneX = ax1;
						stoneY = ay1;
					}

				}else{
					kingX = ax;
					kingY = ay;
				}
			}else if (str1.equals("RT")){
				int ax = kingX + dx[list.indexOf("RT")];
				int ay = kingY + dy[list.indexOf("RT")];

				int ax1 = stoneX + dx[list.indexOf("RT")];
				int ay1 = stoneY + dy[list.indexOf("RT")];

				if (ax < 0 || ax > 7 || ay < 0 || ay > 7) {
					continue;
				}


				if (ax == stoneX && ay == stoneY){
					if (ax1 < 0 || ax1 > 7 || ay1 < 0 || ay1 > 7){
						continue;
					}else{
						kingX = ax;
						kingY = ay;
						stoneX = ax1;
						stoneY = ay1;
					}

				}else{
					kingX = ax;
					kingY = ay;
				}
			}else if (str1.equals("LT")){
				int ax = kingX + dx[list.indexOf("LT")];
				int ay = kingY + dy[list.indexOf("LT")];

				int ax1 = stoneX + dx[list.indexOf("LT")];
				int ay1 = stoneY + dy[list.indexOf("LT")];

				if (ax < 0 || ax > 7 || ay < 0 || ay > 7) {
					continue;
				}


				if (ax == stoneX && ay == stoneY){
					if (ax1 < 0 || ax1 > 7 || ay1 < 0 || ay1 > 7){
						continue;
					}else{
						kingX = ax;
						kingY = ay;
						stoneX = ax1;
						stoneY = ay1;
					}

				}else{
					kingX = ax;
					kingY = ay;
				}
			}else if (str1.equals("RB")){
				int ax = kingX + dx[list.indexOf("RB")];
				int ay = kingY + dy[list.indexOf("RB")];

				int ax1 = stoneX + dx[list.indexOf("RB")];
				int ay1 = stoneY + dy[list.indexOf("RB")];

				if (ax < 0 || ax > 7 || ay < 0 || ay > 7) {
					continue;
				}


				if (ax == stoneX && ay == stoneY){
					if (ax1 < 0 || ax1 > 7 || ay1 < 0 || ay1 > 7){
						continue;
					}else{
						kingX = ax;
						kingY = ay;
						stoneX = ax1;
						stoneY = ay1;
					}

				}else{
					kingX = ax;
					kingY = ay;
				}
			}else if (str1.equals("LB")){
				int ax = kingX + dx[list.indexOf("LB")];
				int ay = kingY + dy[list.indexOf("LB")];

				int ax1 = stoneX + dx[list.indexOf("LB")];
				int ay1 = stoneY + dy[list.indexOf("LB")];

				if (ax < 0 || ax > 7 || ay < 0 || ay > 7) {
					continue;
				}


				if (ax == stoneX && ay == stoneY){
					if (ax1 < 0 || ax1 > 7 || ay1 < 0 || ay1 > 7){
						continue;
					}else{
						kingX = ax;
						kingY = ay;
						stoneX = ax1;
						stoneY = ay1;
					}

				}else{
					kingX = ax;
					kingY = ay;
				}
			}
		}
		// System.out.println("kingY: " + kingY);
		// System.out.println("kingX: " + kingX);
		// System.out.println("stoneX: " + stoneX);
		// System.out.println("stoneY: " + stoneY);
		int StringOfKingY = 65 + kingY;
		char kingYY = (char) StringOfKingY;

		int StringOfStoneY = 65 + stoneY;
		char stoneYY = (char) StringOfStoneY;

		System.out.println(kingYY + String.valueOf(8 - kingX));
		System.out.println(stoneYY + String.valueOf(8 - stoneX));


	}
}
