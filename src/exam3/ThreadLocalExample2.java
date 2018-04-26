
package exam3;

public class ThreadLocalExample2 {
    public static void main(String args[]) throws Exception {
        /*
            ������ 3�� ����
         */
        for (int i = 0; i < 3; i++) {
            new Thread() {  // �������� �ڼ��� ��
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
    ContextŬ������ �����Ͽ� ó��
    a->b->c�� ����
 */
class A {
    public void a() throws Exception{    	
        Context.local.set(Thread.currentThread().getName()+"�� ���� ����� ���ڿ�");
        System.out.println("a() �޼���  --> " + Context.local.get() + " : " + Context.local);
        B b = new B();
        b.b();
    }
}

class B {
    public void b() throws Exception{
        String s = Context.local.get();
        System.out.println("b() �޼���  --> " + s + " : " + Context.local);
        C c = new C();
        c.c();
    }
}

class C {
    public void c() throws Exception {
    	String s = Context.local.get();
        System.out.println("c() �޼���  --> " + s  + " : " + Context.local);
        Thread.sleep(5000);
    }
}
