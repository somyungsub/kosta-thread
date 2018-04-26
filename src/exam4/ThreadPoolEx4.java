package exam4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolEx4 {
	public static void main(String[] args) {
		System.out.println("가용 프로세서 개수 : " + Runtime.getRuntime().availableProcessors());
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		System.out.println("[작업 처리 요청]");
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				int sum = 0;
				for (int i = 1; i <= 10; i++) {
					sum += i;
					try {
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName()+ " -계산중");
					} catch (Exception e) {
					}
				}

				System.out.println("[처리 결과] " + sum);
			}
		};
		Future<?> future = executorService.submit(runnable);
		try {
			if (future.get() == null) {
				System.out.println("[작업 처리 정상 종료]");
			}
		} catch (Exception e) {
			System.out.println("[실행 예외 발생함] " + e.getMessage());
		}

		executorService.shutdown();
	}
}
