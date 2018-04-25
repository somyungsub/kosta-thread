package exam3;

public class ThreadGroupExample4 {

	public static void main(String[] args) {

		ThreadGroup MsgThreads = new ThreadGroup("MsgThreads");
		ThreadGroup JmsThreads = new ThreadGroup(MsgThreads, "JMSThreads");
		ThreadGroup EmailThreads = new ThreadGroup(MsgThreads, "EmailThreads");

		MyThread mt1 = new MyThread(MsgThreads, "msgThread_1");
		MyThread jt1 = new MyThread(JmsThreads, "jmsThread_1");
		MyThread jt2 = new MyThread(JmsThreads, "jmsThread_2");
		MyThread et1 = new MyThread(EmailThreads, "emailThread_1");
		MyThread et2 = new MyThread(EmailThreads, "emailThread_2");
		MyThread et3 = new MyThread(EmailThreads, "emailThread_3");

		// startup msg thread
		mt1.start();

		// startup jms threads
		jt1.start();
		jt2.start();

		// startup email threads
		et1.start();
		et2.start();
		et3.start();

		System.out.println("MsgThreads ThreadGroup Details");
		System.out.println("ThreadGroup Name....: " + MsgThreads.getName());
		System.out.println("ThreadGroup Parent..: " + MsgThreads.getParent());
		System.out.println("Active Count........: " + MsgThreads.activeCount());
		System.out.println("Active Group Count..: " + MsgThreads.activeGroupCount());
		System.out.println("Max Priority........: " + MsgThreads.getMaxPriority());
		MsgThreads.setMaxPriority(6);
		System.out.println("Setting Group Priority to 6");
		System.out.println("Max Priority........: " + MsgThreads.getMaxPriority());

		System.out.println("\nEmail ThreadGroup Details");
		System.out.println("Attempting to set Group Priority to 8 -- should not work!!!");
		EmailThreads.setMaxPriority(8); // Will not succeed as it exceed the
										// maximum set by parent thread group
		System.out.println("ThreadGroup Name....: " + EmailThreads.getName());
		System.out.println("ThreadGroup Parent..: " + EmailThreads.getParent());
		System.out.println("Active Count........: " + EmailThreads.activeCount());
		System.out.println("Active Group Count..: " + EmailThreads.activeGroupCount());
		System.out.println("Max Priority........: " + EmailThreads.getMaxPriority());

		System.out.println("\nEmail ThreadGroup Details");
		System.out.println("Attempting to set Group Priority to 4");
		EmailThreads.setMaxPriority(4); // This will work
		System.out.println("ThreadGroup Name....: " + EmailThreads.getName());
		System.out.println("ThreadGroup Parent..: " + EmailThreads.getParent());
		System.out.println("Active Count........: " + EmailThreads.activeCount());
		System.out.println("Active Group Count..: " + EmailThreads.activeGroupCount());
		System.out.println("Max Priority........: " + EmailThreads.getMaxPriority());

		System.out.println("\nJMS ThreadGroup Details");
		System.out.println("ThreadGroup Name....: " + JmsThreads.getName());
		System.out.println("ThreadGroup Parent..: " + JmsThreads.getParent());
		System.out.println("Active Count........: " + JmsThreads.activeCount());
		System.out.println("Active Group Count..: " + JmsThreads.activeGroupCount());
		System.out.println("Max Priority........: " + JmsThreads.getMaxPriority());
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