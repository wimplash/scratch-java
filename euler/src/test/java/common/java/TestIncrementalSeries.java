package common.java;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


import org.junit.Test;

import common.java.IncrementalSeries;
import common.java.Series;

public class TestIncrementalSeries extends AbstractTestSeries {

	protected Series createCut() {
		return new IncrementalSeries();
	}

	@Override
	protected long[] getExpected() {
		return new long[] {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L};
	}

	@Test
	public void testNextBy3() {
		final Series s = new IncrementalSeries(0, 3);
		final long[] expected = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30};
		assertSeriesByNext(s, expected);
	}

	@Test
	public void testPeekBy3() {
		final Series s = new IncrementalSeries(0, 3);
		final long[] expected = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30};
		assertSeriesByPeek(s, expected);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstructorNegativeIncrement() {
		new IncrementalSeries(0, -1);
	}

	@Test
	public void testNextNegativeBase() {
		final Series s = new IncrementalSeries(-1);
		assertThat(s.next(), is(0L));
	}
}