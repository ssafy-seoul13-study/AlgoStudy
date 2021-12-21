package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


// 시간 : 528ms
// 메모리 : 195304KB
// 풀이시간 : 75분
public class BOJ_2573 {

	// 가장 최근에 빙산이 몇 덩이었는지 기억할 변수
	static int list;
	public static void main(String[] args) throws IOException {

		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 빙산 배열 입력
		int[][] ice = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 시간, list 초기화
		int time = 0;
		list = 0;
		while(true) {
			if(melting(ice)) break;
			time++;
		}
//		list.sort(null);
		// 마지막까지 빙산이 2개 이상이 아니었다면 time = 0으로 초기화
		if(list<2) time = 0; 
		System.out.println(time);
	}

	private static boolean melting(int[][] ice) {

		// 필요한 변수 선언
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		int N = ice.length;
		int M = ice[0].length;
		Queue<int[]> que = new LinkedList<>();
		// 빙산이 녹는 양 저장할 임시 배열
		int[][] temp = new int[N][M];
		// 방문 확인 배열
		boolean[][] v = new boolean[N][M];
		// 빙산이 몇 개인지 카운트
		int count = 0;
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < M-1; j++) {
				// 방문한 적 없는 빙산이라면
				if(ice[i][j]>0 && !v[i][j]) {
					// 빙산 카운트 ++
					count++;
					// 방문 확인
					v[i][j] = true;
					// bfs로 빙산 확인
					que.offer(new int[] {i,j});
					while(!que.isEmpty()) {
						int[] cur = que.poll();
						int r = cur[0], c = cur[1];
						for (int d = 0; d < 4; d++) {
							int nr = r+dr[d];
							int nc = c+dc[d];
							if(nr>=N || nc>=M || nr<0 || nc<0 || v[nr][nc]) continue;
							// 빙산 근처 4방 탐색 시 바다라면 temp에 ++
							if(ice[nr][nc]==0) temp[r][c]++;
							// 빙산이라면 방문 확인 -> que에 넣기
							else if(ice[nr][nc]>0) {
								que.offer(new int[] {nr,nc});
								v[nr][nc] = true;
							}
 						}
					}
					
				}
			}
		}
		// 빙산 주위에 바다가 몇 면인지 저장한 temp랑 연산 (만일 음수가 된다면 0으로 저장)
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < M-1; j++) {
				ice[i][j] = Math.max(ice[i][j]-temp[i][j], 0);
			}
		}
		// 빙산이 몇 개였는지 저장
		list = count;
		// 빙산이 더이상 없거나 2덩이 이상인 경우 true 리턴
		if(count!=1) return true;
		// 빙산이 하나인 경우 false리턴
		return false;
	}

}
