package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퍼즐_1525 {
	static int[][] AnswerMap, Map;

	static int Answer, ZeroR, ZeroC;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Answer = -1;
		Map = new int[3][3];
		AnswerMap = new int[3][3];
		ZeroR = 2;
		ZeroC = 2;
		
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				AnswerMap[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int answer = (i * 3) + (j + 1) < 9 ? (i * 3) + (j + 1) : 0;
				Map[i][j] = answer;
			}
		}

		dfs(0, -1);

		System.out.println(Answer);

	}

	private static void dfs(int change, int beforeDirect) {
		// 같으면 끝
		if (isSame()) {
			Answer = change;
			return;
		}

		// 모든경우의 수를 다 돌았는데도 안됐을 경우
		if (Map[0][0] == 0) {
			System.out.println("0종료");
			return;
		}

		// 0 기준으로 사방을 탐색 갈수있으면 간다
		for (int i = 0; i < 4; i++) {
			int nr = ZeroR + dr[i];
			int nc = ZeroC + dc[i];
//			System.out.println("NR:"+nr + " NC:"+nc);
//			System.out.println("나갔니? "+ checkOut(nr, nc));
			// 나가지 않고 전 방향이 아니고 한바퀴를 돌은게 아니라면
			if (checkOut(nr, nc) && checkBack(i, beforeDirect) &&checkCircle()) {
				Map[ZeroR][ZeroC] = Map[nr][nc];
				Map[nr][nc] = 0;
				ZeroR = nr;
				ZeroC = nc;
				printMap();
				dfs(change+1, i);
			}
		}

	}

	private static boolean checkCircle() {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean checkBack(int now, int before) {
		if (before == -1)
			return true;
		// 상
		else if (before == 0) {
			if(now == 1) return false;
			return true;
		} 
		// 하
		else if (before == 1) {
			if(now == 0) return false;
			return true;
		} 
		// 좌
		else if (before == 2) {
			if(now == 3) return false;
			return true;
		}
		// 우
		else {
			if(now == 2) return false;
			return true;
		}
		
	}

	private static boolean checkOut(int nr, int nc) {
		return nr >= 0 && nr < 3 && nc >= 0 && nc < 3;
	}

	private static boolean isSame() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (Map[i][j] != AnswerMap[i][j])
					return false;
			}
		}
		return true;
	}

	private static void printMap() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(Map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
