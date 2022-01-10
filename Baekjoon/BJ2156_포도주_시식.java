package week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2156_������_�ý� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = arr[0];
		if(N == 1) {
			System.out.println(dp[N-1]);
			return;
		}
		dp[1] = arr[1] + arr[0];
		if(N == 2) {
			System.out.println(dp[N-1]);
			return;
		}
		dp[2] = Math.max(Math.max(dp[1], dp[0] + arr[2]), arr[1] + arr[2]);
		if(N == 3) {
			System.out.println(dp[N-1]);
			return;
		}
		for (int i = 3; i < N; i++) {
			dp[i] = Math.max(Math.max(dp[i-2] + arr[i], dp[i-3]+arr[i-1] + arr[i]), dp[i-1]);
		}
		System.out.println(dp[N-1]);
	}

}
