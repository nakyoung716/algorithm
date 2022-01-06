package week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10830_Çà·Ä_Á¦°ö {

	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		int arr[][] = new int [N][N];
		int ans[][] = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			ans[i][i] = 1;
		}
		
		while(B > 1) {
			if(B % 2 == 1)
				ans = multiply(ans,arr);
			arr = multiply(arr,arr);
			B /= 2;
		}
		
		if(B % 2 == 1)
			ans = multiply(ans,arr);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] multiply(int[][] arr, int[][] arr2) {
		int[][] ret = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					ret[i][j] += arr[i][k] * arr2[k][j];
					ret[i][j] %= 1000;
				}
			}
		}
		return ret;
	}

}
