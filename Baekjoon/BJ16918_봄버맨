package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16918_봄버맨 {

	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static int R, C, N;
	static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()) - 1;
		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			char temp[] = in.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				if(temp[c]!='.')
					map[r][c]++;
			}
		}
		int sec = 0;
		while(sec != N) {
			sec++;
			count();
			printc();
			if(sec==N)
				break;
			sec++;
			count();
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(map[r][c]>=3) {
						map[r][c]=0;
						for (int d = 0; d < 4; d++) {
							int nr = r +dr[d];
							int nc = c +dc[d];
							if(nr>=0 && nr<R && nc>=0 && nc<C && map[nr][nc]<=2)
								map[nr][nc]=0;
						}
					}
				}
			}
			printc();
		}
		print();
	}

	private static void printc() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void count() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				map[r][c]++;
			}
		}
	}

	private static void print() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c]==0)
					System.out.print('.');
				else
					System.out.print('O');
			}
			System.out.println();
		}		
	}
}
