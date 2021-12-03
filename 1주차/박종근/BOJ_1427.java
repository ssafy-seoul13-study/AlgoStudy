package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/* 메모리: 14244KB
 * 시간: 136ms
 * 소요시간: 22분 
 */
public class 소트인사이드_1427 {

	public static void main(String[] args) throws IOException {
		StringBuilder Answer = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		// 내림차순을 사용하고 싶을 경우 int 배열이 아닌 Integer 배열로 만들어 줘야 한다.
		Integer[] nums = new Integer[word.length()];
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = word.charAt(i)-'0';
		}
		
		// 내림차순 sort 사용 방법
		Arrays.sort(nums, Collections.reverseOrder());
		
		for (int i = 0; i < nums.length; i++) {
			Answer.append(nums[i]);
		}
		
		System.out.println(Answer);
	}

}
