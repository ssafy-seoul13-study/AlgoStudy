package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 15% 정도에서 틀렸습니다 뜸...
 */
public class 봄버맨_16918 {

	static int R, C, T;
	static char[][] OriginMap;
	
	static StringBuilder Answer;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Answer = new StringBuilder();

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		OriginMap = new char[R][C];
		
		for (int r = 0; r < R; r++) {
			String line = br.readLine();
			for (int c = 0; c < C; c++) {
				OriginMap[r][c] = line.charAt(c);
			}
		}

		if(T == 1) print(OriginMap);
		
		else {
			if(T % 2 == 0) {
				// 다 폭탄
				AllBomb();
			}
			
			else if (T % 4 == 1) {
				// 초기맵 리턴
				print(OriginMap);
			}
			
			else {
				// 한번 터지고 난후 리턴
				OnceEexplosion();
				print(OriginMap);
			}
		}
	}

	private static void OnceEexplosion() {
		boolean[][] checked = new boolean[R][C];
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (OriginMap[r][c] == 'O') {
					OriginMap[r][c] = 'O';
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if (!check(nr, nc) || checked[nr][nc] || OriginMap[nr][nc]=='O')
							continue;
						OriginMap[nr][nc] = 'X';
						checked[nr][nc] = true;
					}
				}
			}
		}
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				OriginMap[r][c] = OriginMap[r][c] == '.' ? 'O' : '.';
			}
		}		
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}

	private static void AllBomb() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				Answer.append('O');
			}
			Answer.append("\n");
		}
		System.out.print(Answer);
	}

	private static void print(char[][] Map) {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				Answer.append(Map[r][c]);
			}
			Answer.append("\n");
		}
		System.out.print(Answer);
	}
}