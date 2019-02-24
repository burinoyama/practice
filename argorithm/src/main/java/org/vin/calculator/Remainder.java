package org.vin.calculator;

public class Remainder {

	/**
	 * 对负数的取余用的是这个方式，不是简单的取余
	 * @param args
	 */
	public static void main(String[] args) {

		// a % b = a - (a / b ) * b
		System.out.println(5 % -2);
		// 5 % -2 = 5 - (5 / -2 ) * -2
		System.out.println(-5 % 2);
		System.out.println(-5 % -2);



	}
}
