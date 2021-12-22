import java.io.*;
import java.util.*;


public class BOJ_2573 {
	static int map[][];
	static int N,M, time;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int tmp = 0;
		while((tmp = findIsland()) < 2) {
			if(tmp == 0) {
				time = 0;
				break;
			}
			int visited[][] = new int[N][M];
			Queue<int[]> que = new LinkedList<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] != 0) {
						que.offer(new int[] {i,j});
						for(int d=0; d<4; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							if(nr>=0 && nr<N && nc >= 0 && nc < M && map[nr][nc] == 0) {
								visited[i][j] +=1;
							}
						}
					}
				}
			}
			
			for(Iterator<int[]> it = que.iterator(); it.hasNext();) {
				int cur[] = it.next();
				map[cur[0]][cur[1]] -= visited[cur[0]][cur[1]];
				if((map[cur[0]][cur[1]] = map[cur[0]][cur[1]] <= 0 ? 0 : map[cur[0]][cur[1]] ) == 0) it.remove();
			}
			
			time +=1;
		}
		
		
		
		System.out.println(time);
		
		
	}
	private static int findIsland(){
		int cnt =0;
		boolean visited[][] = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					visited[i][j] = true;
					dfs(i,j,visited);
					cnt +=1;
				}
			}
		}
		
		return cnt;
		// TODO Auto-generated method stub
		
	}
	private static void dfs(int r, int c, boolean[][] visited) {
		for(int i=0; i<4; i++) {
			int nr = r+ dr[i];
			int nc = c+ dc[i];
			if(nr>= 0&& nr<N && nc >= 0&& nc < M && map[nr][nc] != 0 && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr,nc,visited);
			}
		}
		
	}
}
