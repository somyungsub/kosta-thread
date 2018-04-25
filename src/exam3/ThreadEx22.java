package exam3;

import java.util.concurrent.atomic.AtomicInteger;

class ThreadEx22 {
	public static void main(String args[]) {
		Runnable r = new RunnableEx21();
		new Thread(r).start(); 
		new Thread(r).start(); 
	}
}

class Account {
	//private int balance = 1000;
	private AtomicInteger balance = new AtomicInteger(1000);

	public  int getBalance() {
		return balance.get();
	}

	public boolean withdraw(int money){
		boolean result = false;
		if(balance.get() >= money) {
			try { Thread.sleep(1000);} catch(InterruptedException e) {}
			//balance -= money;
			balance.set(getBalance()-money);
			result =  true;
		}
		return result;
	} 
}

class RunnableEx21 implements Runnable {
	Account acc = new Account();

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
	} // run()
}
