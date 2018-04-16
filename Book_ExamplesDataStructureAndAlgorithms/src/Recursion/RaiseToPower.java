package Recursion;

public class RaiseToPower {

	public int powerN(int base, int power) {
		if (power == 1)
			return base;
		else if (power % 2 == 0) {
			int x = powerN(base, power / 2);
			return x * x;
		} else {
			int x = powerN(base, (power - 1) / 2);
			return x * x * base;
		}
	}

	public static void main(String[] args) {
		RaiseToPower obj = new RaiseToPower();
		System.out.println("result is " + obj.powerN(9, 3));
	}

}
