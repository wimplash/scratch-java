package common.java;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public abstract class AbstractTestSeries {
	
	private Series cut;

	protected void assertSeriesByNext() {
		assertSeriesByNext(getCut(), getExpected());
	}

	protected void assertSeriesByNext(final Series producer, final long[] expected) {
		final long[] actual = producer.take(expected.length);
		assertThat(actual, is(expected));
	}

	protected void assertSeriesByPeek() {
		assertSeriesByPeek(getCut(), getExpected());
	}

	protected void assertSeriesByPeek(final Series producer, final long[] expected) {
		for (int i = 0; i < expected.length; i++) {
			assertThat(producer.peek(i+1), is(expected[i]));
		}
	}

	protected abstract Series createCut();
	
	protected Series getCut() {
		return cut;
	}
	
	protected abstract long[] getExpected();

	@Before
	public void setUp() {
		cut = createCut();
	}

	@Test
	public void testGenericNext() {
		assertSeriesByNext();
	}

	@Test
	public void testGenericPeekInt() {
		assertSeriesByPeek();
	}

	@Test
	public void testPeek() {
		assertThat(getCut().peek(), is(getCut().next()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPeekNegative() {
		getCut().peek(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPeekZero() {
		getCut().peek(0);
	}

	@Test
	public void testTake() {
		final long[] expected = new long[20];
		for (int i = 0; i < expected.length; i++) {
			expected[i] = getCut().peek(i + 1);
		}
		assertThat(getCut().take(expected.length), is(expected));
	}
}