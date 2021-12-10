// 풀이시간 1시간
// 메모리 111756KB
// 시간 320 ms

import java.io.*;
import java.util.*;

public class Main_BOJ_2636_치즈 {
	static int N,M;
	static int map[][];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,-1,0,1};
	static int remain;
	static int time =0;
	static Queue<int[]> que = new LinkedList<>();
	static Queue<int[]> blank_que = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) remain +=1;
			}
		}
		
		initmap(0,0);

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == CHEESE) que.offer(new int[] {i,j});
				else if(map[i][j] == HOLE) blank_que.offer(new int[] {i,j});
			}
		}
		BFS(que,blank_que);
		System.out.println(time);
		System.out.println(remain);
		
	}
	// map[r][c] == a
	// a == 0 : 치즈 안에 갇혀있는 빈 공간
	// a == 1 : 치즈
	// a == -1 : 치즈에 갇혀있지 않은 빈 공간
	// a == 2 : 1시간 뒤에 사라질 치즈
	static final int HOLE = 0;
	static final int CHEESE = 1;
	static final int BLANK = 3;
	static final int MELT = 2;
	
	private static void BFS(Queue<int[]> que, Queue<int[]> blank_que) {

		Queue<int[]> next = new LinkedList<>();
		Queue<int[]> melt_que = new LinkedList<>();
		Queue<int[]> next_blank = new LinkedList<>();

		time +=1;
		while(!que.isEmpty()) {
			int cur[] = que.poll();
			int cnt = 0;
			for(int d=0; d<4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc <M) {
					if(map[nr][nc] == BLANK) cnt +=1;
				}
			}
			if(cnt >= 1) {
				map[cur[0]][cur[1]] = MELT;
				melt_que.offer(cur);
			}else next.offer(cur);
		}
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == MELT) cnt +=1;
			}
		}
		remain = cnt;
		
		while(!melt_que.isEmpty()) {
			int cur[] = melt_que.poll();
			map[cur[0]][cur[1]] = BLANK;
		}
		
		for(int[] cur : blank_que) {
			boolean flag = false;
			for(int i=0; i<4; i++) {
				int nr = cur[0]+dr[i];
				int nc = cur[1]+dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					if(map[nr][nc] == BLANK) {
						flag= true;
					}
				}
			}
			if(flag) {
				initmap(cur[0],cur[1]);
			}else {
				next_blank.offer(cur);
			}
		}
		if(!next.isEmpty()){
			BFS(next,next_blank);
		}
		
		
		
	}
	private static void initmap(int r, int c) {
		Queue<int[]> que = new LinkedList<>();
		boolean visited[][] = new boolean[N][M];
		que.offer(new int[] {r,c});
		while(!que.isEmpty()) {
			int cur[] = que.poll();
			map[cur[0]][cur[1]] = BLANK;
			for(int d=0; d<4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				if(nr>=0 && nr< N && nc>=0 && nc<M) {
					if(map[nr][nc] != CHEESE && map[nr][nc] != MELT && !visited[nr][nc]) {
						que.offer(new int[] {nr,nc});
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
}
