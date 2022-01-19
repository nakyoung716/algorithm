package week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ1937_ÆÇ´Ù {

	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	static int max = 1, N;
	static int map[][];
	static int dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(dfs(i,j), max);
			}
		}
		
		System.out.println(max);
	}
	
	private static int dfs(int i, int j) {
		if(dp[i][j] != 0)
			return dp[i][j];
		dp[i][j] = 1;
		for (int d = 0; d < 4; d++) {
			if(i+dr[d] < 0 || i+dr[d] >= N || j+dc[d] < 0 || j+dc[d] >= N)
				continue;
			if(map[i][j] < map[i+dr[d]][j+dc[d]]) {
				dp[i][j] = Math.max(dp[i][j], dfs(i+dr[d],j+dc[d])+1);
			}
		}
		return dp[i][j];
	}

}
