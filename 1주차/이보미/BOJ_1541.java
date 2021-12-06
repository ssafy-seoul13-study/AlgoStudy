import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 잃어버린 괄호
// 메모리 : 14164KB, 시간 : 124ms, 풀이시간 : 30분
public class BOJ_1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		String [] arr = str.split("\\-");
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			String [] temp = arr[i].split("\\+");
			int tempSum = 0;
			
			for (int j = 0; j < temp.length; j++) {
				tempSum += Integer.parseInt(temp[j]);
			}
			
			if(i == 0) {
				sum += tempSum;
			} else {
				sum -= tempSum;
			}
		}
		
		System.out.println(sum);
	}

}
