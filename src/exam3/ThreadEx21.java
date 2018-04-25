package exam3;

public class ThreadEx21 {
	public static void main(String[] args) {


		CalculatorNew calculator = new CalculatorNew();

		User3 User3 = new User3();
		User3.setCalculator(calculator);
		User3.start();

		User4 User4 = new User4();
		User4.setCalculator(calculator);
		User4.start();
	}
}

class User3 extends Thread {
	private CalculatorNew calculator;

	public void setCalculator(CalculatorNew calculator) {
		this.setName("User3");
		this.calculator = calculator;
	}

	public void run() {
		calculator.setMemory(100);
	}
}

class User4 extends Thread {
	private CalculatorNew calculator;

	public void setCalculator(CalculatorNew calculator) {
		this.setName("User4");
		this.calculator = calculator;
	}

	public void run() {
		calculator.setMemory(50);
	}
}

class CalculatorNew {
	private int memory;

	public int getMemory() {
		return memory;
	}
    /*
	    µø±‚»≠
	*/
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + ": " + this.memory);
	}
}
