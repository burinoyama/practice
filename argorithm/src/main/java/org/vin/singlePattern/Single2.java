package org.vin.singlePattern;


/**
 * 饿汉式
 * 缺点:加载类,就创建对象,即使不需要对象,只需要这个类中的其他的全局变量
 */
public class Single2 {
	private static final Single2 single = new Single2();

	private Single2(){};

	public static Single2 getInstance() {
		return single;
	}

	public Object readResolve() {
		return single;
	}
}
