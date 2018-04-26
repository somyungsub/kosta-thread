package exam3;

import java.util.Random;

public class ThreadLocalExample4 {

	public static void main(String[] args) {
		ThreadLocalThread thread1 = new ThreadLocalThread();
		ThreadLocalThread thread2 = new ThreadLocalThread();
		ThreadLocalThread thread3 = new ThreadLocalThread();
		ThreadLocalThread thread4 = new ThreadLocalThread();
		ThreadLocalThread thread5 = new ThreadLocalThread();

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}
}

class ThreadLocalThread extends Thread {
	static ThreadLocal<Integer> threadLocalValue = new ThreadLocal<Integer>() {

		@Override
		protected Integer initialValue() {
			return new Random().nextInt(100);
		}
	};

	@Override
	public void run() {
		String threadName = getName();
		System.out.println("run() 호출 : " + threadName + " - " + threadLocalValue.get() + "-" + threadLocalValue);
		new A1().proc1();
		new B1().proc2();
	}
}

class A1 {
	void proc1() {
		System.out.println("proc1() 호출 : " + Thread.currentThread().getName() + " - " + ThreadLocalThread.threadLocalValue.get());
	}
}
class B1 {
	void proc2() {
		System.out.println("proc2() 호출 : " + Thread.currentThread().getName() + " - " + ThreadLocalThread.threadLocalValue.get());
	}
}
