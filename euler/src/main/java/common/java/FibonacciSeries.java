package common.java;

public class FibonacciSeries extends InfiniteSeries {
	private long index = 0;
	private long fib1 = 1;
	private long fib2 = 2;
	
	@Override
	public long next() {
		index++;
		if (index == 1) {
			return 1;
		} else if (index == 2) {
			return 2;
		} else {
			final long nextFib = fib1 + fib2;
			fib1 = fib2;
			fib2 = nextFib;
			return fib2;
		}
	}

	@Override
	public long peek(final int elementsAhead) {
		if (elementsAhead <= 0) {
			throw new IllegalArgumentException("cannot peek back");
		}
		return fib(index + elementsAhead);
	}

	private long fib(final long element) {
		if (element == 1) {
			return 1;
		} else if (element == 2) {
			return 2;
		} else if (element == index - 1) {
			return fib1;
		} else if (element == index) {
			return fib2;
		} else if (element == index + 1) {
			return fib1 + fib2;
		} else {
			return fib(element - 1) + fib(element - 2);
		}
	}
}