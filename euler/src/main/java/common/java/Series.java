package common.java;

public interface Series {
	boolean hasNext();
	boolean hasMore(final int elements);
	long next();
	long peek();
	long peek(final int elementsAhead);
	long[] take(final int elementCount);
}