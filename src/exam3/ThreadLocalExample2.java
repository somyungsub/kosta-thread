
package exam3;

public class ThreadLocalExample2 {	
	public static void main(String args[]) throws Exception {
		for(int i=0; i < 3; i++){
			new Thread() {
				public void run() {
					try {
					new A().a();
					} catch(Exception e) {}
				}
			}.start();
			Thread.sleep(40000);
		}	
	}
}
	
class Context {
	public static ThreadLocal<String> local = new ThreadLocal<String>();	
}

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
