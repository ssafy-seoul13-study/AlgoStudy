import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//시간: 612ms
//메모리: 47052KB
//풀이시간: 40분
class BOJ_11497 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] lens = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				lens[i] = Integer.parseInt(st.nextToken());
			}
			int ans = go(lens);
			System.out.println(ans);
		}
	}
	private static int go(int[] lens) {

		int N = lens.length;
		Arrays.sort(lens);
		int max = -1;
		for (int i = 2; i < N; i++) {
			max = Math.max(max, Math.abs(lens[i-1]-lens[i]));
			max = Math.max(max, Math.abs(lens[i]-lens[i-2]));
		}
		return max;

	}


}
