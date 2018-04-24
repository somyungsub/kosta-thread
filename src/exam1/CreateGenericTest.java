package exam1;

import java.util.Date;

public class CreateGenericTest {
	public static void main(String[] args) {
		/*
		 * ���״н� ���� Ȯ�� -> ������ Ȯ�� 
		 */
		
		// String�� ����
		Value1 o1 = new Value1();
		o1.put("abc");
		String s1 = o1.get(); 
		System.out.println(s1);		
		
		// ����ȯ �ʼ�
		Value2 o2 = new Value2();
		o2.put("abc");
		String s2 = (String)o2.get(); 
		System.out.println(s2);
		
		// ���״н� : String
		Value3<String> o3 = new Value3<String>();		
		o3.put("abc");
		String s3 = o3.get(); 
		System.out.println(s3);
		
		// ���״н� : Date
		Value3<Date> o4 = new Value3<Date>();		
		o4.put(new Date());
		Date s4 = o4.get(); 
		System.out.println(s4);
	}
}

/*
 * Only String���� �ٷ�� Class
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
 * Object���� �ٷ�� Class
 * ��� Class�� �ٷ�� ����
 */
class Value2 {
	
	Object obj;
	
	/*
	 * ����� ���� x
	 */
	void put(Object obj){
		this.obj = obj;
	}
	
	/*
	 * ����ȯ�� ����! -> ����ȯ �ʼ� (����)
	 */
	Object get() {
		return obj;
	}
}

/*
 * new Value3<Date>
 * <��Ī����>  ex) T,K,V...
 * 
 * TT -> obj (���� �� ����)  
 * -> TT : Ŭ���� Ÿ�� �ƴ�
 * -> ��ü ���� �������� ���ǵ� Ÿ���Ķ���� -> Ÿ�� ����
 * 
 * TT ex) Value3<Date>, Value3<String> : TT�� ���� Ÿ�� ���� (���״н� ������ �ٽ�)
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
