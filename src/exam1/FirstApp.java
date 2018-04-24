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
 * 간단한 클래스 로딩 연습
 */
public class FirstApp {
	public static void main(String[] args) throws Exception{
		
		/*
		 * C와 JAVA 차이
		 *  - C는 기본적으로 모든 정보를 올린다음에 실행
		 *  - JAVA는 필요시 마다 그때 그때 호출
		 */
		System.out.println("main() 메서드 수행시작!!");
		Thread.sleep(3000);
	
		System.out.println("Member클래스 객체 생성!!");
		Member m1 = new Member("둘리");		
		System.out.println(m1);
		Thread.sleep(3000);
		
		System.out.println("Member클래스 객체 생성!!");
		Member m2 = new Member("도우너");
		System.out.println(m2);
		System.out.println("main() 메서드 수행종료!!");
	}
}






