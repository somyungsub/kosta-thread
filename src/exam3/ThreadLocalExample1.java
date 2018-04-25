package exam3;

import java.util.Random;

public class ThreadLocalExample1 {

	public static void main(String args[]) {
		Runnable runner = new Runnable() {
			Random random = new Random();
			int counter = 0;
			ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

			public void run() {
				synchronized (ThreadLocalExample1.class) {
					++counter;
					threadLocal.set(new Integer(random.nextInt(1000)));
					displayValues("run() : " + threadLocal.get().toString() + " : " + threadLocal);
				}
				m1();
				threadLocal.remove();
			}

			public void m1() {
				try {
					Thread.sleep(100);
					displayValues("m1() : " + threadLocal.get().toString() + " : " + threadLocal);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				m2();
			}

			public void m2() {
				try {
					Thread.sleep(100);
					displayValues("m2() : " + threadLocal.get().toString() + " : " + threadLocal);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			private void displayValues(String str) {
				System.out.println(str + "\t" + Thread.currentThread().getName() + "\t(counter:" + counter + ")");
			}
		};

		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(runner);
			t.start();
		}
	}
}
