import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간: 136ms
// 메모리: 14368KB
// 풀이시간: 1시간 35분
public class BOJ_13335 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력받기
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		// 트럭 하중 입력
		int[] truck = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			truck[i] = Integer.parseInt(st.nextToken());
			
		}
		
		// time[i][0]는 몇번째 차가 빠져야 들어갈 수 있는지, time[i][1]는 i번째 차가 빠져나가는 시간
		int[][] time = new int[N][2];
		// 0번째 차량은 빠져야하는 차가 없고, 나가는 시간은 W+1 
		time[0][0] = -1;
		time[0][1] = W+1;
		
		for (int i = 1; i < N; i++) {
			int onbridge = truck[i];
			time[i][0] = -1;
			// 현재 트럭이 들어가려면 몇 번째 차량이 다리를 빠져나가야 하는지 찾기
			for (int j = i-1; j >=0; j--) {
				onbridge+=truck[j];
				// 최대 하중보다 무겁거나, 다리 길이보다 개수가 많은 경우 해당
				if(onbridge>L || j==i-W) {
					time[i][0] = j;
					break;
				}
			}
			// 빠져야하는 차량이 없거나, 빠져야하는 차량이 바로 앞차랑 같은 경우에 현재 차가 빠져나가는 시간은 앞차+1
			if(time[i][0]==-1 || time[i][0]==time[i-1][0]) time[i][1] = time[i-1][1]+1;
			// 빠져야 하는 차량이 있고, 빠져야하는 차량이 바로 앞차와 다른 경우 현재 차가 빠져나가는 시간은 빠져야하는 차량+W 혹은 앞차+1 둘 중 더 큰 값 
			else time[i][1] = Math.max(time[time[i][0]][1]+W, time[i-1][1]+1);
		}
		System.out.println(time[N-1][1]);
	}



}
