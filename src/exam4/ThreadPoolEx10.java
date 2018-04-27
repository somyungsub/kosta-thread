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

        // 3���� ����� ���������� ����
        for (int i = 0; i < 3; i++) {
            Future<String> future = service.take(); // �۾� �Ϸ�� ������ �ޱ⸦ ���ϴ� �޼��� CompletionService ��ü�� �����ߵ�
            System.out.println(future.get());
        }
        // ��� �۾��� �����ϸ� �˴ٿ�
        threadPool.shutdown();
    }
}
