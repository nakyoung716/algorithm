package week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2512_예산 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		int S = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			S += arr[i];
		}
		int M = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int sum = 0;
		int answer = 0;
		if(M / N < arr[0]) {
			System.out.println(M / N);
			return;
		}
		for (int i = 0; i < N-1; i++) {
			if(sum + (N-i) * arr[i] <= M && sum + arr[i] + (N-i-1) * arr[i+1] > M) {
				sum += arr[i] * (N-i);
				for (int j = arr[i]; j < arr[i+1]; j++) {
					if(sum + (N-i-1) < M) {
						sum += N-i-1;
					}
					else {
						answer = j;
						break;
					}
				}
			}
			else if(sum + (N-i) * arr[i] > M)
				break;
			else
				sum += arr[i];
		}
		if(sum + arr[N-1] == S)
			System.out.println(arr[N-1]);
		else
			System.out.println(answer);
	}

}
