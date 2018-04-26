
package exam3;

public class ThreadLocalExample2 {
    public static void main(String args[]) throws Exception {
        /*
            쓰레드 3개 생성
         */
        for (int i = 0; i < 3; i++) {
            new Thread() {  // 쓰레드의 자손이 됨
                public void run() {
                    try {
                        new A().a();
                    } catch (Exception e) {
                    }
                }
            }.start();
            Thread.sleep(20000);
        }
    }
}
	
class Context {
	public static ThreadLocal<String> local = new ThreadLocal<String>();	
}

/*
    Context클래스에 접근하여 처리
    a->b->c로 연계
 */
class A {
    public void a() throws Exception{    	
        Context.local.set(Thread.currentThread().getName()+"에 의해 저장된 문자열");
        System.out.println("a() 메서드  --> " + Context.local.get() + " : " + Context.local);
        B b = new B();
        b.b();
    }
}

class B {
    public void b() throws Exception{
        String s = Context.local.get();
        System.out.println("b() 메서드  --> " + s + " : " + Context.local);
        C c = new C();
        c.c();
    }
}

class C {
    public void c() throws Exception {
    	String s = Context.local.get();
        System.out.println("c() 메서드  --> " + s  + " : " + Context.local);
        Thread.sleep(5000);
    }
}
