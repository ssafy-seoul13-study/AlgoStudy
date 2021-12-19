package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 효율성 1,2,3 틀려서 55점 여기까지 90분
public class Programmers_kakao_가사검색2 {

	public static void main(String[] args) {

		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
		
		System.out.println(Arrays.toString(solution(words, queries)));
	}
	
	public static int[] solution(String[] words, String[] queries) {
        
	    int qlen = queries.length;
        int[] answer = new int[qlen];
        for (int i = 0; i<qlen; i++) {
        	String q = queries[i];
        	int[] arr = new int[2];
        	int chlen = q.length();
        	arr[0] = q.indexOf(63);
        	arr[1] = q.lastIndexOf(63);
        	System.out.println(Arrays.toString(arr));
        	arr[1]++;
        	
        	String qsub = null;
        	if(arr[0] != 0) {
        		qsub = q.substring(0, arr[0]);
        	}else { 
        		qsub = q.substring(arr[1], chlen);
        	}
        	for (String w : words) {
				if(q.length()==w.length()) {
					if(arr[0] == 0 && arr[1]==chlen) answer[i]++;
					else{
						String wsub = null;
						if(arr[0]!=0) {
							wsub = w.substring(0,arr[0]);
						}else {
							wsub = w.substring(arr[1], chlen);
						}
	//					System.out.println(qsub+" "+wsub);
						if(qsub.equals(wsub)) answer[i]++;
					}
				}
			}
		}
		
        return answer;
    }
	
}
