package exam3;


public class ThreadLocalExample3  {
    public static void main(String args[]) {
    	Thread threadOne = new ThreadLocalTest("test", "1234");
    	threadOne.start();
        Thread threadTwo = new ThreadLocalTest("guest", "guest");
        threadTwo.start();
    }  
}

class ThreadLocalTest extends Thread {
	String account, password;
	ThreadLocalTest(String account, String password) {
		this.account = account;
		this.password = password;
	}


    @Override
    public void run() {
        Token token = new Token();
        token.setTransactionId(getName() + "-" + account + "-" + password);

        MyThreadLocal.set(token);

        new BusinessService1().businessMethod();
        MyThreadLocal.unset();

    }
}

class MyThreadLocal {

	private static final ThreadLocal<Token> userThreadLocal = new ThreadLocal<Token>();

	public static void set(Token user) {
		System.out.println(Thread.currentThread().getName() + " 스레드로 부터 " + userThreadLocal + " 객체에 Token 객체 설정 !!");
		userThreadLocal.set(user);
	}

	public static void unset() {
		userThreadLocal.remove();
	}

	public static Token get() {
		return userThreadLocal.get();
	}
}


class Token {

	private String transactionId = null;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}

class BusinessService1 {

    public void businessMethod() {
        Token t = MyThreadLocal.get();
        System.out.println(getClass().getName() + " : " + t.getTransactionId());
        new BusinessService2().businessMethod();
    }
}
class BusinessService2 {

    public void businessMethod() {
        Token t = MyThreadLocal.get();
        System.out.println(getClass().getName() + " : " + t.getTransactionId());
    }
}