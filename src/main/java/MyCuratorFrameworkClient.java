import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.CreateMode;

public class MyCuratorFrameworkClient {
	public void simpleCuratorFrameworkClient() throws Exception {
		CuratorFramework client = CuratorFrameworkFactory.newClient(HelloZooKeeper.CONNECT_STRING, new RetryOneTime(1));
		client.start();

		try {
			String path = client.create().withMode(CreateMode.PERSISTENT).forPath("/test_znode", "".getBytes());
		} finally {
			client.close();
		}
	}
}
