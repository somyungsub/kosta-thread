package exam2;

public class ThreadEx10 {
	public static void main(String[] args) {
		StatePrintThread statePrintThread = new StatePrintThread(new TargetThread());
		statePrintThread.start();
	}
}
class StatePrintThread extends Thread {	
	private Thread targetThread;

	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}

	public void run() {
		while(true) {
			State state = targetThread.getState();
			System.out.println("Ÿ�� ������ ����: " + state);
			if(state == State.NEW) {
				targetThread.start();
			}
			if(state == State.TERMINATED) {
				break;
			}
			try {
				//0.5�ʰ� �Ͻ� ����
				Thread.sleep(50);
			} catch(Exception e) {}
		}
	}
}

class TargetThread extends Thread {	
	public void run() {
		for(long i=0; i<1000000000; i++) {}
		
		try {
			//1.5�ʰ� �Ͻ� ����
			Thread.sleep(1500);
		} catch(Exception e) {}
		
		for(long i=0; i<1000000000; i++) {}
	}
}