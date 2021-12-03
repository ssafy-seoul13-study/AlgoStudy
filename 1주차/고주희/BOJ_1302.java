package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//베스트셀러
//시간:132ms 메모리:14172KB 풀이 시간:15분

/*
if(book.containsKey(b)) book.replace(b, book.get(b), book.get(b)+1);
이 부분을
if(book.containsKey(b)) book.put(b, book.get(b)+1);
로 바꾸는 경우
시간:120ms 메모리:14116KB 풀이 시간:기존+10분
*/
public class BOJ_1302 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> book = new HashMap<String, Integer>();
		
		for (int i = 0; i < N; i++) {
			String b = br.readLine();
			if(book.containsKey(b)) book.replace(b, book.get(b), book.get(b)+1);
			else book.put(b, 1);
		}
		int max = 0;
		String maxtitle = null;
		for (String title : book.keySet()) {
			int count = book.get(title);
			if(max<count) {
				max = count;
				maxtitle = title;
			}else if(max==count) {
				if(maxtitle.compareTo(title)>0) {
					maxtitle = title;
				}
			}
		}
		System.out.println(maxtitle);
	}

}
