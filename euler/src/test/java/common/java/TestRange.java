package common.java;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class TestRange {

	@Test(expected=IllegalArgumentException.class)
	public void testConstructorValuesEqual() {
		new Range(1, 1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstructorStartGreaterThanEnd() {
		new Range(2, 1);
	}

	@Test
	public void testAsList() {
		final List<Long> expected = TestUtils.list(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L);
		final Range r = new Range(1, 10);
		assertThat(r.asList(), is(expected));
	}
}