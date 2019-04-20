package daily.execise.swordPointOffer;

import org.junit.Test;

public class PlayGround {



	@Test
	public void FibonacciSequenceTest() {
		FibonacciSequence fs = new FibonacciSequence();
		System.out.println(fs.Fibonacci(39));
	}


	@Test
	public void rotateArray() {
		RoateArray roateArray = new RoateArray();
//		int[] arr = {3,4,5,1,2};
		int[] arr = {};
		System.out.println(roateArray.minNumberInRotateArray(arr));
	}

	@Test
	public void DoubleStackToQueue() {
		DoubleStackToQueeu squeue = new DoubleStackToQueeu();

		squeue.push(1);
		squeue.push(2);
		squeue.push(3);
		squeue.push(4);

		System.out.println(squeue.pop());
		System.out.println(squeue.pop());
		System.out.println(squeue.pop());
		System.out.println(squeue.pop());
	}



}
