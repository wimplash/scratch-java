package common.java;

public class ComboSeries extends GenericSeries {

	private Series s1;
	private Series s2;

	public ComboSeries(final Series series1,
			final Series series2) {
		this.s1 = series1;
		this.s2 = series2;
	}

	@Override
	public long next() {
		if (peek() == s1.peek() && peek() == s2.peek()) {
			s1.next();
			return s2.next();
		} else if (peek() == s1.peek()) {
			return s1.next();
		} else {
			return s2.next();
		}
	}

	@Override
	public long peek(final int elementsAhead) {
		if (elementsAhead <= 0) {
			throw new IllegalArgumentException("The elementsAhead parameter"
					+ " cannot be zero or less.");
		}
		int s1Count = 1;
		int s2Count = 1;
		for (int i = 1; i < elementsAhead; i++) {
			if (s1.peek(s1Count) == s2.peek(s2Count)) {
				s1Count++;
				s2Count++;
			} else if (s1.peek(s1Count) < s2.peek(s2Count)) {
				s1Count++;
			} else {
				s2Count++;
			}
		}
		if (s1.peek(s1Count) == s2.peek(s2Count)) {
			return s2.peek(s2Count);
		} else if (s1.peek(s1Count) < s2.peek(s2Count)) {
			return s1.peek(s1Count);
		} else {
			return s2.peek(s2Count);
		}
	}

	@Override
	public boolean hasMore(final int elements) {
		if (elements == 0) {
			return true;
		}
		for (int i = 0; i < elements; i++) {
			if (s1.hasMore(i) && s2.hasMore(elements - i)) {
				return true;
			}
		}
		return false;
	}
}