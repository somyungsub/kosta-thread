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

    // java.util.Date�� ������ �۾��� ����
    Future<Date> future = executorService.submit(new Callable<Date>(){
      @Override
      public Date call() throws Exception {
        Thread.sleep(5000);
        return new Date();
      }
    });

    // ����� ����(�۾� ������ �Ϸ�Ǳ���� ���ŷ ��)��
    Date date = future.get();
    System.out.println(date);

    // ��� �۾��� �����ϸ� �˴ٿ�
    executorService.shutdown();

  }

}
