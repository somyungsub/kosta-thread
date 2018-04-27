package exam4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolEx2 {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);  // 스레드풀 갯수 최대 2

        for (int i = 0; i < 10; i++) {

            // 익명클래스로 객체생성
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    //
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;

                    int poolSize = threadPoolExecutor.getPoolSize();
                    String threadName = Thread.currentThread().getName();
                    System.out.println("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름: " + threadName + " : " + Thread.currentThread().hashCode());

                    // 예외발생 시 -> 스레드를 버리고 새로 생성하여 계속 진행함 -> 쓰레드 코드로 확인
//                    int value = Integer.parseInt("숫자");

                    System.out.println("처리 종료...");
                }
            };


            /*
                런러블 객체를 스레드풀에 전달
                ->
             */
            executorService.execute(runnable);
            Thread.sleep(1000);
        }
        executorService.shutdown();
    }
}
 

