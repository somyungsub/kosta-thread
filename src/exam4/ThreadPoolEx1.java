package exam4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx1 {
    public static void main(String[] args) throws Exception {
        ExecutorService fixedPool = Executors.newFixedThreadPool(10);
        System.out.println(fixedPool.getClass().getName()); // ���� �� ��ü�� Ŭ���� �̸� Ȯ�� (ThreadPoolExecutor)

        ExecutorService cachedPool = Executors.newCachedThreadPool();
        System.out.println(cachedPool.getClass().getName());

        ExecutorService myPool = new ThreadPoolExecutor(3, 100, 120L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

        ThreadPoolExecutor fixedPoolExecutor =
                (ThreadPoolExecutor) fixedPool;
        ThreadPoolExecutor cachedPoolExecutor =
                (ThreadPoolExecutor) cachedPool;
        ThreadPoolExecutor myPoolExecutor =
                (ThreadPoolExecutor) myPool;
        System.out.println("[ Fixed Pool ]");
        System.out.println("pool ũ�� : " + fixedPoolExecutor.getPoolSize());
        System.out.println("�ִ� pool ũ�� : " + fixedPoolExecutor.getMaximumPoolSize());
        System.out.println("�ھ� pool ũ�� : " + fixedPoolExecutor.getCorePoolSize());
        System.out.println("�������� ������ ���� : " + fixedPoolExecutor.getActiveCount());
        System.out.println("���� �����ð� : " + fixedPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS));
        System.out.println("[ Cached Pool ]");
        System.out.println("pool ũ�� : " + cachedPoolExecutor.getPoolSize());
        System.out.println("�ִ� pool ũ�� : " + cachedPoolExecutor.getMaximumPoolSize());
        System.out.println("�ھ� pool ũ�� : " + cachedPoolExecutor.getCorePoolSize());
        System.out.println("�������� ������ ���� : " + cachedPoolExecutor.getActiveCount());
        System.out.println("���� �����ð� : " + cachedPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS));
        System.out.println("[ My Pool ]");
        System.out.println("pool ũ�� : " + myPoolExecutor.getPoolSize());
        System.out.println("�ִ� pool ũ�� : " + myPoolExecutor.getMaximumPoolSize());
        System.out.println("�ھ� pool ũ�� : " + myPoolExecutor.getCorePoolSize());
        System.out.println("�������� ������ ���� : " + myPoolExecutor.getActiveCount());
        System.out.println("���� �����ð� : " + myPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS));

    }
}
 

