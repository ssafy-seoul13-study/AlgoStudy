import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 260ms
// 메모리 : 44880KB
// 풀이 시간 : 26
public class BOJ_2638 {

	static int N;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		N = 0;
		int[][] cheese = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken()); 
                if(cheese[i][j]==1) N++;
			}
		}
		int time = 0;
		while(N!=0) {
			melting(cheese);
			time++;
		}
		System.out.println(time);
	}

	private static void melting(int[][] cheese) {

        int[] dr = {-1,0,1,0};
	    int[] dc = {0,-1,0,1};
        int R = cheese.length;
        int C = cheese[0].length;
		int[][] temp = new int[R][C];
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {0,0});
        temp[0][0] = -1;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(nr<0 || nc<0 || nr>=R || nc>=C || temp[nr][nc]==-1) continue;
				if(cheese[nr][nc]==0) {
                    temp[nr][nc] = -1;
                    que.offer(new int[] {nr, nc});
				}
				if(cheese[nr][nc]==1) {
					temp[nr][nc]++;
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(temp[i][j]>=2) {
					cheese[i][j] = 0;
                    N--;
				}
			}
		}
	}


}
