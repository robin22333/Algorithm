package com.xujc.algorithm;

public class FibonacciSequence {
	
	public static final int[][] MATRIX = new int[][]{{1, 1}, {1, 0}};
	
	/**
	 * 递归求斐波那契数列，指数级的复杂度
	 * @param n
	 * @return
	 */
	public static int fibonacci(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		
		return fibonacci(n-1) + fibonacci(n-2);
		
	}
	
	/**
	 * 迭代法求斐波那契数列，复杂度O(n)
	 * @param n
	 * @return
	 */
	public static int fibonacci2(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		int f1 = 1;
		int f2 = 1;
		int temp = 0;
		for (int i=0; i<n-2; i++) {
			temp = f1 + f2;
			f1 = f2;
			f2 = temp;
		}
		
		return temp;
	}
	
	/**
	 * 分治法求斐波那契数列，复杂度O(lgn)
	 * @param n
	 * @return
	 */
	public static int fibonacci3(int n) {
		if (n == 1 && n == 2) {
			return 1;
		} else {
			return recruit(n)[0][1];
		}
	}
	
	/**
	 * 求矩阵MATRIX的n次方
	 * @param n
	 * @return
	 */
	public static int[][] recruit(int n) {
		if (n == 1) {
			return MATRIX;
		} else {
			if (n % 2 == 0) {
				int[][] r = recruit(n / 2);
				return matrixTimes(r, r, 2);
			} else {
				int[][] r = recruit(n / 2);
				return matrixTimes(MATRIX, matrixTimes(r, r, 2), 2);
			}
		}
	}
	
	/**
	 * 矩阵乘法
	 * @param arr1
	 * @param arr2
	 * @param n
	 * @return
	 */
	public static int[][] matrixTimes(int[][] arr1, int[][] arr2, int n) {
		int[][] r = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				for (int k=0; k<n; k++) {
					r[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		
		return r;
	}

}
