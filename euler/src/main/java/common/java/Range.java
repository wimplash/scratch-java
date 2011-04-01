package common.java;

import java.util.ArrayList;
import java.util.List;

public class Range {

	private final long end;

	private final long start;

	public Range(final long start, final long end) {
		if (start >= end) {
			throw new IllegalArgumentException("start must be strictly less"
					+ " than end.");
		}
		this.start = start;
		this.end = end;
	}

	public List<Long> asList() {
		final List<Long> retVal = new ArrayList<Long>();
		for (long i = getStart(); i <= end; i++) {
			retVal.add(i);
		}
		return retVal;
	}

	public long getEnd() {
		return end;
	}

	public long getStart() {
		return start;
	}
}