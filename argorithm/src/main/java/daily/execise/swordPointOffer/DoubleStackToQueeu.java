package daily.execise.swordPointOffer;


import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class DoubleStackToQueeu {


	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {

		stack1.add(node);

	}

	public int pop() {
		while (!stack1.isEmpty()) {
			stack2.add(stack1.pop());
		}
		Integer ret = stack2.pop();
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return ret;
	}
}
