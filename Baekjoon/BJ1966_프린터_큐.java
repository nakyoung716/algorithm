package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1966_프린터_큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Queue<int[]> queue = new LinkedList<int[]>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				queue.add(new int[] {i, Integer.parseInt(st.nextToken())});
			}
			int c = 0;
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				boolean flag = true;
				for(int[]q : queue) {
					if(q[1] > cur[1])
						flag = false;
				}
				if(flag) {
					c++;
					if(cur[0] == M)
						break;
				}
				else
					queue.add(cur);
			}
			System.out.println(c);
		}
	}

}
