package exam4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolEx6 {
	public static void main(String[] args) {
		System.out.println("���� ���μ��� ���� : " + Runtime.getRuntime().availableProcessors());
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		System.out.println("[�۾� ó�� ��û]");
		class RunnableTask implements Runnable{
			MyValue result;
			RunnableTask(MyValue result) {
				this.result = result;
			}
			@Override
			public void run() {
				int sum = 0;
				for (int i = 1; i <= 10; i++) {
					sum =  sum + i;
					try {
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName() + " -�����");
					} catch (Exception e) {
					}
				}
				result.setSum(sum);
			}
		};
		MyValue result = new MyValue();
		Future<MyValue> future = executorService.submit(new RunnableTask(result), result);
		try {
			System.out.println("[ó�� ���] " + future.get());
			System.out.println("[�۾� ó�� ���� ����]");
		} catch (Exception e) {
			System.out.println("[���� ���� �߻���] " + e.getMessage());
		}

		executorService.shutdown();
	}
}

class MyValue {
	private int sum;

	public String toString() {
		return String.valueOf(sum);
	}

	public void setSum(int sum) {
		this.sum = sum;
	}	
}
