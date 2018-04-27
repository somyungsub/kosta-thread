package exam4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx12 {
    public static void main(String[] args) throws Exception {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        fixedThreadPool.execute(new TestThread1());
        fixedThreadPool.execute(new TestThread1());
        fixedThreadPool.shutdown();

        while (!fixedThreadPool.isTerminated()) ;

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(new TestThread1());
        cachedThreadPool.execute(new TestThread1());
        cachedThreadPool.shutdown();

        while (!cachedThreadPool.isTerminated()) ;

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);    // �����층 �Ͽ� task

        // schedule�� ���� ���� ��û��
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": Start");
                System.out.println("Executed");
                System.out.println(Thread.currentThread().getName() + ": End");
            }
        }, 3, TimeUnit.SECONDS);    // 3���� �����Ű�� ������ (TimeUnit : �ð�����)

        // task ���� ���� �� ������
        scheduledThreadPool.shutdown();
    }
}

class TestThread1 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Start");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": End");
    }
}
