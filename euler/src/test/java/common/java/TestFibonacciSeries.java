package common.java;

public class TestFibonacciSeries extends AbstractTestSeries {

	protected Series createCut() {
		return new FibonacciSeries();
	}

	@Override
	protected long[] getExpected() {
		return new long[] {1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L, 89L, 144L, 233L};
	}
}