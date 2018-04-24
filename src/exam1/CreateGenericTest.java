package exam1;

import java.util.Date;

public class CreateGenericTest {
	public static void main(String[] args) {
		/*
		 * 제네닉스 적용 확인 -> 꺽새로 확인 
		 */
		
		// String만 정의
		Value1 o1 = new Value1();
		o1.put("abc");
		String s1 = o1.get(); 
		System.out.println(s1);		
		
		// 형변환 필수
		Value2 o2 = new Value2();
		o2.put("abc");
		String s2 = (String)o2.get(); 
		System.out.println(s2);
		
		// 제네닉스 : String
		Value3<String> o3 = new Value3<String>();		
		o3.put("abc");
		String s3 = o3.get(); 
		System.out.println(s3);
		
		// 제네닉스 : Date
		Value3<Date> o4 = new Value3<Date>();		
		o4.put(new Date());
		Date s4 = o4.get(); 
		System.out.println(s4);
	}
}

/*
 * Only String형만 다루는 Class
 */
class Value1 {
	String obj;
	void put(String obj){
		this.obj = obj;
	}
	String get() {
		return obj;
	}
}


/*
 * Object형을 다루는 Class
 * 모든 Class를 다루기 위함
 */
class Value2 {
	
	Object obj;
	
	/*
	 * 저장시 문제 x
	 */
	void put(Object obj){
		this.obj = obj;
	}
	
	/*
	 * 형변환의 문제! -> 형변환 필수 (단점)
	 */
	Object get() {
		return obj;
	}
}

/*
 * new Value3<Date>
 * <명칭구분>  ex) T,K,V...
 * 
 * TT -> obj (리턴 값 정의)  
 * -> TT : 클래스 타입 아님
 * -> 객체 생성 시점에서 정의된 타입파라미터 -> 타입 정의
 * 
 * TT ex) Value3<Date>, Value3<String> : TT는 동적 타입 설정 (제네닉스 구문의 핵심)
 */
class Value3<TT> {
	TT obj;
	void put(TT obj){
		this.obj = obj;
	}
	TT get() {
		return obj;
	}
}
