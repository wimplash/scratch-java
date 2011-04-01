package problems.java;

import common.java.DigitSequence;
import common.java.Series;
import common.java.WindowedProductSeries;

public class Problem8 {

	public static void main(final String[] args) {
		final String bigNum = "73167176531330624919225119674426574742355349194"
			+ "93496983520312774506326239578318016984801869478851843858615"
			+ "60789112949495459501737958331952853208805511125406987471585"
			+ "23863050715693290963295227443043557668966489504452445231617"
			+ "31856403098711121722383113622298934233803081353362766142828"
			+ "06444486645238749303589072962904915604407723907138105158593"
			+ "07960866701724271218839987979087922749219016997208880937766"
			+ "57273330010533678812202354218097512545405947522435258490771"
			+ "16705560136048395864467063244157221553975369781797784617406"
			+ "49551492908625693219784686224828397224137565705605749026140"
			+ "79729686524145351004748216637048440319989000889524345065854"
			+ "12275886668811642717147992444292823086346567481391912316282"
			+ "45861786645835912456652947654568284891288314260769004224219"
			+ "02267105562632111110937054421750694165896040807198403850962"
			+ "45544436298123098787992724428490918884580156166097919133875"
			+ "49920052406368991256071760605886116467109405077541002256983"
			+ "15520005593572972571636269561882670428252483600823257530420"
			+ "752963450";
		final Series digitSeq = new DigitSequence(bigNum);
		final Problem8 p = new Problem8();
		System.out.println("finding maximum product of 5 consecutive digits"
				+ " in: " + bigNum);
		final long maxProduct = p.maxProductOfDigits(digitSeq);
		System.out.println("Maximum product is: " + maxProduct);
	}

	public long maxProductOfDigits(final Series numbers) {
		if (numbers == null) {
			throw new IllegalArgumentException("the numbers parameter must not"
					+ " be null.");
		}
		final Series s = new WindowedProductSeries(numbers, 5);
		long maxProduct = 0;
		while (s.hasNext()) {
			maxProduct = Math.max(maxProduct, s.next());
		}
		return maxProduct;
	}
}