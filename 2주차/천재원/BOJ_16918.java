// 풀이시간 : 2일..
// 메모리 : 16936 kb
// 시간 : 228 ms

import java.util.*;
import java.io.*;


public class Main_BOJ_16918_봄버맨 {
	static int R,C,N;
	static char map[][];
	static int time;
	static Queue<int[]> que = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int dr[] = {0,-1,1,0,0};
	static int dc[] = {0,0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		int[][] boom = new int[R][C];
		for(int i =0; i< R; i++) {
			char [] tmp = br.readLine().toCharArray();
			for(int j = 0; j< C; j++) {
				boom[i][j]= tmp[j]=='O'?3:0;// 터지기 까지 남은 시간 
			}
		}
		for(int n =2; n<= N; n++) {
			if(n%2==1) {
				for(int i =0; i< R; i++) {
					for(int j =0; j< C; j++) {
						if(boom[i][j]==n) {
							boom[i][j] = 0;
							if(i>0 && boom[i-1][j]!=n)boom[i-1][j]=0;
							if(j>0 && boom[i][j-1]!=n)boom[i][j-1]=0;
							if(i<R-1 && boom[i+1][j]!=n)boom[i+1][j]=0;
							if(j<C-1 && boom[i][j+1]!=n)boom[i][j+1]=0;
						}
					}
				}
			}else {
				for(int i=0; i<R; i++) {
					for(int j =0; j< C; j++) {
						boom[i][j]= boom[i][j]==0?n+3:boom[i][j];
					}
				}
			}
		}
		for(int i=0; i<R; i++) {
			for(int j =0; j< C; j++) {
				sb.append(boom[i][j]>0?'O':'.');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
