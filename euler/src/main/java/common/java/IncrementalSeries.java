package common.java;

public class IncrementalSeries extends InfiniteSeries {

	private long current;
	private long increment;

	public IncrementalSeries() {
		this.current = 0;
		this.increment = 1;
	}

	public IncrementalSeries(final long base) {
		this();
		this.current = base;
	}

	public IncrementalSeries(final long base, final long increment) {
		this(base);
		if(increment < 0) {
			throw new IllegalArgumentException("The increment parameter must"
					+ " not be less than zero.");
		}
		this.increment = increment;
	}

	@Override
	public long next() {
		current = peek();
		return current;
	}

	@Override
	public long peek(final int elementsAhead) {
		if (elementsAhead <= 0) {
			throw new IllegalArgumentException("The elementsAhead parameter"
					+ " cannot be zero or less.");
		}
		return current + (increment * elementsAhead);
	}

	@Override
	public String toString() {
		return "{current=" + current + ":next=" + peek() + "}";
	}
}