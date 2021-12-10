// 풀이시간 5분
// 메모리 43020KB
// 시간 140ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class Main_BOJ_2164_카드2 {
	static int N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		Queue<Integer> que = new LinkedList<>();
		for(int i=1; i<=N ; i++) {
			que.offer(i);
		}
		int result = 0;
		if(N == 1) System.out.println(1);
		else {
			while(true) {
				que.poll();
				if(que.size() == 1) {
					result = que.poll();
					break;
				}
				que.offer(que.poll());
			}
			System.out.println(result);
		}
	}
}
