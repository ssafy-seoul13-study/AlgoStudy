import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// 소트인사이드
// 메모리 : 14252KB, 시간 : 128ms, 풀이시간 : 5분
public class BOJ_1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		Integer [] arr = new Integer[str.length()];
		
		for (int i = 0; i < str.length(); i++) {
			arr[i] = Integer.parseInt(str.charAt(i)+"");
		}
		
		Arrays.sort(arr, Collections.reverseOrder());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		
		System.out.println(sb.toString());
	}

}
