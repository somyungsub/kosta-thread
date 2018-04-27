package exam4;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolEx13 {

  public static void main(String[] args) {

    // 단일 스레드에서 실행되는 ExecutorService를 생성
    ExecutorService executorService = Executors.newSingleThreadExecutor();
 
    // 태스크를 실행
    executorService.execute(new TestThread());
    executorService.execute(new TestThread());

    // 모든 작업이 종료되면 ExecutorService를 셧다운함
    executorService.shutdown();

  }

}
class TestThread extends Thread {

	  @Override
	  public void run() {
	    // 스레드 시작 시에 이름을 표시
	    System.out.println(Thread.currentThread().getName() + ": Start");

	    try {
	      // 5초 대기
	      Thread.sleep(5000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }

	    // 스리드 종료 시에 스레드명을 표시
	    System.out.println(Thread.currentThread().getName() + ": End");
	  }

	}
