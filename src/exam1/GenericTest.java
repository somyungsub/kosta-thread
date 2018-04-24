package exam1;

import java.util.*;

public class GenericTest {
	public static void main(String[] args) {
		/*
		 * 제네닉스 명시x 		-> Object로 자동적용
		 * 제네닉스 대부분 명시 -> Object는 유용x, 상황에 따라 적용
		 * 
		 * 제네닉스 	-> 컴파일시 에러 체크 
		 * 형변환 x
		 */
		ArrayList list = new ArrayList();
		list.add("java");
		list.add("100");
		// list.add(100);
		list.add("servlet");
		list.add("jdbc");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println();

		for (Object value : list) {
			String s = (String) value;
			System.out.println(s);
		}
		System.out.println();

		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			Object value = iter.next();
			String s = (String) value;
			System.out.println(s);
		}
	}
}
