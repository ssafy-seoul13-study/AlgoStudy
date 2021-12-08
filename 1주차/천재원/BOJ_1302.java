// 알고리즘 푸는 시간 20분
// 메모리 11668KB
// 시간 76ms.
//코드길이 1021B

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main_BOJ_1302_베스트셀러 {
	static int N;
	static int max;
	static String result;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static HashMap<String, Integer> books = new HashMap<>();
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if(books.containsKey(str)) {
				books.replace(str, books.get(str)+1);
			}else {
				books.put(str,1);
			}
		}
		String[] buf = new String[books.size()];

		int idx = 0;
		for (String s : books.keySet()) {
			max = Math.max(max, books.get(s));
			buf[idx ++] = s;
		}
		Arrays.sort(buf);
		for (String string : buf) {
			if(books.get(string) == max){
				System.out.println(string);
				break;
			}
		}
		
		
	}
}
