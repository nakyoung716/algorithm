package week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1038_감소하는_수 {

	static int c = 0;
	static long d[] = new long[10];
	static long arr[] = new long[500000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Arrays.fill(arr, -1);
		if(N >= 500000) {
			System.out.println("-1");
			return;
		}
		for (int j = 1; j <= 10; j++) {
			solve(0,j);
		}
		System.out.println(arr[N]);
	}
	private static void solve(int k, int l) {
		if(k == l) {
			long sum = 0;
			for (int i = 0; i < l; i++) {
				sum *= 10;
				sum += d[i];
			}
			arr[c++] = sum;
			return;
		}
		if(k == 0) {
			for (int i = l-k-1; i < 10; i++) {
				d[k] = i;
				solve(k+1,l);
			}
		}
		else {
			for (int i = l-k-1; i < d[k-1]; i++) {
				d[k] = i;
				solve(k+1,l);
			}
		}
	}

}
