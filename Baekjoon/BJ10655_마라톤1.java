package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10655_∏∂∂Û≈Ê1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int pos[][] = new int[n][2];
		int dist;
		int max = 0;
		int max_i = 0;
		int D = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pos[i][0] = Integer.parseInt(st.nextToken());
			pos[i][1] = Integer.parseInt(st.nextToken());
			if(i>0) {
				D += Math.abs(pos[i][0] - pos[i-1][0]) + Math.abs(pos[i][1] - pos[i-1][1]);
			}
		}
		for (int i = 0; i < n-2; i++) {
			dist = - Math.abs(pos[i+2][0] - pos[i][0]) - Math.abs(pos[i+2][1] - pos[i][1])
					+ Math.abs(pos[i+2][0] - pos[i+1][0]) + Math.abs(pos[i+2][1] - pos[i+1][1])
					  + Math.abs(pos[i+1][0] - pos[i][0]) + Math.abs(pos[i+1][1] - pos[i][1]);
			if(dist > max) {
				max = dist;
			}
		}
		System.out.println(D - max);
	}

}
