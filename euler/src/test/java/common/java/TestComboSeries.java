package common.java;

public class TestComboSeries extends AbstractTestSeries {

	protected Series createCut() {
		return new ComboSeries(new IncrementalSeries(0, 3),
				new IncrementalSeries(0, 5));
	}

	@Override
	protected long[] getExpected() {
		return new long[] {3L, 5L, 6L, 9L, 10L, 12L, 15L, 18L, 20L, 21L};
	}
}