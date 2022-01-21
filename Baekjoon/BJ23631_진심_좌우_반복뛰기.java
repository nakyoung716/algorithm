package week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ23631_Áø½É_ÁÂ¿ì_¹Ýº¹¶Ù±â {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = (int)Math.sqrt(N / K * 2)+1;
			int i = (start + end) / 2;
			int answer = 0;
			while (end - start >= 0) {
				if(K * i * (i + 1) / 2 < N && N <= K * (i + 1) * (i + 2) / 2) {
					break;
				}
				else if(K * i * (i + 1) / 2 > N) {
					end = i - 1;
				}
				else if(N > K * (i + 1) * (i + 2) / 2) {
					start = i + 1;
				}
				i = (start + end) / 2;
			}
			if(i % 2 == 0) {
				answer = (i / 2) * -K + (N - K * i * (i + 1) / 2) - 1;
				System.out.println(answer + " R");
			}
			else {
				answer = (i / 2 + 1) * K - (N - K * i * (i + 1) / 2) + 1;
				System.out.println(answer + " L");
			}
		}
	}

}
