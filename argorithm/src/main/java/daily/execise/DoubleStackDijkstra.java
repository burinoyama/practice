package daily.execise;

import java.util.Stack;

public class DoubleStackDijkstra {

	/**
	 * only for standard input like （ ( 1 + 3 ) * ( 6 - 3 ) ）
	 *
	 * @param command
	 * @return
	 */
	public Double calculat(String command) {
		if (command == null || command.trim().length() < 2) {
			throw new IllegalArgumentException();
		}
		Stack<String> ops = new Stack();
		Stack<Double> vals = new Stack();
		for (int i = 0; i < command.length(); i++) {
			String com = String.valueOf(command.charAt(i));

			if ("+".equals(com) || "-".equals(com) || "*".equals(com) || "/".equals(com)) {
				ops.push(com);

			} else if (")".trim().equals(com)) {
				String op = ops.pop();
				Double v = vals.pop();
				if ("+".equals(op)) {
					v = vals.pop() + v;
				} else if ("-".equals(op)) {
					v = vals.pop() - v;
				} else if ("*".equals(op)) {
					v = vals.pop() * v;
				} else if ("/".equals(op)) {
					v = vals.pop() / v;
				}
				vals.push(v);

			} else if ("(".equals(com)) {
			} else {
				vals.push(Double.valueOf(com));
			}
		}
		return vals.pop();
	}
}
