package jvmtest;

import java.util.Random;

public class GcTest {

	public static void main(String[] args) {
		long str = 0;

		while (true) {
			str += str + new Random().nextInt(88888888) + new Random().nextInt(999999999);
		}

	}
}
