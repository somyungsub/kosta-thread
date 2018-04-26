package exam4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx1 {
    public static void main(String[] args) throws Exception {
        ExecutorService fixedPool = Executors.newFixedThreadPool(10);
        System.out.println(fixedPool.getClass().getName()); // 리턴 된 객체의 클래스 이름 확인 (ThreadPoolExecutor)

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
        System.out.println("pool 크기 : " + fixedPoolExecutor.getPoolSize());
        System.out.println("최대 pool 크기 : " + fixedPoolExecutor.getMaximumPoolSize());
        System.out.println("코어 pool 크기 : " + fixedPoolExecutor.getCorePoolSize());
        System.out.println("수행중인 스레드 갯수 : " + fixedPoolExecutor.getActiveCount());
        System.out.println("유휴 유지시간 : " + fixedPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS));
        System.out.println("[ Cached Pool ]");
        System.out.println("pool 크기 : " + cachedPoolExecutor.getPoolSize());
        System.out.println("최대 pool 크기 : " + cachedPoolExecutor.getMaximumPoolSize());
        System.out.println("코어 pool 크기 : " + cachedPoolExecutor.getCorePoolSize());
        System.out.println("수행중인 스레드 갯수 : " + cachedPoolExecutor.getActiveCount());
        System.out.println("유휴 유지시간 : " + cachedPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS));
        System.out.println("[ My Pool ]");
        System.out.println("pool 크기 : " + myPoolExecutor.getPoolSize());
        System.out.println("최대 pool 크기 : " + myPoolExecutor.getMaximumPoolSize());
        System.out.println("코어 pool 크기 : " + myPoolExecutor.getCorePoolSize());
        System.out.println("수행중인 스레드 갯수 : " + myPoolExecutor.getActiveCount());
        System.out.println("유휴 유지시간 : " + myPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS));

    }
}
 

