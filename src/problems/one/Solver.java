package problems.one;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import utils.FileReader;

public class Solver {
	final static  BigDecimal THREE = new BigDecimal("3"),
			TWO = new BigDecimal("2");
	
	
	public static void main(String[] args) {
		FileReader reader = new FileReader(Solver.class, "input.txt");
		List<BigDecimal> bds = reader.getLinesAsBds();
		
		System.out.println("Here is answer one: " + getAnswerOne(bds));
		System.out.println("Here is answer two: " + getAnswerTwo(bds));
	}
	
	private static BigDecimal getAnswerOne(List<BigDecimal> bds) {
		BigDecimal answer = BigDecimal.ZERO;
		
		for (BigDecimal b : bds) {
			answer = answer.add(getPostOperationValue(b));
		}
		
		return answer;
	}
	
	private static BigDecimal getAnswerTwo(List<BigDecimal> bds) {
		BigDecimal answer = BigDecimal.ZERO;
		
		for (BigDecimal b : bds) {
			answer = answer.add(getRecursedValue(b));
		}
		
		return answer;
	}
	
	private static boolean isPositive(BigDecimal b) {
		return b.compareTo(BigDecimal.ZERO) != -1;
	}
	
	private static BigDecimal getRecursedValue(BigDecimal b) {
		if (!isPositive(b)) return BigDecimal.ZERO;
		BigDecimal recursivelyAddedTo = BigDecimal.ZERO;
		BigDecimal placeholder = b;
		
		while (true) {
			placeholder = getPostOperationValue(placeholder);
			if (isPositive(placeholder)) {
				recursivelyAddedTo = recursivelyAddedTo.add(placeholder);
			} else break;
		}
		
		return recursivelyAddedTo;
	}
	
	private static BigDecimal getPostOperationValue(BigDecimal b) {
		BigDecimal dividedByThree = b.divide(THREE , RoundingMode.FLOOR),
				subtractingTwo = dividedByThree.subtract(TWO);
		return subtractingTwo;
	}

}
