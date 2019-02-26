package org.vin.find;

public class PlayGroud {
	public static void main(String[] args) {

		String command = "( ( 1 + 2 ) + ( 4 * 3 ) )";

		System.out.println(new DoubleStackDijkstra().calculate(command));
	}
}
