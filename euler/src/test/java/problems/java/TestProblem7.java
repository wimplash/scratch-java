package problems.java;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import common.java.PrimeSeries;
import common.java.Series;

public class TestProblem7 {

	@Test
	public void testProblem() {
		final Series s = new PrimeSeries();
		assertThat(s.peek(10001), is(104743L));
	}

	@Test
	public void testSampleProblem() {
		final Series s = new PrimeSeries();
		assertThat(s.peek(6), is(13L));
	}
}