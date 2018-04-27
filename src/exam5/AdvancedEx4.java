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
			// 세마포어 구하기
			this.semaphore.acquire();

			// 스레드명을 표시
			System.out.println(Thread.currentThread().getName());

			// 5초 대기
			Thread.sleep(5000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// 세마포어 해제
			this.semaphore.release();
		}
	}

	public static void main(String[] args) {
		// 3개 스레드에서 동시에 실행할 수 있는 세마포어 생성
		Semaphore semaphore = new Semaphore(3);

		// 5개 스레드에서 동시에 시작
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
