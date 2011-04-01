package problems.java;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import org.junit.Test;

import common.java.NumberUtils;
import common.java.Range;

public class TestProblem5 {

	@Test
	public void testProblem() {
		final Range r = new Range(1, 20);
		assertThat(NumberUtils.leastCommonMultiple(r), is(232792560L));
	}

	@Test
	public void testSampleProblem() {
		final Range r = new Range(1, 10);
		assertThat(NumberUtils.leastCommonMultiple(r), is(2520L));
	}
}