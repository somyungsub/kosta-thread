package exam5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AdvancedEx8 {

	public static void main(String[] args) {
		LockCondition condition = new LockCondition();
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					String str = condition.get();
					System.out.println("���: " + str);

					TimeUnit.SECONDS.sleep(5);

					System.out.println("����: " + str);
					condition.add(str + "!!");

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

class LockCondition {
	//private final MyReentrantLock lock = new MyReentrantLock();
	private final Lock lock = new ReentrantLock();
	private final Condition condition = lock.newCondition();

	List<String> pool = new LinkedList<>(Arrays.asList("one", "two", "three", "four", "five"));

	public String get() throws InterruptedException {
		try {
			lock.lock();
			// System.out.println("lock�� ������ ������ : "+lock.owner());
			// List�� ��� �ִ� ���� ���
			while (pool.size() == 0) {
				condition.await();
			}

			return pool.remove(0);

		} finally {
			lock.unlock();
		}
	}

	public void add(String value) {
		try {
			lock.lock();

			pool.add(value);

			// ��� ���� �����带 �簳
			condition.signalAll();

		} finally {
			lock.unlock();
		}
	}
}

/*class MyReentrantLock extends ReentrantLock {
	String owner() {
		Thread t = this.getOwner();
		if (t != null) {
			return t.getName();
		} else {
			return "none";
		}
	}
}*/