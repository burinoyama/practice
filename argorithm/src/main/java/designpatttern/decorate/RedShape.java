package designpatttern.decorate;

public class RedShape extends DecorateShape {

	private Shape shape;

	public RedShape(Shape shape) {
		this.shape = shape;
	}

	@Override
	public void getPrice() {
		System.err.println("RedShape");
	}

	public void setBorder(Shape shape) {
		System.err.println("set border");
	}
}
