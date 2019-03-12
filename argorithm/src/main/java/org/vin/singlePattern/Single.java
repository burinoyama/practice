package org.vin.singlePattern;

public class Single {

	private Single(){};

	private static Single single;

	/**
	 * 在获得对象时要传入参数时,这种情况下,只能使用懒汉式
	 * @return
	 */
	public synchronized static Single getInstance() {
		if (single == null) {
			single = new Single();
		}
		return single;
	}

	public Object readResolve() {
		return single;
	}
}
