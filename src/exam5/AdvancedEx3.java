package exam5;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class AdvancedEx3 {
	public static void main(String[] args) {
		System.out.println("수행시작 : " + LocalDateTime.now());
		ScheduledJob job = new ScheduledJob();
		Timer timer= new Timer();
		timer.scheduleAtFixedRate(job, 1000, 3000);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException ex) {
			//
		}
		timer.cancel();
	}
}

class ScheduledJob extends TimerTask {

	public void run() {
		System.out.println(new Date());
	}
}
