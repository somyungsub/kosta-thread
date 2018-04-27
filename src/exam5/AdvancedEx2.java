package exam5;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class AdvancedEx2 {

	public static void main(String[] args) throws InterruptedException {
		// 데몬 스레드에서 실행
		Timer timer = new Timer(true);

		Calendar cal = Calendar.getInstance();
		cal.set(2018, Calendar.APRIL, 27,21, 25);

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(2);
					System.out.println("반복 타이머" + new Date());
				} catch (Exception e) {e.printStackTrace();}
			}
		}, cal.getTime(), TimeUnit.SECONDS.toMillis(3));

		TimeUnit.MINUTES.sleep(2);

	}

}
