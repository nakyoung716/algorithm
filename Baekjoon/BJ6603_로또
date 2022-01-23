package week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ6603_로또 {

	static int k, arr[];
	static boolean sel[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			arr = new int[k];
			sel = new boolean[k];
			if(k == 0)
				return;
			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			pick(0,0);
			System.out.println();
		}
	}
	
	private static void pick(int s, int i) {
		if(i == 6) {
			for (int j = 0; j < k; j++) {
				if(sel[j])
					System.out.print(arr[j]+" ");
			}
			System.out.println();
			return;
		}
		for (int j = s; j < k; j++) {
			if(!sel[j]) {
				sel[j] = true;
				pick(j, i+1);
				sel[j] = false;
			}
		}
	}

}
