package exam3;

import java.util.Collections;

public class ThreadEx20 {
	public static void main(String[] args) {

//        Collections.syschroXXX()  // 동기화추가
        Calculator calculator = new Calculator();

		User1 user1 = new User1();
		user1.setCalculator(calculator);
		user1.start();

		User2 user2 = new User2();
		user2.setCalculator(calculator);
		user2.start();
	}
}

class User1 extends Thread {
	private Calculator calculator;

	public void setCalculator(Calculator calculator) {
		this.setName("User1");
		this.calculator = calculator;
	}

	public void run() {
		calculator.setMemory(100);
	}
}

class User2 extends Thread {
	private Calculator calculator;

	public void setCalculator(Calculator calculator) {
		this.setName("User2");
		this.calculator = calculator;
	}

	public void run() {
		calculator.setMemory(50);
	}
}

class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + ": " + this.memory);
	}
}