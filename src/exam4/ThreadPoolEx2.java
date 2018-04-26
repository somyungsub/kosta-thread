package exam4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
 
public class ThreadPoolEx2 {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = 
        		            Executors.newFixedThreadPool(2); 
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    ThreadPoolExecutor threadPoolExecutor = 
                    		         (ThreadPoolExecutor) executorService;
 
                    int poolSize = threadPoolExecutor.getPoolSize();                    
                    String threadName = Thread.currentThread().getName();
                    System.out.println("[�� ������ ����: " + poolSize + "] �۾� ������ �̸�: " + threadName+" : "+Thread.currentThread().hashCode());
                    
                   // int value = Integer.parseInt("����");
                    System.out.println("ó�� ����...");
                }
            }; 
            executorService.execute(runnable);          
            Thread.sleep(1000);
        }
       executorService.shutdown(); 
    }
}
 
