package week3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 답 안나와서 https://girawhale.tistory.com/110 여기 코드 봄
// 풀이시간 : 2일

public class Programmers_kakao_가사검색4 {
	
	static class Trie{
		Map<Integer, Integer> lenMap = new HashMap<>();
		private Trie[] child = new Trie[26];

		void insert(String word) {
			// 루트를 현재 노드로 잡는다.
			Trie curNode = this;
			// 삽입할 word의 길이
			int len = word.length();
			// Map은 word의 길이와, 해당 길이를 key로 갖고 있는 원소가 있는지 확인해서 있으면 개수를 1 더하고, 없으면 1을 삽입한다.
			lenMap.put(len, lenMap.getOrDefault(lenMap, 0)+1);
			// word를 char배열로 나눈다.
			char[] charr = word.toCharArray();
			// a를 0, z를 25로 하여 현재 노드의 하위 Trie 중 해당 인덱스가 비어 있으면 새로운 하위 Trie를 만들어준다.
			// 하위 Trie가 있으면, 즉 현재 노드의 하위 인덱스 중 알파벳에 해당하는 인덱스에도 하위 인덱스가 있으면 현재 노드의 하위 해당 인덱스로 옮겨간다.
			// 바뀐 현재 노트의 lenMap에 word의 전체 길이와 해당 길이를 key로 갖고 있는 원소가 있는지 확인해서 있으면 1을 더하고, 없으면 1을 삽입한다.
			for (char ch : charr) {
				int idx = ch - 'a';
				if(curNode.child[idx]==null) curNode.child[idx] = new Trie();
				
				curNode = curNode.child[idx];
				curNode.lenMap.put(len,  curNode.lenMap.getOrDefault(len, 0)+1);
			}
		}
		
		int find(String word, int i) {
			// word의 i번째 character가 '?'이면 lenMap에 word 길이가 key로 있는지 확인하고, 있으면 value, 없으면 0을 리턴한다
			if(word.charAt(i)==63) {
				return lenMap.getOrDefault(word.length(), 0);
			}
			// '?'가 아닌 경우 해당 character를 인덱스 값으로 변환하여 해당 인덱스에 하위 Trie가 있는지 확인한다.
			// 하위 Trie가 없는 경우 0을 리턴하고, 있는 경우 현재 Trie에서 다음 글자를 확인한다.(현재 Trie의 하위 Trie들을 확인하도록 보낸다)
			int idx = word.charAt(i) - 'a';
			return child[idx] == null? 0 : child[idx].find(word, i+1);
		}

		
	}
	
	

	public static void main(String[] args) {

		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
		
		System.out.println(Arrays.toString(solution(words, queries)));
	}
	
	public static int[] solution(String[] words, String[] queries) {
     
		// 앞에서부터 정렬된 Trie
		Trie front = new Trie();
		// 뒤에서부터 정렬된 Trie
		Trie back = new Trie();
		
		// 앞, 뒤에서 시작하는 word를 각각 Trie에 넣는다.
		for (String word : words) {
			front.insert(word);
			back.insert(reverse(word));
		}
		// queries 배열을 stream으로 바꾼다 : [fro??, ????o, fr???, fro???, pro?]
		// mapToInt => stream 각각을 내부에 있는 함수에 돌리는데, 현재 Stream 타입인 원소를 Int 타입으로 바꾸어서 출력한다.
		// stream을 array로 변환하여 출력한다.
		return Arrays.stream(queries).mapToInt(query-> query.charAt(0)=='?' ? back.find(reverse(query), 0) : front.find(query, 0)).toArray();
	}

	private static String reverse(String query) {
		return new StringBuilder(query).reverse().toString();
	}

}
