package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 메모리: 14344KB
 * 시간: 140ms
 * 소요시간: 80분
 */
public class 트럭_13335 {
	static int N, L, W, T, OnBridgeWeight;
	static int[] Truck, TruckCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		OnBridgeWeight = 0;
		T = 0;

		Truck = new int[N + 1];
		TruckCount = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");

		// 트럭 무게 배열과
		// 해당 수만큼 다리수 배열 만들기
		for (int i = 0; i < N; i++) {
			Truck[i] = Integer.parseInt(st.nextToken());
			TruckCount[i] = L;
		}

		int startIdx = 0;
		int endIdx = 0;
		while (true) {
			// time ++ 증가
			T++;

			// 트럭 카운트 인덱스의 마지막이 0이되면 끝
			if (TruckCount[N - 1] == 0) {
				System.out.println(T);
				break;
			}

			// 다리 무게를 안넘을면 다음거 올라가
			if (OnBridgeWeight + Truck[endIdx] <= W) {
				OnBridgeWeight += Truck[endIdx];
				if (endIdx < N)
					endIdx++;
			}

			int out = 0;
			// 올라간 트럭 다리수 배열 --
			for (int i = startIdx; i < endIdx; i++) {
				TruckCount[i]--;
				// 0이 되면 나간거 다리위 무게에서 뺴기
				if (TruckCount[i] == 0) {
					OnBridgeWeight -= Truck[i];
					out++;
				}
			}

			// 나간 트럭 인덱스++;
			startIdx += out;
		}

	}

}
