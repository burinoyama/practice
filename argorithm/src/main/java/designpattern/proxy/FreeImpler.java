package designpattern.proxy;

public class FreeImpler implements Free {
	@Override
	public void say() {
		System.err.println("I implement free");
	}
}
