import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 베스트셀러
// 메모리 : 14212KB, 시간 : 124ms, 풀이시간 : 10분
public class BOJ_1302 {

	static int N;
	
	static class Info implements Comparable<Info> {
		String name;
		int cnt;
		
		public Info(String name, int cnt) {
			this.name = name;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Info o) {
			if(this.cnt == o.cnt) {
				return (this.name.compareTo(o.name));
			}
			return o.cnt - this.cnt;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		ArrayList<Info> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String book = br.readLine();
			
			if(!list.isEmpty()) {
				boolean flag = false;
				for (int j = 0; j < list.size(); j++) {
					if(list.get(j).name.equals(book)) {
						list.get(j).cnt += 1;
						flag = true;
						break;
					}
				}
				
				if(!flag) {
					list.add(new Info(book, 1));
				}
			} else {
				list.add(new Info(book, 1));
			}
		}
		
		Collections.sort(list);

		System.out.println(list.get(0).name);

	}

}
