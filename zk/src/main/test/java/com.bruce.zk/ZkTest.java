package com.bruce.zk;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
public class ZkTest extends ZkApplicationTests {

    /**
     * Zookeeper的节点创建模式：
     *
     * PERSISTENT：持久化
     * PERSISTENT_SEQUENTIAL：持久化并且带序列号   当一个新的znode被创建为一个顺序节点时，ZooKeeper通过将10位的序列号附加到原始名称来设置znode的路径
     * EPHEMERAL：临时  客户端活跃时，临时节点就是有效的。当客户端与ZooKeeper集合断开连接时，临时节点会自动删除。
     * EPHEMERAL_SEQUENTIAL：临时并且带序列号
     */

    /**
     * 节点默认以 / 开头, 该斜线不是根节点，是namespace根节点
     * 默认创建持久节点
     * 添加value
     */
    @Test
    public void  test01(){
        try {
            //创建一个节点，初始内容为空  todo 如果没有设置节点属性，节点创建模式默认为持久化节点，内容默认为空
            client.create().forPath("/test01");
            //创建一个节点，附带初始化内容
            client.create().forPath("/test02","value_string".getBytes());

            //创建一个节点，指定创建模式（临时节点），内容为空
            client.create().withMode(CreateMode.EPHEMERAL).forPath("/test03");

            //创建一个节点，指定创建模式（临时节点），附带初始化内容
            client.create().withMode(CreateMode.EPHEMERAL).forPath("/test04","test04".getBytes());

            //创建一个节点，指定创建模式（临时节点），附带初始化内容，并且自动递归创建父节点
            /**
             * creatingParentContainersIfNeeded()接口非常有用，因为一般情况开发人员在创建一个子节点必须判断它的父节点是否存在，如果不存在直接创建会抛出NoNodeException，使用creatingParentContainersIfNeeded()之后Curator能够自动递归创建所有所需的父节点。
             *
             */
            client.create()
                    .creatingParentContainersIfNeeded()
                    .withMode(CreateMode.EPHEMERAL)
                    .forPath("/test05","test05".getBytes());


            //创建一个节点，附带初始化内容
            client.create().forPath("/test02/test06","test06".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public  void testDelte00(){
        try {
            //删除一个节点 此方法只能删除叶子节点，否则会抛出异常。
            client.delete().forPath("/test01");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testDelete01() {
        //删除一个节点，并且递归删除其所有的子节点
        try {
            client.delete().deletingChildrenIfNeeded().forPath("/test02");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete02(){
        //删除一个节点，强制指定版本进行删除
        try {
            client.delete().withVersion(10086).forPath("path");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * guaranteed()接口是一个保障措施，只要客户端会话有效，那么Curator会在后台持续进行删除操作，直到删除节点成功。
     */
    @Test
    public void testDelete03() {
        //删除一个节点，强制保证删除
        try {
            client.delete().guaranteed().forPath("/test02");

            //todo 注意：上面的多个流式接口是可以自由组合的，例如：
          //  client.delete().guaranteed().deletingChildrenIfNeeded().withVersion(10086).forPath("path");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void readData(){
        try {
            byte[] data = client.getData().forPath("/test01");
            log.info("data value {}",data.toString());

            //读取一个节点的数据内容，同时获取到该节点的stat
            Stat stat = new Stat();
            byte[] statData =  client.getData().storingStatIn(stat).forPath("/test02");
            log.info("statData value {}",statData.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void  test02(){
        try {
            //todo 创建一个节点，初始内容为空,并处理版本
            client.create().forPath("/test02/test06/test0600");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateNode(){
        //更新一个节点的数据内容
        try {
           //该接口会返回一个Stat实例
           // Stat stat= client.setData().forPath("/test01","data_test01_中文测试".getBytes());
            Stat stat= client.setData().forPath("/example","data_example_中文测试".getBytes());


            //更新一个节点的数据内容，强制指定版本进行更新
            //client.setData().withVersion(10086).forPath("/test01","data_01".getBytes());


        } catch (Exception e) {


        }


    }

    /**
     *
     * 该方法返回一个Stat实例，用于检查ZNode是否存在的操作. 可以调用额外的方法(监控或者后台处理)并在最后调用forPath( )指定要操作的ZNode
     */
    @Test
    public void checkNodeExist(){
        try {
           Stat stat =  client.checkExists().forPath("/test02/test06/test0600");
           log.info("检测结果--{}",stat.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Test
    public void getChildren(){
        //获取某个节点的所有子节点列表,不包含当前节点和子节点的叶子节点
        try {
         List<String> list= client.getChildren().forPath("/test02");
         log.info("所有子节点列表--{}",list.toArray().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test  //todo test transaction
    public void testTransaction(){
        try {
            client.inTransaction().check().forPath("/curator_base/test003")
                    .and()
                    .create().withMode(CreateMode.PERSISTENT).forPath("/curator_base/test003","data".getBytes())
                    .and()
                    //.setData().withVersion(0).forPath("/test02","data2".getBytes())
                    .setData().forPath("/curator_base/test01","data2".getBytes())
                    .and()
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testAsyn(){
        Executor executor = Executors.newFixedThreadPool(2);
        try {
            client.create()
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.PERSISTENT_SEQUENTIAL)
                    .inBackground((curatorFramework, curatorEvent) -> {
                        log.info(String.format("eventType:%s,resultCode:%s",curatorEvent.getType(),curatorEvent.getResultCode()));
                    },executor) //如果#inBackground()方法不指定executor，那么会默认使用Curator的EventThread去进行异步处理。
                    .forPath("/test12_");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testPathCache(){
        try{//todo 注意path的设置
            PathChildrenCache cache = new PathChildrenCache(client, "/example/pathCache", true);
            cache.start();
            PathChildrenCacheListener cacheListener = (client1, event) -> {
                System.out.println("事件类型：" + event.getType());
                if (null != event.getData()) {
                    System.out.println("节点数据：" + event.getData().getPath() + " = " + new String(event.getData().getData()));
                }
            };
            cache.getListenable().addListener(cacheListener);
            client.create().creatingParentsIfNeeded().forPath("/example/pathCache/test01", "01".getBytes());
            Thread.sleep(10);
            client.create().creatingParentsIfNeeded().forPath("/example/pathCache/test02", "02".getBytes());
            Thread.sleep(10);
            client.setData().forPath("/example/pathCache/test01", "01_V2".getBytes());
            Thread.sleep(10);
            for (ChildData data : cache.getCurrentData()) {
                System.out.println("getCurrentData:" + data.getPath() + " = " + new String(data.getData()));
            }
            client.delete().forPath("/example/pathCache/test01");
            Thread.sleep(10);
            client.delete().forPath("/example/pathCache/test02");
            Thread.sleep(1000 * 5);
            cache.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
