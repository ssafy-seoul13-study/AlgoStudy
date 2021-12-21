import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 빙산
// 메모리 : 108140KB, 시간 : 620ms, 풀이시간 : 30분
public class BOJ_2573 {

	static int N, M;
	static int [][] map;
	static int [][] temp;
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	static boolean [][] visit;
	static int time;
	
	static class Info {
		int r;
		int c;
		
		public Info(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M]; 
		temp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = map[i][j];
			}
		}
		
		start();
		
		System.out.println(time);
	}

	private static void start() {
		while(true) {
			time++;
			
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(temp[i][j] != 0) {
						cnt++;
						int sea = 0;
						for (int d = 0; d < 4; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							if(nr>=0 && nr<N && nc>=0 && nc<M && temp[nr][nc] == 0) sea++;
						}
						
						map[i][j] -= sea;
						if(map[i][j] < 0) {
							map[i][j] = 0;
						}
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[i][j] = map[i][j];
				}
			}
	
			
			visit = new boolean[N][M];
			
			int ice = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] != 0 && !visit[i][j]) {
						bfs(i, j);
						ice++;
					}
				}
			}
			
			if(ice >= 2) break;
			if(cnt == 0) {
				time = 0;
				break;
			}
		}
		
	}

	private static void bfs(int i, int j) {
		Queue<Info> que = new LinkedList<>();
		que.add(new Info(i, j));
		visit[i][j] = true;
		
		while(!que.isEmpty()) {
			Info cur = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					if(map[nr][nc] != 0 && !visit[nr][nc]) {
						que.add(new Info(nr, nc));
						visit[nr][nc] = true;
					}
				}
 			}
		}
		
	}

}
