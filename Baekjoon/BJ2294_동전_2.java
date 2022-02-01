package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2294_동전_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N, K;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int cost[] = new int[N];
		int dp[] = new int[K+1];
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(cost);
		Arrays.fill(dp, 100001);
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			for (int j = cost[i]; j < K+1; j++) {
				dp[j] = Math.min(dp[j],dp[j - cost[i]] + 1);
			}
		}
		if(dp[K] == 100001)
			dp[K] = -1;
		System.out.println(dp[K]);
	}
}
