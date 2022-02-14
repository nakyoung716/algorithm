package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ21608_상어초등학교 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int like[][] = new int [N*N][5];
		int map[][] = new int[N][N];
		int di[] = {-1, 0, 1, 0};
		int dj[] = {0, 1, 0, -1};
		int sum = 0;
		for (int i = 0; i < N * N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				like[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int k = 0; k < N * N; k++) {
			int n = like[k][0];
			int max = -1;
			int empty = 0;
			int tmp_i = 0, tmp_j = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 0) {
						int count = 0;
						int empty_c = 0;
						for (int d = 0; d < 4; d++) {
							int ni = i + di[d];
							int nj = j + dj[d];
							if(ni < 0 || ni >= N || nj < 0 || nj >= N)
								continue;
							if(map[ni][nj] == 0)
								empty_c++;
							for (int l = 1; l < 5; l++) {
								if(like[k][l] == map[ni][nj]) {
									count++;
								break;
								}
							}
						}
						if(count > max) {
							max = count;
							tmp_i = i;
							tmp_j = j;
							empty = empty_c;
						}
						else if(count == max) {
							if(empty < empty_c) {
								tmp_i = i;
								tmp_j = j;
								empty = empty_c;
							}
						}
					}
				}
			}
			map[tmp_i][tmp_j] = like[k][0];
		}
		for (int k = 0; k < N * N; k++) {			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(like[k][0] == map[i][j]) {
						int count = 0;
						for (int d = 0; d < 4; d++) {
							int ni = i + di[d];
							int nj = j + dj[d];
							if (ni < 0 || ni >= N || nj < 0 || nj >= N)
								continue;
							for (int l = 1; l < 5; l++) {
								if (like[k][l] == map[ni][nj]) {
									count++;
									break;
								}
							}
						}
						sum += Math.pow(10, count) / 10;
					}
				}
			}
		}
		System.out.println(sum);
	}
}
