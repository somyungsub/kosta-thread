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

        // 5초간 쉬는애가 끝나야 나머지도 다 나오게 끔 구현한거임! 기다림!
        System.out.println(t1.get());
        System.out.println(t2.get());
        System.out.println(t3.get());

        // 모든 작업이 종료하면 셧다운
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

        return time + "밀리초 대기후에 리턴함";
    }
}
