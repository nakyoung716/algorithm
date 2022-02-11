package week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class BJ1744_수_묶기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int sum = 0;
		int M = 0;
		int P = 0;
		int Z = 0;
		for (int i = 0; i < N; i++) {
			if(arr[i] < 0)
				M++;
			else if(arr[i] > 0)
				P++;
			else
				Z++;
		}
		
		for (int i = 0; i < M; i+=2) {
			if(i+1 < M)
				sum += arr[i] * arr[i+1];
		}
		
		for (int i = N-1; i > N - 1 - P; i-=2) {
			if(i > N-P) {
				if(arr[i-1] == 1)
					sum += arr[i] + arr[i-1];
				else
					sum += arr[i] * arr[i-1];
			}
		}
		if(M % 2 == 1) {
			if(Z == 0)
				sum += arr[M-1];
		}
		if(P % 2 == 1) {
			sum += arr[N-P];
		}
		System.out.println(sum);
	}

}
