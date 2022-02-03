package week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1451_직사각형으로_나누기 {

	static long sum[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long arr[][] = new long[N][M];
		sum = new long[N+1][M+1];
		long max = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			char[] ch = str.toCharArray();
			for (int j = 0; j < M; j++) {
				arr[i][j] = (int)ch[j] - '0';
			}
		}
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < M+1; j++) {
				sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + arr[i-1][j-1];
			}
		}
		long r1, r2, r3;
		for (int i = 1; i < M-1; i++) {
			for (int j = i+1; j < M; j++) {
				r1 = sum(1,1,N,i);
				r2 = sum(1,i+1,N,j);
				r3 = sum(1,j+1,N,M);
				max = Math.max(max, r1 * r2 * r3);
			}
		}
		for (int i = 1; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				r1 = sum(1,1,i,M);
				r2 = sum(i+1,1,j,M);
				r3 = sum(j+1,1,N,M);
				max = Math.max(max, r1 * r2 * r3);
			}
		}
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				r1 = sum(1,1,N,j);
				r2 = sum(1,j+1,i,M);
				r3 = sum(i+1,j+1,N,M);
				max = Math.max(max, r1 * r2 * r3);
				
				r1 = sum(1,1,i,j);
				r2 = sum(i+1,1,N,j);
				r3 = sum(1,j+1,N,M);
				max = Math.max(max, r1 * r2 * r3);
				
				r1 = sum(1,1,i,M);
				r2 = sum(i+1,1,N,j);
				r3 = sum(i+1,j+1,N,M);
				max = Math.max(max, r1 * r2 * r3);
				
				r1 = sum(1,1,i,j);
				r2 = sum(1,j+1,i,M);
				r3 = sum(i+1,1,N,M);
				max = Math.max(max, r1 * r2 * r3);
				
			}
		}
		System.out.println(max);
	}

	private static long sum(int i1, int j1, int i2, int j2) {
		return sum[i2][j2] - sum [i2][j1-1] - sum [i1-1][j2] + sum[i1-1][j1-1];
	}

}
