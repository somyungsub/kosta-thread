package exam2;

public class ThreadEx12 {
	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();
		try {
			sumThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("1~100 гу: " + sumThread.getSum());
	}
}

class SumThread extends Thread {	
	private long sum;
	
	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

	public void run() {
		for(int i=1; i<=1000; i++) {
			sum+=i;
		}
	}
}