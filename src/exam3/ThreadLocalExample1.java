package exam3;

import java.util.Random;

public class ThreadLocalExample1 {

	public static void main(String args[]) {
		Runnable runner = new Runnable() {
			Random random = new Random();
			int counter = 0;
			ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

			public void run() {

			    // Lock을 걸어 임계영역을 정의하겠다는 의미 (this -> Runnable 객체)
				synchronized (ThreadLocalExample1.class) {

					++counter;

					// 쓰레드 객체를 key값으로 저장 (해쉬맵 구조)
					threadLocal.set(new Integer(random.nextInt(1000)));

					// get
					displayValues("run() : " + threadLocal.get().toString() + " : " + threadLocal);
				}
				m1();
				threadLocal.remove();
			}

			/*
                m1 호출 알림 메서드
                -> 현재 객체 값 출력
			 */
			public void m1() {
				try {
					Thread.sleep(100);
					displayValues("m1() : " + threadLocal.get().toString() + " : " + threadLocal);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				m2();
			}

			/*
			    m1과 번갈아 가며 같은 행위 시작
			 */
			public void m2() {
				try {
					Thread.sleep(100);
					displayValues("m2() : " + threadLocal.get().toString() + " : " + threadLocal);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			private void displayValues(String str) {
				System.out.println(str + "\t" + Thread.currentThread().getName() + "\t(counter:" + counter + ")");
			}
		};

        /*
            5개의 객체를 각각 생성 후 Start
            -> @뒤 참조값이 동일함을 확인
            -> 하나의 로컬 쓰레드 객체가 재사용활용됨

         */
		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(runner);
			t.start();
		}
	}
}
