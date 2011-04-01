package common.java;

import org.junit.Test;

public class TestEvenNumberFilterSeries extends AbstractTestSeries {

	protected Series createCut() {
		return new EvenNumberFilterSeries();
	}

	@Override
	protected long[] getExpected() {
		return new long[] {2L, 4L, 6L, 8L, 10L, 12L, 14L, 16L, 18L, 20L};
	}

	@Test
	public void testNextBy3() {
		final Series s = new EvenNumberFilterSeries(new IncrementalSeries(0, 3));
		final long[] expected = {6, 12, 18, 24, 30, 36, 42, 48, 54, 60};
		assertSeriesByNext(s, expected);
	}

	@Test
	public void testPeekBy3() {
		final Series s = new EvenNumberFilterSeries(new IncrementalSeries(0, 3));
		final long[] expected = {6, 12, 18, 24, 30, 36, 42, 48, 54, 60};
		assertSeriesByPeek(s, expected);
	}
}