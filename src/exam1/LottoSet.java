package exam1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class LottoSet {
	public static void main(String[] args) {
		HashSet<Integer> lotto = new HashSet<Integer>();
		Random r = new Random();
		while(lotto.size() < 10){
			lotto.add(r.nextInt(21) + 10);
		}
		Iterator<Integer> iterator = lotto.iterator();
		//System.out.println(iterator.getClass().getName());
		System.out.print("오늘의 로또 번호 : ");
		while (iterator.hasNext()) { // iterator 이용 출력
			int list = iterator.next();
			System.out.print(list);
			if (iterator.hasNext())
				System.out.print(", ");
		}
	}
}





