package common.java;

public class TestSquareFilterSeries extends AbstractTestSeries {

	protected Series createCut() {
		return new SquareFilterSeries();
	}

	@Override
	protected long[] getExpected() {
		return new long[] { 1L, 4L, 9L, 16L, 25L, 36L, 49L, 64L, 81L, 100L };
	}
}