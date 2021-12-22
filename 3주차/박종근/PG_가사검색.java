package 프로그래머스;

import java.util.Arrays;

/*
 * 소요시간: 2시간 이상
 * 정확성: 25.0
 * 효율성: 30.0
 * 합계: 55.0 / 100.0
 * 효용성 1,2,3 시간초과
 */
public class 가사검색 {
	static String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
	static String[] queries = { "fro??", "????o", "fr???", "fro???", "pro?" };
	static int[] Answer;
	static String word, querie;

	public static void main(String[] args) {
		Answer = new int[queries.length];
		// 검색문 수만큼 반복
		for (int i = 0; i < queries.length; i++) {
			// 맞는 개수
			int count = 0;
			// 잘리는 부분
			int cut = 0;
			// 앞부터 비교하냐 뒤부터 비교하냐 변수
			// true면 앞부터 비교 false면 뒤부터 비교
			boolean front = true;

			querie = queries[i];
			int length = querie.length();
			System.out.println("검색문자열:" + querie);

			// 처음 한번만 비교할 문자만 추출
			// 앞이 ? 이면
			// 뒤가 문자열이기 때문에 뒷부분만 조회하면 된다.
			if (querie.charAt(0) == '?') {
				for (int l = 0; l < querie.length(); l++) {
					if (querie.charAt(l) != '?') {
						querie = querie.substring(l);
						cut = l;
						front = false;
						break;
					}
				}
			}

			// 아니면 뒤부터 ? 이기때문에
			// 앞부터 문자열만 비교하면 된다.
			else {
				for (int l = 0; l < querie.length(); l++) {
					if (querie.charAt(l) == '?') {
						querie = querie.substring(0, l);
						cut = l;
						break;
					}
				}
			}

			System.out.println("실제검색문자열 추출:" + querie);

			// 전체 가사만큼 반복
			for (int j = 0; j < words.length; j++) {
				word = words[j];
				System.out.println("가사:" + word);
				// 자리수가 안맞으면 무조건 실패
				if (length != word.length()) {
					Answer[i] = count;
//					System.out.println("글자수 불일치 탈락");
					continue;
				}

				// 자리수가 맞다면
				// 검색 가사도 비교 문자만큼 자른다.
				// 뒤부터 조사한다면 중간부터 뒤까지 자름
				if (!front) {
					word = word.substring(cut);
				}

				// 앞부터 문자열 검색
				// 앞부터 중간까지 자름
				else {
					word = word.substring(0, cut);
				}

				System.out.println("실제 비교 가사 추출:" + word);

				if (querie.equals(word)) {
					count++;
					System.out.println("일치 카운트 증가 :" + count);
				}
			}

			Answer[i] = count;
		}
		System.out.println(Arrays.toString(Answer));
	}
}
