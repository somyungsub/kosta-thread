package exam5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AdvancedEx7 {
	private final Lock lock = new ReentrantLock();

	public void method() {
		try {
			// ���, ����� ������ ����Ѵ�
			lock.lock();
			System.out.println("��� ���: " + Thread.currentThread().getName());

			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} finally {
			System.out.println("��� ����: " + Thread.currentThread().getName());

			// ��� ����, �ݵ�� finally���� �����ؾ� ��
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
