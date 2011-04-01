package problems.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.java.NumberUtils;
import common.java.Range;

public class Problem4 {

	private final Range range;

	public Problem4() {
		this(1, 10);
	}

	public Problem4(final long start, final long end) {
		this.range = new Range(start, end);
	}

	public long findLargestPalindrome() {
		final List<Long> palindromes = new ArrayList<Long>();
		for (long i = range.getEnd(); i >= range.getStart(); i--) {
			for (long j = i; j >= range.getStart(); j--) {
				if (NumberUtils.isPalindrome(i * j)) {
					palindromes.add(i * j);
				}
			}
		}
		return Collections.max(palindromes);
	}
}