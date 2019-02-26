package org.vin.find;

import java.util.Stack;

public class DoubleStackDijkstra {

	public Double calculate(String command) {
		if (command.isEmpty()) {
			throw new IllegalArgumentException();
		}

		Stack<String> ops = new Stack();
		Stack<Double> vals = new Stack();

		String[] commands = command.split(" ");

		for (String single : commands) {
			if ("(".equals(single)) {

			} else if ("+".equals(single)) {
				ops.push(single);
			} else if ("-".equals(single)) {
				ops.push(single);
			} else if ("*".equals(single)) {
				ops.push(single);
			} else if ("/".equals(single)) {
				ops.push(single);
			} else if (")".equals(single)) {
				Double second = vals.pop();
				Double first = vals.pop();
				String op = ops.pop();
				if ("+".equals(op)) {
					vals.push(second + second);
				} else if ("-".equals(op)) {
					vals.push(first - second);
				} else if ("*".equals(op)) {
					vals.push(first * second);
				} else if ("/".equals(op)) {
					vals.push(first / second);
				} else {
					System.err.println("something is wrong");
				}

			} else {
				vals.push(Double.valueOf(single));
			}
		}
		return vals.pop();
	}
}
