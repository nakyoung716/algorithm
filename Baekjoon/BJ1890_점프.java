package week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1890_มกวม {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		long[][] dp = new long[N][N];
		dp[0][0] = 1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(dp[i][j] != 0 && (i != N-1 || j != N-1)) {
					if(i+arr[i][j] < N)
						dp[i+arr[i][j]][j] += dp[i][j];
					if(j+arr[i][j] < N)
						dp[i][j+arr[i][j]] += dp[i][j];
				}
			}
		}
		System.out.println(dp[N-1][N-1]);
	}
}
