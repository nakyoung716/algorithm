package week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1052_¹°º´ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String b = Integer.toBinaryString(N);
		char[] ch = b.toCharArray();
		String s = "";
		for (int i = 0; i < ch.length; i++) {
			if(K <= 0) {
				s += '1' - ch[i];
			}
			if(ch[i] == '1') 
				K--;
		}
		if(s.equals("") || K == 0)
			System.out.println("0");
		else
			System.out.println(Integer.parseInt(s,2)+1);
	}

}
