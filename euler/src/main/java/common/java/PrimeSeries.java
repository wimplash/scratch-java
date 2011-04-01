package common.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PrimeSeries extends InfiniteSeries {

	private static final long CANDIDATES_PER_SIFT = 1000L;

	private int index = 0;

	private final List<Long> primes = new ArrayList<Long>();

	protected long getMaxPrime(final List<Long> primes) {
		if (primes == null) {
			throw new IllegalArgumentException("primes must not be"
					+ " null-valued");
		} else if (primes.isEmpty()) {
			return 1L;
		} else {
			return NumberUtils.getMaxValue(primes);
		}
	}

	@Override
	public long next() {
		while (primes.size() <= index) {
			final List<Long> tmp = sieve(primes, CANDIDATES_PER_SIFT);
			primes.clear();
			primes.addAll(tmp);
		}
		final long result = primes.get(index);
		index++;
		return result;
	}

	@Override
	public long peek(final int elementsAhead) {
		if (elementsAhead <= 0) {
			throw new IllegalArgumentException();
		}
		while (primes.size() <= index + elementsAhead) {
			final List<Long> tmp = sieve(primes, CANDIDATES_PER_SIFT);
			primes.clear();
			primes.addAll(tmp);
		}
		return primes.get((index - 1) + elementsAhead);
	}

	protected List<Long> sieve(final List<Long> candidates) {
		if (candidates == null) {
			throw new IllegalArgumentException("candidates must not be"
					+ " null-valued.");
		}
		final List<Long> result = new ArrayList<Long>(candidates);
		for (final long value : candidates) {
			if (result.contains(value)) {
				for (final Iterator<Long> i = result.iterator(); i.hasNext();) {
					final long candidate = i.next();
					if (candidate == 1L) {
						i.remove();
					}
					if ((candidate != value) && ((candidate % value) == 0L)) {
						i.remove();
					}
				}
			}
		}
		return result;
	}

	protected List<Long> sieve(final List<Long> starterPrimes,
			final List<Long> candidates) {
		if (starterPrimes == null) {
			throw new IllegalArgumentException("starterPrimes must not be"
					+ " null-valued.");
		}
		if (candidates == null) {
			throw new IllegalArgumentException("candidates must not be"
					+ " null-valued.");
		}
		final List<Long> result = new ArrayList<Long>(candidates);
		for (final long prime : starterPrimes) {
			for (final Iterator<Long> i = result.iterator(); i.hasNext();) {
				final long candidate = i.next();
				if (candidate == 1) {
					i.remove();
				}
				if ((candidate % prime) == 0) {
					i.remove();
				}
			}
		}
		return result;
	}

	protected List<Long> sieve(final List<Long> starterPrimes, final long numCandidates) {
		if (starterPrimes == null) {
			throw new IllegalArgumentException("starterPrimes must not be"
					+ " null-valued.");
		}
		if (numCandidates < 0) {
			throw new IllegalArgumentException("numCandidates must be a"
					+ " non-negative value.");
		}
		final long maxPrime = getMaxPrime(starterPrimes);
		List<Long> candidates = new ArrayList<Long>();
		for (long i = 1; i <= numCandidates; i++) {
			candidates.add(maxPrime + i);
		}

		candidates = sieve(starterPrimes, candidates);
		candidates = sieve(candidates);

		//add starter and remaining candidates to return list and sort
		final List<Long> result = new ArrayList<Long>(starterPrimes);
		result.addAll(candidates);
		Collections.sort(result);
		return result;
	}
}