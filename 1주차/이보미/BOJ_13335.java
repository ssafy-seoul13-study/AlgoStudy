import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 트럭
// 메모리 : 15308KB, 시간 : 160ms, 풀이시간: 40분
public class BOJ_13335 {

	static int N, W, L;
	static Queue<Integer> trucks;
	static Queue<Integer> bridge;
	static int time;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		trucks = new LinkedList<>();
		bridge = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			trucks.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < W; i++) {
			bridge.add(0);
		}
		
		int weight = 0;
		while(!bridge.isEmpty()) {
			weight -= bridge.poll();
			
			if(!trucks.isEmpty() && weight+trucks.peek() <= L) {
				int truck = trucks.poll();
				bridge.add(truck);
				weight += truck;
			}else if(!trucks.isEmpty()) {
				bridge.add(0);
			}

			time++;
		}
		
		System.out.println(time);
	}

}
