package exam5;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class AdvancedEx5 {
	public static void main(String[] args) {

		// �ʱ�ġ=0�� ������ AtomicInteger�� ����
		AtomicInteger i = new AtomicInteger(0);

		int result1 = i.get();
		System.out.println("result1: " + result1);

		i.set(2);

		// ���� ����� �� �μ��� ������ ���� ����
		int result2 = i.getAndSet(2);
		System.out.println("result2: " + result2);

		// �μ��� ������ ���� �����ؼ� ���� �����
		int result3 = i.addAndGet(3);
		System.out.println("result3: " + result3);

		// ���� ����ϰ� ������Ŵ
		int result4 = i.getAndIncrement();
		System.out.println("result4: " + result4);

		// �����ϰ� ���� �����
		int result5 = i.incrementAndGet();
		System.out.println("result5: " + result5);

		// ���� ����� �� ���ҽ�Ŵ
		int result6 = i.getAndDecrement();
		System.out.println("result6: " + result6);

		// ������ �� ���� �����
		int result7 = i.decrementAndGet();
		System.out.println("result7: " + result7);

		// ���� 5�� ��쿡�� 10�� ����
		if (i.compareAndSet(5, 10)) {
			System.out.println("���� 5�� ���");
		} else {
			System.out.println("���� 5�� �ƴ� ���");
		}

		System.out.println("���: " + i.get());

		// LongAdder�� ����(�ʱⰪ�� 0)
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
