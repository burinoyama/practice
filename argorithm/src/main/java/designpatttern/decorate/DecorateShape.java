package designpatttern.decorate;

public abstract class DecorateShape implements Shape {

//	private Shape shape;

	@Override
	public void getPrice() {
		System.err.println("DecorateShape");
	}
}
