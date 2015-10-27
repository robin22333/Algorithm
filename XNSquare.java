package com.xujc.algorithm;

public class XNSquare {
	
	/**
	 * 求x的n次方，复杂度O(lgn)
	 * @param x
	 * @param n
	 * @return
	 */
	public static int xNSquare(int x, int n) {
		if (1 == n) {
			return x;
		}
		
		if (n % 2 == 0) {
			int result = xNSquare(x, n/2);
			return result * result;
		} else {
			int result = xNSquare(x, n/2);
			return result * result * x;
		}
		
		
	}

}
