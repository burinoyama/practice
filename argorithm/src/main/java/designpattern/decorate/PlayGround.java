package designpattern.decorate;

import org.junit.Test;

public class PlayGround {

	@Test
	public void run() {

		Circle circle = new Circle();

		RedShape redShape = new RedShape(circle);

		redShape.getPrice();
		redShape.setBorder(circle);
	}
}
