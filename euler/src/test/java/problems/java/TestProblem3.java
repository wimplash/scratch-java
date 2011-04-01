package problems.java;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import common.java.NumberUtils;

public class TestProblem3 {
	@Test
	public void testProblem() {
		final List<Long> expected = new ArrayList<Long>();
		expected.add(71L);
		expected.add(839L);
		expected.add(1471L);
		expected.add(6857L);

		final List<Long> actual = NumberUtils.primeFactors(600851475143L);
		assertThat(actual, is(expected));
	}
}