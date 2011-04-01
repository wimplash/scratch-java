package common.java;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TestNumberUtils {

	@Test
	public void testAccumulateCommonFactors20And8() {
		final Map<Long, Long> expected = new HashMap<Long, Long>();
		expected.put(2L, 3L);
		expected.put(5L, 1L);
	
		final HashMap<Long, Long> commonFactors = new HashMap<Long, Long>();
		commonFactors.put(2L, 2L);
		commonFactors.put(5L, 1L);
	
		NumberUtils.accumulateCommonFactors(8, commonFactors);
		assertThat(commonFactors, is(expected));
	}

	@Test
	public void testAccumulateCommonFactors8And20() {
		final Map<Long, Long> expected = new HashMap<Long, Long>();
		expected.put(2L, 3L);
		expected.put(5L, 1L);
	
		final HashMap<Long, Long> commonFactors = new HashMap<Long, Long>();
		commonFactors.put(2L, 3L);
	
		NumberUtils.accumulateCommonFactors(20, commonFactors);
		assertThat(commonFactors, is(expected));
	}

	@Test
	public void testDistribution2() {
		final Map<Long, Long> expected = new HashMap<Long, Long>();
		expected.put(2L, 1L);
		assertThat(NumberUtils.distribution(TestUtils.list(2L)), is(expected));
	}

	@Test
	public void testDistribution20() {
		final Map<Long, Long> expected = new HashMap<Long, Long>();
		expected.put(2L, 2L);
		expected.put(5L, 1L);
		assertThat(NumberUtils.distribution(TestUtils.list(2L, 2L, 5L)), is(expected));
	}

	@Test
	public void testDistribution4() {
		final Map<Long, Long> expected = new HashMap<Long, Long>();
		expected.put(2L, 2L);
		assertThat(NumberUtils.distribution(TestUtils.list(2L, 2L)), is(expected));
	}

	@Test
	public void testFlattenDistribution0() {
		final Map<Long, Long> input = new HashMap<Long, Long>();
		assertThat(NumberUtils.flattenDistribution(input), is(TestUtils.list()));
	}

	@Test
	public void testFlattenDistribution1() {
		final Map<Long, Long> input = new HashMap<Long, Long>();
		input.put(1L, 1L);
		assertThat(NumberUtils.flattenDistribution(input), is(TestUtils.list(1L)));
	}

	@Test
	public void testFlattenDistribution2() {
		final Map<Long, Long> input = new HashMap<Long, Long>();
		input.put(2L, 1L);
		assertThat(NumberUtils.flattenDistribution(input), is(TestUtils.list(2L)));
	}

	@Test
	public void testFlattenDistribution20() {
		final Map<Long, Long> input = new HashMap<Long, Long>();
		input.put(2L, 2L);
		input.put(5L, 1L);
		assertThat(NumberUtils.flattenDistribution(input), is(TestUtils.list(2L, 2L, 5L)));
	}

	@Test
	public void testFlattenDistribution8() {
		final Map<Long, Long> input = new HashMap<Long, Long>();
		input.put(2L, 3L);
		assertThat(NumberUtils.flattenDistribution(input), is(TestUtils.list(2L, 2L, 2L)));
	}

	@Test
	public void testIsEven0() {
		assertThat(NumberUtils.isEven(0L), is(true));
	}

	@Test
	public void testIsEven1() {
		assertThat(NumberUtils.isEven(1L), is(false));
	}

	@Test
	public void testIsEven2() {
		assertThat(NumberUtils.isEven(2L), is(true));
	}

	@Test
	public void testIsOdd() {
		assertThat(NumberUtils.isOdd(0L), is(false));
	}

	@Test
	public void testIsOdd1() {
		assertThat(NumberUtils.isOdd(1L), is(true));
	}

	@Test
	public void testIsOdd2() {
		assertThat(NumberUtils.isOdd(2L), is(false));
	}

	@Test
	public void testIsPalindrome1000() {
		assertThat(NumberUtils.isPalindrome(1000L), is(false));
	}

	@Test
	public void testIsPalindrome1001() {
		assertThat(NumberUtils.isPalindrome(1001L), is(true));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testIsPrime0() {
		NumberUtils.isPrime(0L);
	}

	@Test
	public void testIsPrime1() {
		assertThat(NumberUtils.isPrime(1L), is(false));
	}

	@Test
	public void testIsPrime10() {
		assertThat(NumberUtils.isPrime(10L), is(false));
	}

	@Test
	public void testIsPrime11() {
		assertThat(NumberUtils.isPrime(11L), is(true));
	}

	@Test
	public void testIsPrime2() {
		assertThat(NumberUtils.isPrime(2L), is(true));
	}

	@Test
	public void testIsPrime4() {
		assertThat(NumberUtils.isPrime(4L), is(false));
	}

	@Test
	public void testLeastCommonMultipleList() {
		final List<Long> input = TestUtils.list(2L, 3L, 4L, 6L);
		assertThat(NumberUtils.leastCommonMultiple(input), is(12L));
	}

	@Test
	public void testLeastCommonMultipleRange() {
		final Range input = new Range(1, 5);
		assertThat(NumberUtils.leastCommonMultiple(input), is(60L));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testPrimeFactorsFor0() {
		NumberUtils.primeFactors(0L);
	}

	@Test
	public void testPrimeFactorsFor1() {
		assertThat(NumberUtils.primeFactors(1L), is(TestUtils.list()));
	}

	@Test
	public void testPrimeFactorsFor13195() {
		assertThat(NumberUtils.primeFactors(13195L), is(TestUtils.list(5L, 7L, 13L, 29L)));
	}

	@Test
	public void testPrimeFactorsFor2() {
		assertThat(NumberUtils.primeFactors(2L), is(TestUtils.list(2L)));
	}

	@Test
	public void testPrimeFactorsFor3() {
		assertThat(NumberUtils.primeFactors(3L), is(TestUtils.list(3L)));
	}

	@Test
	public void testPrimeFactorsFor4() {
		assertThat(NumberUtils.primeFactors(4L), is(TestUtils.list(2L, 2L)));
	}

	@Test
	public void testPrimeFactorsFor8() {
		assertThat(NumberUtils.primeFactors(8L), is(TestUtils.list(2L, 2L, 2L)));
	}

	@Test
	public void testProductList() {
		assertThat(NumberUtils.product(TestUtils.list(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L)), is(3628800L));
	}

	@Test
	public void testProductRange() {
		assertThat(NumberUtils.product(new Range(1L, 10L)), is(3628800L));
	}

	@Test
	public void testProductUpToElement10By1() {
		assertThat(NumberUtils.productUpToElement(10L), is(3628800L));
	}

	@Test
	public void testProductUpToElement10By3() {
		assertThat(NumberUtils.productUpToElement(new IncrementalSeries(0, 3), 10L), is(214277011200L));
	}

	@Test
	public void testProductUpToValue1000By1() {
		assertThat(NumberUtils.productUpToValue(10L), is(362880L));
	}

	@Test
	public void testProductUpToValue1000By3() {
		assertThat(NumberUtils.productUpToValue(new IncrementalSeries(0, 3), 10L), is(162L));
	}

	@Test
	public void testReverseNumber() {
		assertThat(NumberUtils.reverse(123456789L), is(987654321L));
	}

	@Test
	public void testReverseNumberWithTrailingZero() {
		assertThat(NumberUtils.reverse(1234567890L), is(987654321L));
	}

	@Test
	public void testSumList() {
		assertThat(NumberUtils.sum(TestUtils.list(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L)), is(55L));
	}

	@Test
	public void testSumRange() {
		assertThat(NumberUtils.sum(new Range(1L, 10L)), is(55L));
	}

	@Test
	public void testSumUpToElement1000By1() {
		assertThat(NumberUtils.sumUpToElement(1000L), is(500500L));
	}

	@Test
	public void testSumUpToElement1000By3() {
		assertThat(NumberUtils.sumUpToElement(new IncrementalSeries(0, 3), 1000L), is(1501500L));
	}

	@Test
	public void testSumUpToValue1000By1() {
		assertThat(NumberUtils.sumUpToValue(1000L), is(499500L));
	}

	@Test
	public void testSumUpToValue1000By3() {
		assertThat(NumberUtils.sumUpToValue(new IncrementalSeries(0, 3), 1000L), is(166833L));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetMaxValueNull() {
		NumberUtils.getMaxValue(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetMaxValueEmpty() {
		NumberUtils.getMaxValue(TestUtils.list());
	}

	@Test
	public void testGetMaxValue() {
		final List<Long> input = TestUtils.list(2L, 3L, 5L, 8L);
		assertThat(NumberUtils.getMaxValue(input), is(8L));
	}
}