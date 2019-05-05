package org.vin.singlePattern;


/**
 * 饿汉式
 * 缺点:加载类,就创建对象,即使不需要对象,只需要这个类中的其他的全局变量
 */
public class Single_Hungary {
	private static final Single_Hungary single = new Single_Hungary();

	private Single_Hungary(){};

	public static Single_Hungary getInstance() {
		return single;
	}

	public Object readResolve() {
		return single;
	}
}
