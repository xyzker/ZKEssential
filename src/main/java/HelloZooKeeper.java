/*Our First ZooKeeper Program*/
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloZooKeeper {
    public static final String CONNECT_STRING = "H5-Pad-web-online001-bjdx.qiyi.virtual:2181,H5-Pad-web-online002-bjdx.qiyi.virtual:2181,H5-Pad-web-online003-bjdx.qiyi.virtual:2181";

    public static void main(String[] args) throws IOException {
    	//域名或者IP配置
        String hostPort = CONNECT_STRING;
        String zpath = "/";
        List <String> zooChildren = new ArrayList <String> ();
        ZooKeeper zk = new ZooKeeper(hostPort, 2000, null);
        if (zk != null) {
            try {
                zooChildren = zk.getChildren(zpath, false);
                System.out.println("Znodes of '/': ");
                for (String child: zooChildren) {
                    //print the children
                    System.out.println(child);
                }
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }   
    }
}

