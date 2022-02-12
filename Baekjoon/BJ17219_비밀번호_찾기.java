package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ17219_비밀번호_찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, String> password = new HashMap<String, String>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			String site = st.nextToken();
			String pw = st.nextToken();
			password.put(site,  pw);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			System.out.println(password.get(st.nextToken()));
		}
	}

}
