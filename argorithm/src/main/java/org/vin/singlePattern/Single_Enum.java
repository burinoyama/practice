package org.vin.singlePattern;


/**
 * 枚举实际上就是一个继承Enum的类
 * 因为枚举的特点，你只会有一个实例，同时保证了线程安全、反射安全和反序列化安全
 */
public enum Single_Enum {

	 INSTANCE;

	 public static Single_Enum getInstance() {
	 	return INSTANCE;
	 }

}
