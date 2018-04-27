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
        
        System.out.println("ó�� ��û");
        Future<Integer> future = executorService.submit(callTask);

        // �� �κ��� ������� ������ ��ٸ� x
       executorService.submit(new Runnable() {
           public void run()  {
        	   try {
        		   System.out.println("ó�� ���: " + future.get());            
        	   } catch (Exception e) {
        		   System.out.println("�����߻�");
        	   }
            }
       });     
 
        try {  
        	for (int i = 1; i <= 3; i++) {
        		Thread.sleep(1000);
        		System.out.println("���� �������� ��� ����");
        	} 
       	} catch (InterruptedException e) {}
        executorService.shutdown();
    }
}

