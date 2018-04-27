package exam4;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolEx9 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        Future<String> t1 = threadPool.submit(new WaitTask(5000));
        Future<String> t2 = threadPool.submit(new WaitTask(3000));
        Future<String> t3 = threadPool.submit(new WaitTask(1000));

        // 5�ʰ� ���¾ְ� ������ �������� �� ������ �� �����Ѱ���! ��ٸ�!
        System.out.println(t1.get());
        System.out.println(t2.get());
        System.out.println(t3.get());

        // ��� �۾��� �����ϸ� �˴ٿ�
        threadPool.shutdown();

    }
}

class WaitTask implements Callable<String> {

    private long time;

    public WaitTask(long time) {
        this.time = time;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(this.time);

        return time + "�и��� ����Ŀ� ������";
    }
}
