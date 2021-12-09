package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		char[][] ansmap = new char[R][C];
		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
			ansmap[i] = str.toCharArray();
		}
		if(N!=0 && N%2==0) {
			for (int i = 0; i < R; i++) {
				Arrays.fill(ansmap[i], 'O');
			}
		}else{
			char[][] firstbomb = bomb(map);
			char[][] secondbomb = bomb(firstbomb);
			if(N!=1 && N%4==1) {
				ansmap = secondbomb;
			}else if(N%4==3) {
				ansmap = firstbomb;
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(ansmap[i][j]);
			}
			System.out.println();
		}
	}


	private static char[][] bomb(char[][] map) {

		int R = map.length;
		int C = map[0].length;
		char[][] temp = new char[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(temp[i], 'O');
		}
		int[] dr = {-1,0,0,1,0};
		int[] dc = {0,-1,0,0,1};
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]=='O') {
					for (int d = 0; d < 5; d++) {
						int nr = i+dr[d];
						int nc = j+dc[d];
						if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
						temp[nr][nc] = '.';
					}
				}
			}
		}
		return temp;
		
	}

}
