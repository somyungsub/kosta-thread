package exam1;
class Member {
	String name;
	Member(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + "]";
	}	
}

/*
 * ������ Ŭ���� �ε� ����
 */
public class FirstApp {
	public static void main(String[] args) throws Exception{
		
		/*
		 * C�� JAVA ����
		 *  - C�� �⺻������ ��� ������ �ø������� ����
		 *  - JAVA�� �ʿ�� ���� �׶� �׶� ȣ��
		 */
		System.out.println("main() �޼��� �������!!");
		Thread.sleep(3000);
	
		System.out.println("MemberŬ���� ��ü ����!!");
		Member m1 = new Member("�Ѹ�");		
		System.out.println(m1);
		Thread.sleep(3000);
		
		System.out.println("MemberŬ���� ��ü ����!!");
		Member m2 = new Member("�����");
		System.out.println(m2);
		System.out.println("main() �޼��� ��������!!");
	}
}






