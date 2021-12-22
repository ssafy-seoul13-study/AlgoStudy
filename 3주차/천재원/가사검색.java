// 정확성 18/18
// 효율성 3/5
// 개열받음


import java.util.*;

class Solution {
    public Object[] solution(String[] words, String[] queries) {
        List<Integer> list = new ArrayList<>();
            for(String query : queries){
            int cnt =0;
            int idx = 0;
            int query_len = query.length();
            boolean flag = false; // true -> 접두사 , false -> 접미사
            String sub_query = "";
            char[] query_arr = query.toCharArray();
            
            if(query_arr[idx] == '?') { // 접두사가 ?인경우
            	flag = true;
            	while(idx < query.length()) {
            		int tmp = query.indexOf("?", idx);
            		if(tmp == -1) break;
            		idx = tmp+1;
            	}
            	sub_query = query.substring(idx);
//            	System.out.println(sub_query +" " + idx);
            }else { // 접미사가 ? 인경우
            	idx = query.indexOf("?");
            	sub_query = query.substring(0, idx);
//            	System.out.println(sub_query+" " + idx);
            }
            for(String word : words){
                if(query_len != word.length()) continue;
                if(flag) {
                	// 뒤만비교
                	if(sub_query.equals(word.substring(idx))) cnt +=1;
                }else {
                	// 앞만 비교
                	if(sub_query.equals(word.subSequence(0, idx))) cnt +=1;
                }
            }
            list.add(cnt);
        }
        
        return list.toArray();
    }
}
