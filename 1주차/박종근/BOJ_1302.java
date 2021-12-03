package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* 메모리: 14244KB	
 * 시간: 128ms
 * 소요시간: 27분 
 */
public class 베스트셀러_1302 {
	static int N, BestSellCount;
	static String BestName;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BestSellCount = 0;
		N = Integer.parseInt(br.readLine());

		// 이름과 횟수를 저장할 헤쉬맵
		HashMap<String, Integer> hm = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			// 헤쉬맵에 넣는데 이미 있다면 해당 값에 +1을 하고 없다면 1을 넣는다.
			hm.put(name, hm.getOrDefault(name, 0) + 1);

			// 더 클경우 베스트셀러 변경
			if (BestSellCount < hm.get(name)) {
				BestName = name;
				BestSellCount = hm.get(name);
			}
			// 최대값이 같을 경우 더 사전순으로 비교
			else if (BestSellCount == hm.get(name)) {
				if (BestName.compareTo(name) > 0)
					BestName = name;
			}
		}

		System.out.println(BestName);
	}

}
