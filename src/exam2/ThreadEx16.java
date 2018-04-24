package exam2;

public class ThreadEx16 {
	public static void main(String[] args)  {
		Thread thread = new PrintThread2();
		thread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		thread.interrupt();
	}
}

class PrintThread2 extends Thread {
	public void run() {	
		while(true) {
			System.out.println("���� ��");
			if(Thread.interrupted()) {
				break;
			}
		}		
		System.out.println("�ڿ� ����");
		System.out.println("���� ����");
	}
}

