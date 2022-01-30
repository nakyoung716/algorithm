package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1292_쉽게_푸는_문제 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int nums[] = new int[1000];
		int i = 0;
		int n = 1;
		boolean flag = true;
		while(flag) {
			for (int j = 0; j < n; j++) {
				if(i + j > 999) {
					flag = false;
					break;
				}
				nums[i+j] = n;
			}
			i += n;
			n++;
		}
		int sum = 0;
		for (int j = A-1; j <= B-1; j++) {
			sum += nums[j];
		}
		System.out.println(sum);
	}

}
