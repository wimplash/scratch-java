package common.java;

import java.util.logging.Logger;

public class WindowedProductSeries extends GenericSeries {

	private final static Logger LOG = Logger
			.getLogger(WindowedProductSeries.class.getName());
	private final int windowSize;
	private final Series delegate;

	public WindowedProductSeries(final Series series, final int windowSize) {
		this.delegate = series;
		this.windowSize = windowSize;
	}

	@Override
	public long next() {
		final long product = windowProduct(0);
		delegate.next();
		return product;
	}

	private long windowProduct(final int elementsAhead) {
		if (! delegate.hasMore(elementsAhead + windowSize)) {
			throw new IllegalStateException("delegate series does not contain"
					+ " enough elements.");
		}
		final StringBuilder b = new StringBuilder("Product of digits in [");
		long product = 1;
		for (int i = 0; i < windowSize; i ++) {
			final long digit = delegate.peek(elementsAhead + i);
			b.append(digit);
			product *= digit;
		}
		b.append("] = " + product);
		LOG.info(b.toString());
		return product;
	}

	@Override
	public long peek(final int elementsAhead) {
		return windowProduct(elementsAhead);
	}

	@Override
	public boolean hasMore(final int elements) {
		return delegate.hasMore(elements * windowSize);
	}
}