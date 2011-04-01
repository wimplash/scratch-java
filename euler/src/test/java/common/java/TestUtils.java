package common.java;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

	public static List<Long> list(final Long ... values) {
		final List<Long> retVal = new ArrayList<Long>();
		for (int i = 0; i < values.length; i++) {
			retVal.add(values[i]);
		}
		return retVal;
	}

	private TestUtils() {}
}