// 시간 : 10분
// 메모리 : 48876kb
// 수행시간 : 468ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11497_통나무건너뛰기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] cargo;
	static int[] logs;
	static int T,N,max=0,min=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <=T; t++) {
			max=0; min=Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			cargo = new int[N];
			logs = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				cargo[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(cargo);
			int idx = 0;
			int idx2 = 0;
			while(true) {
				if(idx == N || idx2 == N-1) break;
				logs[idx2++] = cargo[idx++];
				if(idx == N) break;
				logs[N-idx2] = cargo[idx++];
			}
			for(int i=0; i<N; i++) {
				max = Math.max(Math.abs(logs[i%N]-logs[(i+1)%N]), max);
			}
			
			System.out.println(max);
		}
	}
}
