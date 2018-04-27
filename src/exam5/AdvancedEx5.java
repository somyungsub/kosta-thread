package exam5;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class AdvancedEx5 {
	public static void main(String[] args) {

		// 초기치=0을 지정해 AtomicInteger를 생성
		AtomicInteger i = new AtomicInteger(0);

		int result1 = i.get();
		System.out.println("result1: " + result1);

		i.set(2);

		// 값을 취득한 후 인수로 지정한 값을 설정
		int result2 = i.getAndSet(2);
		System.out.println("result2: " + result2);

		// 인수로 지정한 값을 가산해서 값을 취득함
		int result3 = i.addAndGet(3);
		System.out.println("result3: " + result3);

		// 값을 취득하고 증가시킴
		int result4 = i.getAndIncrement();
		System.out.println("result4: " + result4);

		// 증가하고 값을 취득함
		int result5 = i.incrementAndGet();
		System.out.println("result5: " + result5);

		// 값을 취득한 뒤 감소시킴
		int result6 = i.getAndDecrement();
		System.out.println("result6: " + result6);

		// 감소한 후 값을 취득함
		int result7 = i.decrementAndGet();
		System.out.println("result7: " + result7);

		// 값이 5인 경우에만 10을 설정
		if (i.compareAndSet(5, 10)) {
			System.out.println("값이 5인 경우");
		} else {
			System.out.println("값이 5가 아닌 경우");
		}

		System.out.println("결과: " + i.get());

		// LongAdder를 생성(초기값은 0)
		LongAdder longAdder = new LongAdder();

		longAdder.add(100);
		System.out.println(longAdder.longValue());
		longAdder.add(50);
		System.out.println(longAdder.longValue());

		longAdder.increment();
		System.out.println(longAdder.longValue());
		longAdder.increment();
		System.out.println(longAdder.longValue());

		longAdder.decrement();
		System.out.println(longAdder.longValue());

		long value = longAdder.longValue();
		System.out.println(value);

	}
}
