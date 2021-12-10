package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 1트 실패... 이유 모르겠음...
public class 카드2_2164 {

	static int N;
	static ArrayList<Integer> halfCards = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		ArrayList<Integer> Cards = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			Cards.add(i);
		}

		System.out.println(Pick(Cards));

	}

	private static int Pick(ArrayList<Integer> cards) {

		if (cards.size() == 1) {
			return cards.get(0);
		}

		halfCards = new ArrayList<>();

		for (int i = 0; i < cards.size(); i++) {
			if (i % 2 == 1)
				halfCards.add(cards.get(i));
		}
		return Pick(halfCards);
	}

}
