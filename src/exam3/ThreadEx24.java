package exam3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreadEx24 {
	public static void main(String[] args) {
		Pool pool = new Pool();
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					String str = pool.get();
					System.out.println("Ï∑®Îìù(" + Thread.currentThread().getName() + ") : " + str);

					Thread.sleep(3000);

					System.out.println("?ï¥?†ú(" + Thread.currentThread().getName() + ") : " + str);
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

class Pool {
	List<String> pool = new LinkedList<>(Arrays.asList("one", "two", "three", "four", "five"));

	public synchronized String get() throws InterruptedException {
		while (pool.size() == 0) {
			wait();
		}
		return pool.remove(0);
	}

	public synchronized void add(String value) {
		pool.add(value);
		notifyAll();
	}
}
