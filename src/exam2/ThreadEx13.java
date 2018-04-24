package exam2;
 class ThreadEx13 {
	public static void main(String args[]) {
		ThreadEx13_1 th1 = new ThreadEx13_1("*");
		ThreadEx13_1 th2 = new ThreadEx13_1("**");
		ThreadEx13_1 th3 = new ThreadEx13_1("***");

		th1.start();
		th2.start();
		th3.start();

		try {
			Thread.sleep(2000);
			th1.pause();		
			Thread.sleep(2000);
			th2.pause();
			Thread.sleep(5000);
			th1.restart();
			Thread.sleep(3000);
			th1.stop();
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		} catch (InterruptedException e) {}		
	}
}

class ThreadEx13_1 implements Runnable {
	 volatile boolean paused = false;
	 volatile boolean stopped   = false;

	Thread th;

	ThreadEx13_1(String name) {
		th = new Thread(this, name); // Thread(Runnable r, String name)
	}

	public void run() {
		while(!stopped) {
			if(!paused) {
                System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {}			
			}
		}
		System.out.println(Thread.currentThread().getName() + " - stopped");
	}

	public void pause() { paused = true;  }
	public void restart()  { paused = false; }
	public void stop()    { stopped   = true;  }
	public void start()   { th.start();        }
}
