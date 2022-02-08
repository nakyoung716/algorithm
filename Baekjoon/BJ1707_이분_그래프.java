package week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1707_이분_그래프 {

	static int v, e;
	static ArrayList<Integer>[] list;
	static int visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			visit = new int[v+1];
			list = new ArrayList[v+1];
			
			for (int i = 0; i <= v; i++)
				list[i] = new ArrayList<Integer>();
			
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				
				list[v1].add(v2);
				list[v2].add(v1);
			}
			grouping();
		}
	}
	
	private static void grouping() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 1; i <= v; i++) {
			if(visit[i] == 0) {
				q.add(i);
				visit[i] = 1;
			}
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				for (int j = 0; j < list[cur].size(); j++) {
					if(visit[list[cur].get(j)] == 0)
						q.add(list[cur].get(j));
					
					if(visit[list[cur].get(j)] == visit[cur]) {
						System.out.println("NO");
						return;
					}
					
					if(visit[cur] == 1 && visit[list[cur].get(j)] == 0)
						visit[list[cur].get(j)] = 2;
					else if(visit[cur] == 2 && visit[list[cur].get(j)] == 0)
						visit[list[cur].get(j)] = 1;
				}
			}
		}
		
		System.out.println("YES");
	}

}
