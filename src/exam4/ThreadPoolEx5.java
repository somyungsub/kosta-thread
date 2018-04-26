package exam4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolEx5 {
	public static void main(String[] args) {
		ExecutorService  executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()
		);
		
		System.out.println("[�۾� ó�� ��û]");
		Callable<Integer> task = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for(int i=1; i<=10; i++) {
					sum += i;
					try {
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName()+ " -�����");
					} catch(Exception e) {						
					}
				}
				return sum;
			}
		};
		Future<Integer> future = executorService.submit(task);
		
		try {
			int sum = future.get();
			System.out.println("[ó�� ���] " + sum);
			System.out.println("[�۾� ó�� ���� ����]");
		} catch (Exception e) {
			System.out.println("[���� ���� �߻���] " + e.getMessage());
		}
		
		executorService.shutdown();
	}
}