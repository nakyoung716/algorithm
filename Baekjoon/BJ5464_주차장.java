package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ5464_ÁÖÂ÷Àå {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cost[] = new int[N];
		int parking[] = new int[N];
		int weight[] = new int[M];
		Queue<Integer> wait = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			weight[i] = Integer.parseInt(br.readLine());
		}
		int answer = 0;
		int park_num = 0;
		for (int i = 0; i < 2 * M; i++) {
			int cur = Integer.parseInt(br.readLine());
			if(cur > 0) {
				if(park_num != N) {
					park_num++;
					for (int j = 0; j < N; j++) {
						if(parking[j] == 0) {
							parking[j] = cur;
							break;
						}
					}
				}
				else
					wait.add(cur);
			}
			else {
				cur *= -1;
				park_num--;
				for (int j = 0; j < N; j++) {
					if(parking[j] == cur) {
						if(!wait.isEmpty()) {
							parking[j] = wait.poll();
							park_num++;
						}
						else
							parking[j] = 0;
						answer += cost[j] * weight[cur-1];
						break;
					}
				}
			}
		}
		System.out.println(answer);
	}

}
