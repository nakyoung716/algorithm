package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1063_킹 {

	static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		char ch[] = new char[2];
		int p[][] = new int[2][2];
		for (int i = 0; i < 2; i++) {			
			ch = st.nextToken().toCharArray();
			p[i][1] = ch[0] - 'A';
			p[i][0] = '8' - ch[1];
		}
		int N = Integer.parseInt(st.nextToken());
		int d = 0;
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			if(str.equals("RT")) {
				d = 1;
			}
			else if(str.equals("R")) {
				d = 2;
			}
			else if(str.equals("RB")) {
				d = 3;
			}
			else if(str.equals("B")) {
				d = 4;
			}
			else if(str.equals("LB")) {
				d = 5;
			}
			else if(str.equals("L")) {
				d = 6;
			}
			else if(str.equals("LT")) {
				d = 7;
			}
			else {
				d = 0;
			}
			
			if(p[0][0] + dx[d] == p[1][0] && p[0][1] + dy[d] == p[1][1]) {
				if(p[1][0] + dx[d] < 0 || p[1][0] + dx[d] > 7 || p[1][1] + dy[d] < 0 || p[1][1] + dy[d] > 7) {
					continue;
				}
				else {
					p[0][0] += dx[d];
					p[0][1] += dy[d];
					p[1][0] += dx[d];
					p[1][1] += dy[d];
				}
			}
			else if(p[0][0] + dx[d] < 0 || p[0][0] + dx[d] > 7 || p[0][1] + dy[d] < 0 || p[0][1] + dy[d] > 7) {
				continue;
			}
			else {
				p[0][0] += dx[d];
				p[0][1] += dy[d];
			}
		}
		String p1 = "";
		p1 += (char)(p[0][1] + 'A');
		p1 += 8 - p[0][0];
		System.out.println(p1);
		String p2 = "";
		p2 += (char)(p[1][1] + 'A');
		p2 += 8 - p[1][0];
		System.out.println(p2);
	}

}
