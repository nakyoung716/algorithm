package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16967_배열_복원하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int A[][] = new int[H][W];
		int B[][] = new int[H+X][W+Y];
		for (int i = 0; i < H+X; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < W+Y; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
				if(i<H && j<W) {
					A[i][j] = B[i][j];
					if(i>=X && j>=Y)
						A[i][j] = B[i][j] - A[i-X][j-Y];
				}
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}

}
