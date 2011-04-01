package common.java;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class TestPrimeSeries extends AbstractTestSeries {

	protected Series createCut() {
		return new PrimeSeries();
	}

	@Override
	protected long[] getExpected() {
		return new long[] {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L};
	}

	@Test
	public void testGetMaxPrime() {
		final PrimeSeries s = new PrimeSeries();
		final List<Long> input = TestUtils.list(2L, 3L, 5L, 7L);
		assertThat(s.getMaxPrime(input), is(7L));
	}

	@Test
	public void testGetMaxPrimeEmpty() {
		final PrimeSeries s = new PrimeSeries();
		assertThat(s.getMaxPrime(TestUtils.list()), is(1L));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetMaxPrimeNull() {
		new PrimeSeries().getMaxPrime(null);
	}

	@Test
	public void testSieveList() {
		final List<Long> expected = TestUtils.list(2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L);
		final PrimeSeries s = new PrimeSeries();
		final List<Long> input = new Range(2L, 30L).asList();
		assertThat(s.sieve(input), is(expected));
	}

	@Test
	public void testSieveListEmptyCandidates() {
		final List<Long> expected = TestUtils.list();
		final PrimeSeries s = new PrimeSeries();
		final List<Long> input = TestUtils.list();
		assertThat(s.sieve(input), is(expected));
	}

	@Test
	public void testSieveListList() {
		final List<Long> expected = TestUtils.list(3L, 5L);
		final List<Long> inputPrimes = TestUtils.list(2L);
		final List<Long> inputCandidates = TestUtils.list(2L, 3L, 4L, 5L);
		final PrimeSeries s = new PrimeSeries();
		assertThat(s.sieve(inputPrimes, inputCandidates), is(expected));
	}

	@Test
	public void testSieveListListEmptyCandidates() {
		final List<Long> expected = TestUtils.list();
		final List<Long> inputPrimes = TestUtils.list(2L, 3L, 5L);
		final List<Long> inputCandidates = TestUtils.list();
		final PrimeSeries s = new PrimeSeries();
		assertThat(s.sieve(inputPrimes, inputCandidates), is(expected));
	}

	@Test
	public void testSieveListListEmptyPrimes() {
		final List<Long> expected = TestUtils.list(2L, 3L, 4L, 5L);
		final List<Long> inputPrimes = TestUtils.list();
		final List<Long> inputCandidates = TestUtils.list(2L, 3L, 4L, 5L);
		final PrimeSeries s = new PrimeSeries();
		assertThat(s.sieve(inputPrimes, inputCandidates), is(expected));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSieveListListNullCandidates() {
		new PrimeSeries().sieve(TestUtils.list(), null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSieveListListNullPrimes() {
		new PrimeSeries().sieve(null, TestUtils.list(1L, 2L, 3L, 4L, 5L));
	}

	@Test
	public void testSieveListLongEmptyPrimesAdd0Candidates() {
		final List<Long> expected = TestUtils.list();
		final PrimeSeries s = new PrimeSeries();
		final List<Long> input = TestUtils.list();
		assertThat(s.sieve(input, 0L), is(expected));
	}

	@Test
	public void testSieveListLongEmptyPrimesAdd30Candidates() {
		final List<Long> expected = TestUtils.list(2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L);
		final PrimeSeries s = new PrimeSeries();
		final List<Long> input = TestUtils.list();
		assertThat(s.sieve(input, 30L), is(expected));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSieveListLongEmptyPrimesAddNegativeCandidates() {
		new PrimeSeries().sieve(TestUtils.list(), -1L);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSieveListLongNullStarter() {
		new PrimeSeries().sieve(null, 30L);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSieveListNullCandidates() {
		new PrimeSeries().sieve(null);
	}
}