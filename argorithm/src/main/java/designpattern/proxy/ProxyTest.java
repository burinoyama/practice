package designpattern.proxy;

import org.junit.Test;

public class ProxyTest {

	@Test
	public void run() {
		JDKDynamicProxy proxy = new JDKDynamicProxy();

		FreeTalker freeTalker = new FreeTalker();

		Free talker = (Free)proxy.bind(freeTalker);

		talker.say();

	}
}
