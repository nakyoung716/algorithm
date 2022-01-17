package week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ23560_¾à {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 2;
		for (int i = 0; i < N-1; i++) {
			answer *= 3;
		}
		System.out.println(answer);
	}

}
