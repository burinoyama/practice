package org.vin.singlePattern;


/**
 * 静态内部类的单例模式
 * 优点:类加载不会创建单例对象,只有电泳getInstance()方法后才会将静态内部类加载到内存中,
 */
public class Single4 {

	private Single4(){};

	private static final class SingleHolder {
		private static final Single4 single = new Single4();
	}

	public static Single4 getInstance(){
		return SingleHolder.single;
	}

	public Object readResolve() {
		return SingleHolder.single;
	}


}
