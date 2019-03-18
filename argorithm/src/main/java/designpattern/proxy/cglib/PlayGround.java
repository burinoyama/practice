package designpattern.proxy.cglib;

import org.junit.Test;

public class PlayGround {

	@Test
	public void run() {
		Liberty liberty = new Liberty();
		LibertyProxy libertyProxy = new LibertyProxy();
		Liberty libertyProxyed = (Liberty)libertyProxy.bind(liberty);
		libertyProxyed.content();
	}
}
