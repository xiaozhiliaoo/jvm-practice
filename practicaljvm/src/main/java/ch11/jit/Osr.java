package ch11.jit;

import static java.lang.Math.pow;
import static java.lang.Math.random;

/**
 * -XX:+PrintCompilation -XX:OnStackReplacePercentage=1000000 -XX:CompileThreshold=1500
 * 
 * -XX:+PrintCompilation -XX:OnStackReplacePercentage=100000 -XX:CompileThreshold=1500 -XX:-BackgroundCompilation -XX:+UseOnStackReplacement -XX:-UseLoopCounter
 * @author Administrator
 *
 */
public class Osr {
	public static double osrMethod() {
		double N = 10000000;
		int sum = 0;
		for (int i=1; i<=N; i++) {
			if (pow(random(), 2) + pow(random(),2) < 1) {
				sum ++;
			}
		}
		return 4* sum/N;
	}

	public static void main(String args[]) {
		System.out.println(osrMethod());
	}
}
