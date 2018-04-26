package exam3;

public class ThreadGroupExample4 {

	public static void main(String[] args) {

		ThreadGroup msgThreads = new ThreadGroup("msgThreads");
		ThreadGroup jmsThreads = new ThreadGroup(msgThreads, "jmsThreads");
		ThreadGroup emailThreads = new ThreadGroup(msgThreads, "emailThreads");

		MyThread mt1 = new MyThread(msgThreads, "msgThread_1");
		MyThread jt1 = new MyThread(jmsThreads, "jmsThread_1");
		MyThread jt2 = new MyThread(jmsThreads, "jmsThread_2");
		MyThread et1 = new MyThread(emailThreads, "emailThread_1");
		MyThread et2 = new MyThread(emailThreads, "emailThread_2");
		MyThread et3 = new MyThread(emailThreads, "emailThread_3");

		// startup msg thread
		mt1.start();

		// startup jms threads
		jt1.start();
		jt2.start();

		// startup email threads
		et1.start();
		et2.start();
		et3.start();

		System.out.println("msgThreads ThreadGroup Details");
		System.out.println("ThreadGroup Name....: " + msgThreads.getName());
		System.out.println("ThreadGroup Parent..: " + msgThreads.getParent());
		System.out.println("Active Count........: " + msgThreads.activeCount());
		System.out.println("Active Group Count..: " + msgThreads.activeGroupCount());
		System.out.println("Max Priority........: " + msgThreads.getMaxPriority());
		msgThreads.setMaxPriority(6);
		System.out.println("Setting Group Priority to 6");
		System.out.println("Max Priority........: " + msgThreads.getMaxPriority());

		System.out.println("\nEmail ThreadGroup Details");
		System.out.println("Attempting to set Group Priority to 8 -- should not work!!!");
		emailThreads.setMaxPriority(8); // Will not succeed as it exceed the
										// maximum set by parent thread group
		System.out.println("ThreadGroup Name....: " + emailThreads.getName());
		System.out.println("ThreadGroup Parent..: " + emailThreads.getParent());
		System.out.println("Active Count........: " + emailThreads.activeCount());
		System.out.println("Active Group Count..: " + emailThreads.activeGroupCount());
		System.out.println("Max Priority........: " + emailThreads.getMaxPriority());

		System.out.println("\nEmail ThreadGroup Details");
		System.out.println("Attempting to set Group Priority to 4");
		emailThreads.setMaxPriority(4); // This will work
		System.out.println("ThreadGroup Name....: " + emailThreads.getName());
		System.out.println("ThreadGroup Parent..: " + emailThreads.getParent());
		System.out.println("Active Count........: " + emailThreads.activeCount());
		System.out.println("Active Group Count..: " + emailThreads.activeGroupCount());
		System.out.println("Max Priority........: " + emailThreads.getMaxPriority());

		System.out.println("\nJMS ThreadGroup Details");
		System.out.println("ThreadGroup Name....: " + jmsThreads.getName());
		System.out.println("ThreadGroup Parent..: " + jmsThreads.getParent());
		System.out.println("Active Count........: " + jmsThreads.activeCount());
		System.out.println("Active Group Count..: " + jmsThreads.activeGroupCount());
		System.out.println("Max Priority........: " + jmsThreads.getMaxPriority());
	}
}

 class MyThread extends Thread {
	private int counter = 0;

	MyThread(String name) {
		super(name);
		System.out.println("Creating Thread: " + name);
	}

	MyThread(ThreadGroup group, String name) {
		super(group, name);
	}

	@Override
	public void run() {
		while (counter < 10) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}