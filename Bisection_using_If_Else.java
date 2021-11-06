package Numerical_Theorem;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Bisection_using_If_Else {

	public static void main(String[] args) {
		// TODO Auto-generated method stubint count = 0;
		int count = 0;
		float x0 = 0;
		float x1 = 0;
		for (int i = 0; i < 9; i++) {
			x0 = i;
			x1 = i + 1;
			if (function(x0) < 0 && function(x1) > 0 || function(x0) > 0 && function(x1) < 0) {

				break;
			}
		}

		count++;
		float prev = 0;
		while (true) {
			float x2 = (x0 + x1) / 2;
			DecimalFormat df = new DecimalFormat("0.000");

			if (df.format(prev).equals(df.format(x2))) {
				System.out.println(df.format(x2));
				break;
			} else {
				prev = x2;
			}

			if (function(x2) < 0 && function(x0) < 0) {
				x0 = x2;
				count++;
			}
			if (function(x2) < 0 && function(x1) < 0) {
				x1 = x2;
				count++;
			}
			if (function(x2) > 0 && function(x0) > 0) {
				x0 = x2;
				count++;
			}
			if (function(x2) > 0 && function(x1) > 0) {
				x1 = x2;
				count++;
			}

		}
		System.out.println(count);

	}

	public static float function(float x) {
		return x * x * x - 2 * x - 5;
	}

}