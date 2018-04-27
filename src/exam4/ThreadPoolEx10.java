package exam4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolEx10 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ExecutorCompletionService<String> service = new ExecutorCompletionService<>(threadPool);

        service.submit(new WaitTask(5000));
        service.submit(new WaitTask(3000));
        service.submit(new WaitTask(1000));

        // 3개의 결과를 받을때까지 루프
        for (int i = 0; i < 3; i++) {
            Future<String> future = service.take(); // 작업 완료된 순서로 받기를 원하는 메서드 CompletionService 객체를 만들어야됨
            System.out.println(future.get());
        }
        // 모든 작업이 종료하면 셧다운
        threadPool.shutdown();
    }
}
