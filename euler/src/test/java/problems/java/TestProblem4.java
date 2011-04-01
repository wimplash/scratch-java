package problems.java;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TestProblem4 {

	@Test
	public void testSampleProblem() {
		final Problem4 p = new Problem4(10, 99);
		assertThat(p.findLargestPalindrome(), is(9009L));
	}

	@Test
	public void testProblem() {
		final Problem4 p = new Problem4(100, 999);
		assertThat(p.findLargestPalindrome(), is(906609L));
	}
}