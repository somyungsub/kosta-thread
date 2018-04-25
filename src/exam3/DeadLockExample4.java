package exam3;

public class DeadLockExample4 {
	public static void main(String[] args) throws InterruptedException {
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();

		Thread t1 = new Thread(new SyncThreadNew(obj1, obj2), "t1");
		Thread t2 = new Thread(new SyncThreadNew(obj2, obj3), "t2");
		Thread t3 = new Thread(new SyncThreadNew(obj3, obj1), "t3");

		t1.start();
		Thread.sleep(5000);
		t2.start();
		Thread.sleep(5000);
		t3.start();

	}

}

class SyncThreadNew implements Runnable {
	private Object obj1;
	private Object obj2;

	public SyncThreadNew(Object o1, Object o2) {
		this.obj1 = o1;
		this.obj2 = o2;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " ����ȭ ������ �� �����Դϴ�. " + obj1);
		synchronized (obj1) {
			System.out.println(name + " ȹ��(��) " + obj1);
			work();
		}
		System.out.println(name + " ����  " + obj1);
		System.out.println(name + " ����ȭ ������ �� �����Դϴ�. " + obj2);
		synchronized (obj2) {
			System.out.println(name + " ȹ��(��) " + obj2);
			work();
		}
		System.out.println(name + " ����  " + obj2);

		System.out.println(name + " ����.");
	}

	private void work() {
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}