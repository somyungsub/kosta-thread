package exam3;

public class DeadLockExample1 {
	public static void main(String args[]) {
		Object lock1 = new Object();
		Object lock2 = new Object();
		ThreadDemo1 T1 = new ThreadDemo1(lock1, lock2);
		ThreadDemo2 T2 = new ThreadDemo2(lock1, lock2);
		T1.start();
		T2.start();
	}
}

class ThreadDemo1 extends Thread {
	Object lock1, lock2;

	ThreadDemo1(Object lock1, Object lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}

	public void run() {
		synchronized (lock1) {
			System.out.println("Thread 1: Holding lock 1...");

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			System.out.println("Thread 1: Waiting for lock 2...");

			synchronized (lock2) {
				System.out.println("Thread 1: Holding lock 1 & 2...");
			}
		}
	}
}

class ThreadDemo2 extends Thread {
	Object lock1, lock2;

	ThreadDemo2(Object lock1, Object lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}

	public void run() {
		synchronized (lock2) {
			System.out.println("Thread 2: Holding lock 2...");

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			System.out.println("Thread 2: Waiting for lock 1...");

			synchronized (lock1) {
				System.out.println("Thread 2: Holding lock 1 & 2...");
			}
		}
	}
}
