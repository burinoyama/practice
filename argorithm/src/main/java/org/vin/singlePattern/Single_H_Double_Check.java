package org.vin.singlePattern;


/**
 * 懒汉式的升级版, 双重检验
 */
public class Single_H_Double_Check {

	/**
	 * volatile 的作用:
	 * jvm创建对象时:大概有一下3步:
	 * 1,在堆分配空间
	 * 2,执行对象的构造方法对对象初始化
	 * 3,把对象指向在堆空间里分配好的空间
	 * 但在执行时可能会对代码顺序进行优化,
	 *
	 * 作用:
	 * 1,volatile 对阻止对生成对象的代码优化,
	 * 2,使对象在线程能够立即对其他线程可见
	 *
	 */
	private static volatile Single_H_Double_Check single;

	private Single_H_Double_Check() {
	}

	/**
	 * 具体在这个方法中,如果single对象没有volatile关键字
	 * 可能第一个进来的线程执行new Single_H_Double_Check()的方法时,之后进来的线程仍然认为single时空的对象
	 * @return
	 */
	public static Single_H_Double_Check getInstance() {
		if (single == null) {
			synchronized (Single_H_Double_Check.class) {
				if (single == null) {
					single = new Single_H_Double_Check();
				}
			}
		}
		return single;
	}

	public Object readResolve() {
		return single;
	}

}
