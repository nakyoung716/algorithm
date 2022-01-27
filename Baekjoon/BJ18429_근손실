package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18429_근손실 {

	static int N, K, count;
	static int arr[], temp[];
	static boolean check[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		count = 0;
		arr = new int[N];
		temp = new int[N];
		check = new boolean[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		exercise(0);
		System.out.println(count);
	}
	private static void exercise(int i) {
		if(i == N) {
			int weight = 500;
			for (int j = 0; j < N; j++) {
				weight += temp[j];
				weight -= K;
				if(weight < 500)
					return;
			}
			count++;
			return;
		}
		for (int k = 0; k < N; k++) {
			if(!check[k]) {
				check[k] = true;
				temp[i] = arr[k]; 
				exercise(i+1);
				check[k] = false;
			}
		}
	}

}
