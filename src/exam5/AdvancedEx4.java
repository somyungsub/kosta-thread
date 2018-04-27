package exam5;

import java.util.concurrent.Semaphore;

public class AdvancedEx4 extends Thread {
	private Semaphore semaphore;

	public AdvancedEx4(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			// �������� ���ϱ�
			this.semaphore.acquire();

			// ��������� ǥ��
			System.out.println(Thread.currentThread().getName());

			// 5�� ���
			Thread.sleep(5000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// �������� ����
			this.semaphore.release();
		}
	}

	public static void main(String[] args) {
		// 3�� �����忡�� ���ÿ� ������ �� �ִ� �������� ����
		Semaphore semaphore = new Semaphore(3);

		// 5�� �����忡�� ���ÿ� ����
		new AdvancedEx4(semaphore).start();
		new AdvancedEx4(semaphore).start();
		new AdvancedEx4(semaphore).start();
		new AdvancedEx4(semaphore).start();
		new AdvancedEx4(semaphore).start();
		new AdvancedEx4(semaphore).start();
		new AdvancedEx4(semaphore).start();
		new AdvancedEx4(semaphore).start();
	}

}
