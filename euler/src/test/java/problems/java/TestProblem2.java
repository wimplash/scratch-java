package problems.java;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import common.java.EvenNumberFilterSeries;
import common.java.FibonacciSeries;
import common.java.NumberUtils;
import common.java.Series;

public class TestProblem2 {

	@Test
	public void testProblem() {
		final Series f = new FibonacciSeries();
		final Series s = new EvenNumberFilterSeries(f);
		
		int sum = 0;
		int fib1 = 1;
		int fib2 = 2;
		while (fib2 < 4000000) {
			if ((fib2 % 2) == 0) {
				sum += fib2;
			}
			int nextfib = fib1 + fib2;
			fib1 = fib2;
			fib2 = nextfib;
		}
		assertThat(NumberUtils.sumUpToValue(s, 4000000), is(4613732L));
	}
}