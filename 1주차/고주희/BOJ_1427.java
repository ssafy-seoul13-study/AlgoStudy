package week1;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;

//4분
public class BOJ_1427 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] number = br.readLine().toCharArray();
		Arrays.sort(number);
		int numlen = number.length;
		for (int i = numlen-1; i >=0; i--) {
			System.out.print(number[i]);
		}

	}

}
