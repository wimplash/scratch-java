package common.java;

public abstract class GenericSeries implements Series {

	@Override
	public boolean hasNext() {
		return hasMore(1);
	}

	@Override
	public long peek() {
		return peek(1);
	};

	@Override
	public long[] take(final int elementCount) {
		final long[] elements = new long[elementCount];
		for (int i = 0; i < elementCount; i++) {
			elements[i] = next();
		}
		return elements;
	}
}