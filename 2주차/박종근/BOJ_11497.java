package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 통나무건너기_11497 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder Answer = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int MinLevel = Integer.MIN_VALUE;

			int N = Integer.parseInt(br.readLine());
			int[] tree = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(tree);

			int leftIdx = N - 3;
			int rightIdx = N - 2;
			int leftValue = tree[leftIdx];
			int rightValue = tree[rightIdx];

//			System.out.println("max:"+tree[N-1]);
//			System.out.println("left:"+leftValue);
//			System.out.println("right:"+rightValue);

			MinLevel = Math.max(tree[N - 1] - leftValue, tree[N - 1] - rightValue);
//			System.out.println(MinLevel);

			while (leftIdx-2 >= 0 && rightIdx-2 >= 0) {
				leftIdx -= 2;
				rightIdx -= 2;
//				System.out.println("left:"+leftIdx);
//				System.out.println("right:"+rightIdx);

				// 둘다 있을 때
				MinLevel = Math.max(MinLevel, Math.max(leftValue - tree[leftIdx], rightValue - tree[rightIdx]));
//					System.out.println(MinLevel);

				leftValue = tree[leftIdx];
				rightValue = tree[rightIdx];
				MinLevel = Math.max(rightValue - leftValue, MinLevel);
			}

			// 홀수라서 하나 남았을 때 
			if(rightIdx == 0) {
				MinLevel = Math.max(MinLevel, Math.min(leftValue - tree[rightIdx], rightValue - tree[rightIdx]));
			}				
			Answer.append(MinLevel).append("\n");

		}

		System.out.print(Answer);

	}

}
