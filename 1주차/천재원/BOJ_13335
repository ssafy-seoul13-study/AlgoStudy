// 해결시간 30분
// 메모리 16552KB
// 시간 124ms
// 코드 길이 1456B


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_13335_트럭 {
	static int N,W,L;
	static List<int[]> Truck = new ArrayList<>();
	static List<int[]> Bridge = new ArrayList<>();
	static int time = 1;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Truck.add(new int[] {Integer.parseInt(st.nextToken()), W});
		}
		int sum = 0;
		boolean flag = true;
		while(!Truck.isEmpty() || !Bridge.isEmpty()) {
			time +=1;
			
			if(!Truck.isEmpty() && L-sum >= Truck.get(0)[0]) {
				int now[] = Truck.get(0);
				sum += now[0];
				Bridge.add(now);
				Truck.remove(0);
			}
			
			for (int i = 0; i < Bridge.size(); i++) {
				int cur[] = Bridge.get(i);
				Bridge.set(i, new int[] {cur[0], cur[1]-1});
				if(cur[1]-1 == 0) {
					sum -= cur[0];
				}
			}
			
			for(Iterator<int[]> it = Bridge.iterator(); it.hasNext();) {
				int cur[] = it.next();
				if(cur[1] == 0) it.remove();
			}
			
		}
		System.out.println(time);
	}
}
