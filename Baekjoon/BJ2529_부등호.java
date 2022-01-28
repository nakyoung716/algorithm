package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2529_부등호 {
	
	static long max, min;
	static int N;
	static int op[];
	static boolean isSelected[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		op = new int[N];
		isSelected = new boolean[10];
		max = 0;
		min = Long.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String tmp = st.nextToken();
			if(tmp.equals("<"))
				op[i] = 1;
		}
		for (int i = 0; i < 10; i++) {
			isSelected[i] = true;
			solve(i, 0);
			isSelected[i] = false;
		}
		
		String tmp = Long.toString(max);
		int len = tmp.length();
		if(len != N+1) {
			for (int i = 0; i < N+1 - len; i++) {
				tmp = "0" + tmp;
			}
		}
		System.out.println(tmp);
		
		tmp = Long.toString(min);
		len = tmp.length();
		if(len != N+1) {
			for (int i = 0; i < N+1 - len; i++) {
				tmp = "0" + tmp;
			}
		}
		System.out.println(tmp);
	}
	
	private static void solve(long i, int j) {
		if(j == N) {
			if(i > max)
				max = i;
			if(i < min)
				min = i;
			return;
		}
		for (int k = 0; k <= 9; k++) {
			if(!isSelected[k] && ((op[j] == 1 && i % 10 < k) || op[j] == 0 && i % 10 > k)) {
				isSelected[k] = true;
				solve(i*10 + k, j+1);
				isSelected[k] = false;
			}
		}
	}
}
