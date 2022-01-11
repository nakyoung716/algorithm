package week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11060_점프_점프 {

	static int[] dp, nums;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			if(dp[i] != Integer.MAX_VALUE)
				solve(i);
		}
		if(dp[N-1] == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(dp[N-1]);
	}

	private static void solve(int n) {
		for (int i = 1; i <= nums[n]; i++) {
			if(n+i >= N) {
				return;
			}
			dp[n+i] = Math.min(dp[n] + 1, dp[n+i]);
		}
	}

}
