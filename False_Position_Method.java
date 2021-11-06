package Numerical_Theorem;

import java.text.DecimalFormat;

public class False_Position_Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float x0 = 0;
		float x1 = 0;
		for(int i = 0 ; i < 9; i++) {
			if(eqn(i)*eqn(i+1)<0) {
				x0 = i;
				x1 = i+1;
			}
		}
		float prev = 0;
		while(true) {
			float num = x1-x0;
			float den = eqn(x1)-eqn(x0);
			float half_ans = (num/den);
			float x2 = x0-half_ans*eqn(x0);
			DecimalFormat df = new DecimalFormat("0.000");
			
			if(df.format(prev).equals(df.format(x2))) {
				System.out.println(df.format(x2));
				break;
			}
			else {
				prev = x2;
			}
			if(eqn(x2)<0 && eqn(x0)<0) {
				x0 = x2;
			}
			if(eqn(x2)<0 && eqn(x1)<0) {
				x1 = x2;
			}
			if(eqn(x2)>0 && eqn(x0)>0) {
				x0 = x2;
			}
			if(eqn(x2)>0 && eqn(x1)>0) {
				x1 = x2;
			}
			if(x0>x1) {
				float temp = x0;
				x0 = x1;
				x1 = temp;
			}
			
		}

	}
	public static float eqn(float x) {
		return x*x*x - 4*x -9;
	}

}
