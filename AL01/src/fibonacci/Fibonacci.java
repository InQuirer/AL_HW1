package fibonacci;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class Fibonacci {

    /** 
     * @param n 
     * @return Computes the n-th number in Fibonacci series
     */
    public static BigInteger fib(int n) {
    	if(n == 0 || Math.abs(n) == 1) return BigInteger.valueOf(n);
    	else return fib(n-1).add(fib(n-2));
    }

    public static int find_index(int precision) {
    	precision++;
    	BigDecimal goldenRatio = BigDecimal.valueOf(0.5*(Math.sqrt(5) + 1));
    	BigDecimal result = BigDecimal.ZERO;
    	int n = 2;
    	System.err.println(goldenRatio);
    	goldenRatio = goldenRatio.round(new MathContext(precision));
    	do {
    		result = new BigDecimal(fib(n)).divide(new BigDecimal(fib(n-1)), new MathContext(precision, RoundingMode.FLOOR));
    		n++;
    		System.out.println(result);
		} while (!result.equals(goldenRatio));
		return --n;
    }
}