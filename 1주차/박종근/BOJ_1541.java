package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 메모리: 14352KB
 * 시간: 128ms
 * 소요시간: 54분
 */
public class 잃어버린괄호_1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine() + " ";
		int V = 0;
		int start = 0;
		int end = 0;
		char sign = '+';
		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < line.length(); i++) {
			// 숫자라면
			if (line.charAt(i) != '-' && line.charAt(i) != '+' && line.charAt(i) != ' ') {
				end = i + 1;
			} else {
				int num = Integer.parseInt(line.substring(start, end));
				start = i + 1;
				if (sign == '+') {
					arr.add(num);
				} else {
					arr.add(num * -1);
				}
				sign = line.charAt(i);
			}
		}

		boolean minus = false;
		int temp = 0;

		for (int i = 0; i < arr.size(); i++) {
			int value = arr.get(i);
			// 양수
			if (value > 0) {
				// 마이너스가 앞에 한번 있을 경우
				if (minus) {
					// 마이너스를 할 총 수에 더해준다
					temp += value;
				}
				// 마이너스가 없을 경우
				else {
					// 그냥 값에 바로 더함
					V += value;
				}
			}
			// 음수일 경우
			else {
				// 이미 마이너스가 또 있었다.
				if (minus) {
					V -= temp;
					temp = 0;
					minus = false;
					i--;
				}
				// 마이너스 처음 만났을 경우
				else {
					minus = true;
					temp += (value * -1);
				}
			}
		}

		if (temp > 0)
			V -= temp;
		System.out.println(V);
	}

}
