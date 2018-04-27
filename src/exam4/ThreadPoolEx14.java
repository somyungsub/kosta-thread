package exam4;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolEx14 {

  public static void main(String[] args) throws InterruptedException, ExecutionException {

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    // java.util.Date를 전달한 작업을 실행
    Future<Date> future = executorService.submit(new Callable<Date>(){
      @Override
      public Date call() throws Exception {
        Thread.sleep(5000);
        return new Date();
      }
    });

    // 결과를 구함(작업 실행이 완료되기까지 블로킹 됨)）
    Date date = future.get();
    System.out.println(date);

    // 모든 작업이 종료하면 셧다운
    executorService.shutdown();

  }

}
