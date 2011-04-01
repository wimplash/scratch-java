package problems.java;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import common.java.ComboSeries;
import common.java.IncrementalSeries;
import common.java.NumberUtils;
import common.java.Series;

public class TestProblem1 {

	@Test
	public void testProblem() {
		final Series iter2 = new IncrementalSeries(0, 5);
		final Series iter1 = new IncrementalSeries(0, 3);
		final ComboSeries combo = new ComboSeries(iter1, iter2);
		
		long sum = 0;
		for (int i = 0; i < 1000; i++) {
			if (((i % 3) == 0) || ((i % 5) == 0)) {
				sum += i;
			}
		}
		assertThat(NumberUtils.sumUpToValue(combo, 1000L), is(sum));
	}
}