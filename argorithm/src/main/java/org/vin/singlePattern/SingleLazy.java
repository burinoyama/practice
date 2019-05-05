package org.vin.singlePattern;

public class SingleLazy {

	private SingleLazy(){};

	private static SingleLazy singleLazy;

	/**
	 * 在获得对象时要传入参数时,这种情况下,只能使用懒汉式
	 * @return
	 */
	public synchronized static SingleLazy getInstance() {
		if (singleLazy == null) {
			singleLazy = new SingleLazy();
		}
		return singleLazy;
	}

	public Object readResolve() {
		return singleLazy;
	}
}
