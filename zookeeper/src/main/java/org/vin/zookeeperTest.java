package org.vin;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;


public class zookeeperTest {
	private static String connectString = "hadoop5:2181,hadoop6:2181,hadoop7:2181";
	private static int sessionTimeout = 2000;
	private ZooKeeper zkClient = null;


	@Test
	public void create() throws KeeperException, InterruptedException {
		String msg = zkClient.create("/obstruct", "obfuscate".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		System.err.println(msg);
	}

	@Test
	public void exist() throws KeeperException, InterruptedException {
		Stat exists = zkClient.exists("/obstruct", false);
		System.err.println(exists);
	}

	@Before
	public void init() throws Exception {

		zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

			@Override
			public void process(WatchedEvent event) {

				// 收到事件通知后的回调函数（用户的业务逻辑）
				System.out.println(event.getType() + "--" + event.getPath());

				// 再次启动监听
				try {
					zkClient.getChildren("/", true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
