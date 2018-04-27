package exam5;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class AdvancedEx1 {
	public static void main(String[] args) {
		System.out.println("수행시작 : "+ LocalDateTime.now());

        /*
            Timer
            -> 싱글쓰레드 모델
            -> 스케쥴
         */
        Timer timer = new Timer();

        // 타이머를 기동할 시간
		Calendar cal = Calendar.getInstance();
		cal.set(2018, Calendar.APRIL, 27, 21, 28);
		timer.schedule(new SampleTask(timer), cal.getTime());

		timer = new Timer();

		// 1분 후에 한 번만 실행
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

			System.out.println("타이머를 사용한 처리 : "+ LocalDateTime.now());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 파기(해제)
		timer.cancel();
	}

}
