package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11058_크리보드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		long dp[] = new long[N+1];
		for (int i = 0; i < N + 1; i++) {
			dp[i] = i;
		}
		for (int j = 2; j < 6; j++) {			
			for (int i = j + 1; i < N + 1; i++) {
				dp[i] = Math.max(dp[i], dp[i - j - 1] * j);
			}
		}
		System.out.println(dp[N]);
	}

}
