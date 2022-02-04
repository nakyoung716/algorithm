package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BJ2023_신기한_소수 {

	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		solve(0,0);
	}
	
	private static void solve(int n, int d) {
		if(d == N) {
			System.out.println(n);
			return;
		}
		for (int i = 0; i < 10; i++) {
			if(isPrime(n * 10 + i))
				solve(n * 10 + i, d+1);
		}
	}

	private static boolean isPrime(int n) {
		int s = (int) Math.sqrt(n);
		if(n == 1 || n == 0)
			return false;
		for (int i = 2; i <= s; i++) {
			if(n % i == 0)
				return false;
		}
		return true;
	}
}
