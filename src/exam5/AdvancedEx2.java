package exam5;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class AdvancedEx2 {

	public static void main(String[] args) throws InterruptedException {
		// ���� �����忡�� ����
		Timer timer = new Timer(true);

		Calendar cal = Calendar.getInstance();
		cal.set(2018, Calendar.APRIL, 27,21, 25);

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(2);
					System.out.println("�ݺ� Ÿ�̸�" + new Date());
				} catch (Exception e) {e.printStackTrace();}
			}
		}, cal.getTime(), TimeUnit.SECONDS.toMillis(3));

		TimeUnit.MINUTES.sleep(2);

	}

}
