package exam3;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadEx24_1 {
	public static void main(String[] args) {
		ArrayBlockingQueue<String> pool = new ArrayBlockingQueue<>(5);
		pool.add("one"); 
		pool.add("two"); 
		pool.add("three");
		pool.add("four");
		pool.add("five");
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					String str = pool.take();
					System.out.println("√ÎµÊ(" + Thread.currentThread().getName() + ") : " + str);

					Thread.sleep(3000);

					System.out.println("√ﬂ∞°(" + Thread.currentThread().getName() + ") : " + str);
					pool.add(str);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(r);
			thread.start();
		}
	}
}
