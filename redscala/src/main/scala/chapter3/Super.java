package chapter3;

public class Super {

	Object getSomething(){
		return "super";
	}
}


class Sub extends Super {
	String getSomthing() {
		return "sub";
	}
}


