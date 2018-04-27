package exam5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AdvancedEx7 {
	private final Lock lock = new ReentrantLock();

	public void method() {
		try {
			// 잠금, 취득할 때까지 대기한다
			lock.lock();
			System.out.println("잠금 취득: " + Thread.currentThread().getName());

			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} finally {
			System.out.println("잠금 해제: " + Thread.currentThread().getName());

			// 잠금 해제, 반드시 finally에서 실행해야 함
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		AdvancedEx7 sample = new AdvancedEx7();

		Runnable r = new Runnable() {
			@Override
			public void run() {
				sample.method();
			}
		};

		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
	}
}
