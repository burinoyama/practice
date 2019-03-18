package designpattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy implements InvocationHandler {

	private Object target;

	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.err.println("before");

		Object invoke = method.invoke(this.target, args);

		System.err.println("after");

		return invoke;
	}
}
