package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 메모리: 134468KB	
 * 시간: 492ms
 * 소요시간: 61분 
 */
public class 빙산_2573 {

	static int R, C, Ice, Answer, StuckIce;
	static int[][] Map;
	static boolean[][] isVisited;
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Map = new int[R][C];
		Ice = 0;
		Answer = 0;

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				Map[r][c] = Integer.parseInt(st.nextToken());
				if (Map[r][c] != 0)
					Ice++;
			}
		}

		while (true) {
			// 빙산이 다 녹았다
			if (Ice == 0) {
				Answer = 0;
				break;
			}

			// 답 증가
			Answer++;

			// 녹이기
			melting();
			
			// 덩어리 확인
			if (isDevide())
				break;
		}

		System.out.println(Answer);
	}

	private static boolean isDevide() {
		StuckIce = 1;
		isVisited = new boolean[R][C];

		loop: for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (Map[r][c] > 0) {
					// bfs시작
					isVisited[r][c] = true;
					bfs(r, c);
					break loop;
				}
			}
		}

		if (StuckIce < Ice) return true;
		return false;
	}

	private static void bfs(int r, int c) {
		// 사방탐색
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			// 맵을 안나가고 공기가 아니고 방문한 적이 없다면
			if (check(nr, nc) && Map[nr][nc] != 0 && !isVisited[nr][nc]) {
				isVisited[nr][nc] = true;
				StuckIce++;
				bfs(nr, nc);
			}
		}
	}

	private static void melting() {
		int[][] AirMap = new int[R][C];

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// 빙산이면
				if (Map[r][c] != 0) {
					// 사방탐색
					int air = 0;
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];

						// 맵밖을 나갔거나 빙산이면 아님
						if (!check(nr, nc) || Map[nr][nc] != 0)
							continue;
						air++;
					}
					AirMap[r][c] = air;
				}
			}
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (AirMap[r][c] < 1)
					continue;
				Map[r][c] -= AirMap[r][c];
				if (Map[r][c] < 1) {
					Map[r][c] = 0;
					Ice--;
				}
			}
		}

	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}

}
