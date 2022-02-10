package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15961_회전_초밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int plate[] = new int[N];
		int type[] = new int[d + 1];
		int max = 0;
		for (int i = 0; i < N; i++) {
			plate[i] = Integer.parseInt(in.readLine());
		}
		for (int i = 0; i < k; i++) {
			type[plate[i]]++;
		}
		for (int i = 0; i <= d; i++) {
			if(type[i] > 0)
				max++;
		}
		int before = max;
		for (int i = 0; i < N; i++) {
			int cur = before;
			type[plate[i]]--;
			if(type[plate[i]] == 0)
				cur--;
			type[plate[(i + k) % N]]++;
			if(type[plate[(i + k) % N]] == 1)
				cur++;
			if(type[c] == 0 && cur >= max)
				max = cur + 1;
			else if(cur >= max)
				max = cur;
			before = cur;
		}
		
		System.out.println(max);
	}

}
