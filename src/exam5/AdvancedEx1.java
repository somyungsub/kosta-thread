package exam5;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class AdvancedEx1 {
	public static void main(String[] args) {
		System.out.println("������� : "+ LocalDateTime.now());

        /*
            Timer
            -> �̱۾����� ��
            -> ������
         */
        Timer timer = new Timer();

        // Ÿ�̸Ӹ� �⵿�� �ð�
		Calendar cal = Calendar.getInstance();
		cal.set(2018, Calendar.APRIL, 27, 21, 28);
		timer.schedule(new SampleTask(timer), cal.getTime());

		timer = new Timer();

		// 1�� �Ŀ� �� ���� ����
		timer.schedule(new SampleTask(timer), TimeUnit.MINUTES.toMillis(1));
	}
}
class SampleTask extends TimerTask {
	private Timer timer;
	public SampleTask(Timer timer) {
		this.timer = timer;
	}
	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(2);
			System.out.println(Thread.currentThread().getName());

			System.out.println("Ÿ�̸Ӹ� ����� ó�� : "+ LocalDateTime.now());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// �ı�(����)
		timer.cancel();
	}

}
