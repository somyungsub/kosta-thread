package exam4;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolEx13 {

  public static void main(String[] args) {

    // ���� �����忡�� ����Ǵ� ExecutorService�� ����
    ExecutorService executorService = Executors.newSingleThreadExecutor();
 
    // �½�ũ�� ����
    executorService.execute(new TestThread());
    executorService.execute(new TestThread());

    // ��� �۾��� ����Ǹ� ExecutorService�� �˴ٿ���
    executorService.shutdown();

  }

}
class TestThread extends Thread {

	  @Override
	  public void run() {
	    // ������ ���� �ÿ� �̸��� ǥ��
	    System.out.println(Thread.currentThread().getName() + ": Start");

	    try {
	      // 5�� ���
	      Thread.sleep(5000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }

	    // ������ ���� �ÿ� ��������� ǥ��
	    System.out.println(Thread.currentThread().getName() + ": End");
	  }

	}
