package daily.execise.swordPointOffer;

public class FibonacciSequence {


	public int Fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return Fibonacci(n - 1) + Fibonacci(n - 2);
	}

	public int JumpFloor(int target) {
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		int step1 = 1;
		int step2 = 2;
		int ret = 0;

		for (int i = 2; i < target;i++) {
			ret = step1 + step2;
			step1 = step2;
			step2 = ret;
		}
		return ret;
	}

	public int JumpFloorII(int target) {
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		return 2 * JumpFloorII(target - 1);
	}

}
