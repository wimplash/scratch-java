package problems.java;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import common.java.NumberUtils;
import common.java.Series;
import common.java.SquareFilterSeries;

public class TestProblem6 {

	@Test
	public void testProblem() {
		final Series series1 = new SquareFilterSeries();
		final long sumOfSquares = NumberUtils.sumUpToElement(series1, 100L);
		assertThat(sumOfSquares, is(338350L));

		final long sum = NumberUtils.sumUpToElement(100L);
		final long squaredSum = sum * sum;
		assertThat(squaredSum, is(25502500L));

		final long difference = squaredSum - sumOfSquares;
		assertThat(difference, is(25164150L));
	}
}