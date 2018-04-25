package exam3;

public class DeadLockExample2 {
	public static void main(String args[]) {
		Object lock1 = new Object();
		Object lock2 = new Object();
		ThreadDemo3 T1 = new ThreadDemo3(lock1, lock2);
		ThreadDemo4 T2 = new ThreadDemo4(lock1, lock2);
		T1.start();
		T2.start();
	}
}

class ThreadDemo3 extends Thread {
	Object lock1, lock2;

	ThreadDemo3(Object lock1, Object lock2) {
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

class ThreadDemo4 extends Thread {
	Object lock1, lock2;

	ThreadDemo4(Object lock1, Object lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}

	public void run() {
		synchronized (lock1) {
			System.out.println("Thread 2: Holding lock 1...");

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			System.out.println("Thread 2: Waiting for lock 2...");

			synchronized (lock2) {
				System.out.println("Thread 2: Holding lock 1 & 2...");
			}
		}
	}
}
