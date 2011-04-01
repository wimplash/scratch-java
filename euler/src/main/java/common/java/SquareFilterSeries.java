package common.java;

public class SquareFilterSeries extends GenericSeries {

	private Series delegate;

	public SquareFilterSeries() {
		this(new IncrementalSeries());
	}

	public SquareFilterSeries(final Series delegate) {
		this.delegate = delegate;
	}

	@Override
	public long next() {
		final long next = delegate.next();
		return next * next;
	}

	@Override
	public long peek(final int elementsAhead) {
		if (elementsAhead <= 0) {
			throw new IllegalArgumentException("The elementsAhead parameter"
					+ " cannot be zero or less");
		}
		final long peek = delegate.peek(elementsAhead);
		return peek * peek;
	}

	@Override
	public boolean hasMore(final int elements) {
		return delegate.hasMore(elements);
	}
}