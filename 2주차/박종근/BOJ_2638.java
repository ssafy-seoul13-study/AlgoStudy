package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈_2638 {
	static int R, C, T, CheeseCount;
	static int[][] Map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<Loc> CheeseList = new LinkedList<Loc>();

	static class Loc {
		int r;
		int c;
		int d;

		public Loc(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		// 1. 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = 0;
		CheeseCount = 0;
		Map = new int[R][C];

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				Map[r][c] = Integer.parseInt(st.nextToken());
				if (Map[r][c] == 1)
					CheeseCount++;
			}
		}

		// 치즈가 전부 없어지면 끝
		while (CheeseCount > 0) {
			// 시간 증가
			T++;
//			System.out.println("초:" + T);
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					// 공기와 접촉한 빈칸이라면
					if (Map[r][c] == 0 && isContactAir(r, c)) {
//						System.out.println("공기 R:"+r+" C:"+c);
						// 사방에 치즈가 있으면 ++
						for (int i = 0; i < 4; i++) {
							int nr = r + dr[i];
							int nc = c + dc[i];
							
							// 맵을 넘으면 패스
							if (nr < 0 || nr == R || nc < 0 || nc == C)
								continue;
							
							// 주위에 치즈가 있다면
							if (Map[nr][nc] != 0) {
								// 증가
								Map[nr][nc]++;
								CheeseList.add(new Loc(nr,nc,Map[nr][nc]));
//								System.out.println("치즈리스트 추가 R:"+nr+" C:"+nc+" D:"+Map[nr][nc]);
							}
						}
					}

				}
			}
			
			// 한번 다 확인 하고
			// 치즈 녹이기
			while (!CheeseList.isEmpty()) {
				Loc cheese = CheeseList.poll();
				// 녹는거 
				if(cheese.d >= 3) {
					if(Map[cheese.r][cheese.c] == 0) continue;
					Map[cheese.r][cheese.c] = 0;
					CheeseCount--;
				}
				// 안녹는거
				else {
					if(Map[cheese.r][cheese.c] == 1) continue;
					Map[cheese.r][cheese.c] = 1;
				}
			}
//			printMap();
		}

		System.out.println(T);

	}

	private static boolean isContactAir(int r, int c) {
		for (int i = 0; i < 4; i++) {
			// 한방향 끝까지 계속 가면서 탐색
			// 하나라도 맵 끝으로 갔으면 성공 공기임
			if (go(r, c, i))
				return true;
		}
		return false;
	}

	private static boolean go(int r, int c, int d) {

		for (int i = 1; i < 100; i++) {
			int nr = r + dr[d] * i;
			int nc = c + dc[d] * i;
			// 맵을 넘으면 끝
			if (nr < 0 || nr == R || nc < 0 || nc == C)
				return true;

			// 치즈로 막혀 있으면
			if (Map[nr][nc] != 0)
				return false;
		}
		return false;

	}

	private static void printMap() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.printf("%2d", Map[r][c]);
			}
			System.out.println();
		}

	}

}
