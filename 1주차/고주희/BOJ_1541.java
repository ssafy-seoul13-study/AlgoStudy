import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 시간 : 124ms
// 메모리 : 14200KB
// 풀이 시간 : 30분

public class BOJ_1541 {

	public static void main(String[] args) throws IOException {

   		 // 입력받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		// - 기준으로 분할
		String[] s = string.split("-");
		List<Integer> number = new ArrayList<Integer>();
		// 분할한 걸 다시 + 기준으로 분할해서 더한 후 number에 넣어줌
		for (String pluss : s) {
			String[] s2 = pluss.split("\\+");
			int n = 0;
			for (String num : s2) {
				n+=Integer.parseInt(num);
			}
			number.add(n);
		}
		// number에 있는 값은 index 0 빼고 다 뺌
		int answer = number.get(0);
		int len = number.size();
		for (int i = 1; i < len; i++) {
			answer-=number.get(i);
		}
		}
   		 //출력
		System.out.println(sum);
	}

}
