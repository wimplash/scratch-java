package common.java;

public class DigitSequence extends FiniteSeries {

	private int index;
	private CharSequence source;
	
	public DigitSequence(final CharSequence source) {
		this.index = 0;
		this.source = source;
	}

	private long getDigitAt(final int i) {
		final char digit = source.charAt(i);
		if (! Character.isDigit(digit)) {
			throw new NumberFormatException("the character at index '" + i
					+ "' in the source sequence was not a valid numeric"
					+ " character. sequence: '" + source + "'");
		} else {
			return Character.digit(digit, 10);
		}
	}

	@Override
	public long next() {
		index++;
		return getDigitAt(index);
	}

	@Override
	public long peek(int elementsAhead) {
		return getDigitAt(index + elementsAhead);
	}

	@Override
	public boolean hasMore(final int elements) {
		return index + elements < source.length() + 1;
	}
}