package exam4;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolEx8 {
	public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
        );
        
        Callable<Integer> callTask = new Callable<Integer>() {
            public Integer call() throws Exception {
                int sum = 0;              
                for (int i = 1; i <= 20; i++) {
                	 Thread.sleep(300);
                    sum += i;
                }                
                return sum;
            }
        };
        
        System.out.println("처리 요청");
        Future<Integer> future = executorService.submit(callTask);

        // 이 부분을 런러블로 구현시 기다림 x
       executorService.submit(new Runnable() {
           public void run()  {
        	   try {
        		   System.out.println("처리 결과: " + future.get());            
        	   } catch (Exception e) {
        		   System.out.println("오류발생");
        	   }
            }
       });     
 
        try {  
        	for (int i = 1; i <= 3; i++) {
        		Thread.sleep(1000);
        		System.out.println("메인 스레드의 기능 수행");
        	} 
       	} catch (InterruptedException e) {}
        executorService.shutdown();
    }
}

