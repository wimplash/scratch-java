package common.java;

public abstract class InfiniteSeries extends GenericSeries {
	@Override
	public boolean hasMore(final int elements) {
		return true;
	}
}
