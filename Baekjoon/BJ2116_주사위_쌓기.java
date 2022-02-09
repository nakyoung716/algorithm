package week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2116_주사위_쌓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int dice[][] = new int [N][6];
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 6; i++) {
				dice[n][i] = Integer.parseInt(st.nextToken());
			}
		}
		int bottom, top;
		int max = 0;
		for (int i = 0; i < 6; i++) {
			int cnt = 0;
			bottom = dice[0][i];
			if(1 <= i && i <= 2)
				top = dice[0][i+2];
			else if(3<= i && i <= 4)
				top = dice[0][i-2];
			else
				top = dice[0][5-i];
			
			if(top != 6 && bottom != 6)
				cnt = 6;
			else if((top == 6 && bottom == 5) || (top == 5 && bottom == 6))
				cnt = 4;
			else
				cnt = 5;
			
			for (int j = 1; j < N; j++) {
				for (int k = 0; k < 6; k++) {
					if(dice[j][k] == top) {
						bottom = dice[j][k];
						if(1 <= k && k <= 2)
							top = dice[j][k+2];
						else if(3<= k && k <= 4)
							top = dice[j][k-2];
						else
							top = dice[j][5-k];
						break;
					}
				}

				if(top != 6 && bottom != 6)
					cnt += 6;
				else if((top == 6 && bottom == 5) || (top == 5 && bottom == 6))
					cnt += 4;
				else
					cnt += 5;
			}
			if(cnt > max)
				max = cnt;
		}
		System.out.println(max);
	}
}
