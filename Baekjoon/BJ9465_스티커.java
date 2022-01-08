package week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9465_스티커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int arr[][] = new int[2][N];
			int dp[][] = new int[2][N];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			for (int i = 1; i < N; i++) {
				if(i >1) {
					dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
					dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
				}
				else {
					dp[0][i] = dp[1][i-1] + arr[0][i];
					dp[1][i] = dp[0][i-1] + arr[1][i];
				}
			}
			System.out.println(Math.max(dp[0][N-1], dp[1][N-1]));
		}
	}

}
