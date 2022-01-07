package week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ3184_양 {

	static int R, C, sheep, wolf;
	static char[][] map;
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		sheep = 0;
		wolf = 0;
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == '#')
					visited[i][j] = true;
				if(!visited[i][j]) {
					solve(i,j);
				}
			}
		}
		System.out.println(sheep + " " + wolf);
	}
	
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	private static void solve(int i, int j) {
		Queue<pos> queue = new LinkedList<pos>();
		queue.add(new pos(i,j));
		int w = 0;
		int s = 0;
		visited[i][j]= true;
		while(!queue.isEmpty()) {
			pos p = queue.poll();
			if(map[p.r][p.c] == 'o')
				s++;
			else if(map[p.r][p.c] == 'v')
				w++;
			for (int d = 0; d < 4; d++) {
				if(p.r+dr[d] >= R || p.r+dr[d] < 0 || p.c+dc[d] >= C || p.c+dc[d]<0 || visited[p.r+dr[d]][p.c+dc[d]] || map[p.r+dr[d]][p.c+dc[d]] == '#')
					continue;
				queue.add(new pos(p.r+dr[d], p.c+dc[d]));
				visited[p.r+dr[d]][p.c+dc[d]] = true;
			}
		}
		if(w >= s)
			wolf += w;
		else
			sheep += s;
	}

	static class pos{
		private int r, c;
		public pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
