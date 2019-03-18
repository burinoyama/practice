package designpattern.proxy;

public class FreeTalker implements Free {
	@Override
	public void say() {
		System.err.println("I talk about free");
	}
}
