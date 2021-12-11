import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 248ms
// 메모리 : 44644KB
// 풀이 시간 : 30분
public class BOJ_2638 {

	static int N;
	public static void main(String[] args) throws IOException {

		// 입력받기
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
                		// 치즈 크기 카운트
				if(cheese[i][j]==1) N++;
			}
		} 
		// 다 녹을 때까지 걸리는 시간
		int time = 0;
		// 치즈 크기가 0이 될 때까지
		while(N!=0) {
			// 치즈 녹이고 시간++
			melting(cheese);
			time++;
		}
		System.out.println(time);
	}

	// 치즈 녹이는 함수
	private static void melting(int[][] cheese) {

		// 필요한 변수들 정의
        	int[] dr = {-1,0,1,0};
	    	int[] dc = {0,-1,0,1};
		int R = cheese.length;
		int C = cheese[0].length;

		// 몇 면이 닿아있는지 셀 임시 배열
		int[][] temp = new int[R][C];
		// 치즈가 없는 0인 부분을 bfs
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {0,0});
		// 치즈가 없고 방문한 부분은 temp에 -1로 저장
		temp[0][0] = -1;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				// 범위 밖이거나 방문한 곳인 경우
				if(nr<0 || nc<0 || nr>=R || nc>=C || temp[nr][nc]==-1) continue;
				// 방문한 적 없고 치즈가 없는 부분일 경우
				if(cheese[nr][nc]==0) {
					// temp에 -1 저장해서 방문 표시하고 que에 넣기
		    			temp[nr][nc] = -1;
		   			 que.offer(new int[] {nr, nc});
				}
				// 치즈가 있는 곳이면 temp에 닿아있는 면+1
				else {
					temp[nr][nc]++;
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 치즈가 바깥과 닿은 부분이 2 이상인 경우 녹음 => 치즈 크기-1
				if(temp[i][j]>=2) {
					cheese[i][j] = 0;
		    			N--;
				}
			}
		}
	}


}
