package common.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class NumberUtils {

	protected static void accumulateCommonFactors(final long valueToFactor,
			final Map<Long, Long> commonFactors) {
		final Map<Long, Long> factorCounts = distribution(primeFactors(valueToFactor));
		for (final Entry<Long, Long> e : factorCounts.entrySet()) {
			final long factor = e.getKey();
			final long factorCount = e.getValue();
			if (commonFactors.containsKey(factor)) {
				if (commonFactors.get(factor) < factorCount) {
					commonFactors.put(factor, factorCount);
				}
			} else {
				commonFactors.put(factor, factorCount);
			}
		}
	}

	public static Map<Long, Long> distribution(final List<Long> numbers) {
		final Map<Long, Long> distribution = new HashMap<Long, Long>();
		for (final long number : numbers) {
			if (distribution.containsKey(number)) {
				distribution.put(number, distribution.get(number) + 1);
			} else {
				distribution.put(number, 1L);
			}
		}
		return distribution;
	}

	public static List<Long> flattenDistribution(final Map<Long, Long> distribution) {
		final List<Long> list = new ArrayList<Long>();
		for (final Entry<Long, Long> e : distribution.entrySet()) {
			final long value = e.getKey();
			final long count = e.getValue();
			for (long i = 0; i < count; i++) {
				list.add(value);
			}
		}
		return list;
	}

	public static long leastCommonMultiple(final List<Long> input) {
		final Map<Long, Long> commonFactors = new HashMap<Long, Long>();
		for (final long l: input) {
			accumulateCommonFactors(l, commonFactors);
		}
		return product(flattenDistribution(commonFactors));
	}

	public static long leastCommonMultiple(final Range input) {
		return leastCommonMultiple(input.asList());
	}

	public static List<Long> primeFactors(long number) {
		if (number <= 0) {
			throw new IllegalArgumentException("The input parameter number"
					+ " cannot be less than or equal to zero.");
		}
		final ArrayList<Long> factors = new ArrayList<Long>();
		for (long candidate = 2L; number > 1; candidate++) {
			for (; number % candidate == 0; number /= candidate) {
				factors.add(candidate);
			}
		}
		return factors;
	}

	public static long product(final List<Long> list) {
		long product = 1L;
		for (final long l : list) {
			product *= l;
		}
		return product;
	}

	public static long product(final Range range) {
		return product(range.asList());
	}

	public static long productUpToElement(final long maxElementInclusive) {
		return productUpToElement(new IncrementalSeries(), maxElementInclusive);
	}

	public static long productUpToElement(final Series series,
			final long maxElementInclusive) {
		long product = 1L;
		for (long i = 1; i <= maxElementInclusive; i++) {
			product *= series.next();
		}
		return product;
	}

	public static long productUpToValue(final long maxExclusive) {
		return productUpToValue(new IncrementalSeries(), maxExclusive);
	}

	public static long productUpToValue(final Series series,
			final long maxExclusive) {
		long product = 1;
		long current = 0;
		while((current = series.next()) < maxExclusive) {
			product *= current;
		}
		return product;
	}

	public static long sum(final List<Long> list) {
		long sum = 0;
		for (final long l : list) {
			sum += l;
		}
		return sum;
	}

	public static long sum(final Range range) {
		return sum(range.asList());
	}

	public static long sumUpToElement(final long maxElementInclusive) {
		return sumUpToElement(new IncrementalSeries(), maxElementInclusive);
	}

	public static long sumUpToElement(final Series series,
			final long maxElementInclusive) {
		long sum = 0;
		for (long i = 1; i <= maxElementInclusive; i++) {
			sum += series.next();
		}
		return sum;
	}

	public static long sumUpToValue(final long maxExclusive) {
		return sumUpToValue(new IncrementalSeries(), maxExclusive);
	}

	public static long sumUpToValue(final Series series, final long maxExclusive) {
		long sum = 0;
		long current = 0;
		while((current = series.next()) < maxExclusive) {
			sum += current;
		}
		return sum;
	}

	private NumberUtils() {}

	public static boolean isPrime(long number) {
		if (number <= 0) {
			throw new IllegalArgumentException("The input parameter number"
					+ " cannot be less than or equal to zero.");
		}
		long factorsFound = 0;
		for (long candidate = 2L; number > 1; candidate++) {
			for (; number % candidate == 0; number /= candidate) {
				if (factorsFound >= 1) {
					return false;
				} else {
					factorsFound++;
				}
			}
		}
		return factorsFound == 1;
	}

	public static boolean isEven(final long candidate) {
		return (candidate % 2) == 0;
	}

	public static boolean isOdd(final long candidate) {
		return !isEven(candidate);
	}

	public static boolean isPalindrome(final long candidate) {
		return (candidate - reverse(candidate)) == 0;
	}

	public static long reverse(final long value) {
		long tmp = value;
		long retVal = 0;
		while(tmp > 0) {
			long digit = tmp % 10;
			retVal *= 10;
			retVal += digit;
			tmp /= 10;
		}
		return retVal;
	}

	public static long getMaxValue(final List<Long> values) {
		if (values == null || values.isEmpty()) {
			throw new IllegalArgumentException("values parameter must not be"
					+ " null-valued or empty.");
		}
		return Collections.max(values);
	}
}