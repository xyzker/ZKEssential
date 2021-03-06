import org.apache.curator.CuratorZookeeperClient;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;

public class MyCuratorClient {
	public void testCuratorClient() throws Exception {
		CuratorZookeeperClient client = new CuratorZookeeperClient(HelloZooKeeper.CONNECT_STRING, 10000, 10000, null,
				new RetryOneTime(1));
		client.start();
		try {
			client.blockUntilConnectedOrTimedOut();
			String path = client.getZooKeeper().create("/test_znode", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
					CreateMode.PERSISTENT);
		} finally {
			client.close();
		}
	}
	
	public static void main(String[] args)throws Exception{
		MyCuratorClient curatorClient=new MyCuratorClient();
		curatorClient.testCuratorClient();
	}
}
