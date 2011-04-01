package common.java;

public class EvenNumberFilterSeries extends GenericSeries {

	final Series delegate;

	public EvenNumberFilterSeries() {
		this(new IncrementalSeries());
	}

	public EvenNumberFilterSeries(final Series delegate) {
		this.delegate = delegate;
	}

	@Override
	public long next() {
		while (NumberUtils.isOdd(delegate.peek())) {
			delegate.next();
		}
		return delegate.next();
	}

	@Override
	public long peek(final int elementsAhead) {
		if (elementsAhead <= 0) {
			throw new IllegalArgumentException("The elementsAhead parameter"
					+ " cannot be zero or less.");
		}
		int evensFound = 0;
		int count = 0;
		do {
			count++;
			if (NumberUtils.isEven(delegate.peek(count))) {
				evensFound++;
			}
		} while (evensFound < elementsAhead);
		return delegate.peek(count);
	}

	@Override
	public boolean hasMore(final int elements) {
		return delegate.hasMore(2 * elements);
	}
}