package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ1339_단어_수학 {

	private static int N, max = 0, count = 0;
	private static String word[];
	private static boolean selected[] = new boolean[10];
	private static char c[] = new char[10];
	static HashMap<Character, Integer> alpha = new HashMap<Character, Integer>(); 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		word = new String[N];
		for (int i = 0; i < N; i++) {
			word[i] = in.readLine();
			char ch[] = word[i].toCharArray();
			for (int j = 0; j < ch.length; j++) {
				boolean flag = false;
				for (int k = 0; k < 10; k++) {
					if(c[k] == ch[j])
						flag = true;
				}
				if(!flag)
					c[count++] = ch[j];
			}
		}
		factorial(0);
		System.out.println(max);
	}
	private static void factorial(int i) {
		if(i >= count) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				int num = 0;
				char ch[] = word[j].toCharArray();
				for (int k = 0; k < ch.length; k++) {
					num = num * 10 + alpha.get(ch[k]);
				}
				sum += num;
			}
			if(sum > max)
				max = sum;
			return;
		}
		for (int j = 0; j < 10; j++) {
			if(!selected[j]) {
				selected[j] = true;
				alpha.put(c[i], j);
				factorial(i+1);
				selected[j] = false;
			}
		}
	}

}
