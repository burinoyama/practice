package designpattern.proxy.jdk;

public class FreeImpler implements Free {
	@Override
	public void say() {
		System.err.println("I implement free");
	}
}
