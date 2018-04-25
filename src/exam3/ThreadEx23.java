package exam3;
class ThreadEx23 {
	public static void main(String args[]) {
		Runnable r = new RunnableEx22();
		new Thread(r).start();
		new Thread(r).start();
	}
}

class Account2 {
	private int balance = 1000; // private으로 해야 동기화가 의미가 있다.

	public  int getBalance() {
		return balance;
	}

	public synchronized boolean withdraw(int money){ // synchronized로 메서드를 동기화
		boolean result = false;
		if(balance >= money) {
			try { Thread.sleep(1000);} catch(InterruptedException e) {}
			balance -= money;
			result =  true;
		}
		return result;
	} 
}

class RunnableEx22 implements Runnable {
	Account2 acc = new Account2();

	public void run() {
		while(acc.getBalance() > 0) {
			int money = (int)(Math.random() * 3 + 1) * 100;
			boolean result = acc.withdraw(money);
			if (result) {
				System.out.println(Thread.currentThread().getName()+"에서 "+money +"원을 출급하여 " +acc.getBalance()+"원 남았어요.");
			} else {
				System.out.println(Thread.currentThread().getName()+"에서 "+money +"원 출급은 거부되었어요.. 잔액 : " +acc.getBalance()+"원 ");
			}
		}
	} 
}
