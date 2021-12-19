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
        	int chlen = q.length();
       		int arr0 = q.indexOf(63);
        	int arr1 = q.lastIndexOf(63);
        	System.out.println(Arrays.toString(arr));
        	arr1++;
        	
        	String qsub = null;
        	if(arr0 != 0) {
        		qsub = q.substring(0, arr0);
        	}else { 
        		qsub = q.substring(arr1, chlen);
        	}
        	for (String w : words) {
				if(q.length()==w.length()) {
					if(arr0 == 0 && arr1==chlen) answer[i]++;
					else{
						String wsub = null;
						if(arr0!=0) {
							wsub = w.substring(0,arr0);
						}else {
							wsub = w.substring(arr1, chlen);
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
