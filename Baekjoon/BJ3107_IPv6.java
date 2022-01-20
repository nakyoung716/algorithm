package week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ3107_IPv6 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ch = br.readLine().toCharArray();
		int l = ch.length;
		int c = 0;
		for (int i = 0; i < l; i++) {
			if(ch[i] == ':')
				c++;
		}
		
		String answer = "";
		String tmp = "";
		
		for (int i = 0; i < l; i++) {
			if(ch[i] == ':') {
				if(i > 0 && ch[i-1] == ':') {
					for (int j = 0; j < 8-c; j++) {
						answer += "0000:";
					}
				}
				else {
					int tmp_l = tmp.length();
					for (int j = 0; j < 4-tmp_l; j++) {
						answer += '0';
					}
					tmp += ':';
					answer += tmp;
					tmp = "";
				}
				if(i == l-1)
					answer += "0000";
			}
			else {
				tmp += ch[i];
				if(i == l-1) {
					int tmp_l = tmp.length();
					for (int j = 0; j < 4-tmp_l; j++) {
						answer += '0';
					}
					answer += tmp;
				}
			}
		}
		
		System.out.println(answer);
	}

}
