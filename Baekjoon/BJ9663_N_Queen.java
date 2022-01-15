package week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9663_N_Queen {

	static int arr[], count = 0, N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		queen(0);
		System.out.println(count);
	}
	
	private static void queen(int i) {
		if(i == N) {
			count++;
			return;
		}
		for (int j = 0; j < N; j++) {
			arr[i] = j;
			if(pos(i))
				queen(i+1);
		}
	}

	private static boolean pos(int i) {
		for (int k = 0; k < i; k++) {
			if(arr[k] == arr[i])
				return false;
		}
		for (int k = 0; k < i; k++) {
			if(Math.abs(i-k) == Math.abs(arr[i] - arr[k]))
				return false;
		}
		return true;
	}

}
