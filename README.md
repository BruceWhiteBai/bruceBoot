>多模块项目搭建  
```
1.vesta ,UidGender,百度发号器,snowflake
2.logback.xml 
3.docker maven 多module镜像
4.docker compose,swarn,k8s
5.rocketmq 事务消息
6.kafka降低延时
7.kafka消息有序
```


>任务列表
```
1.日志-√
2.redis-√  https://www.jianshu.com/p/7bf5dc61ca06
3.zk-√
4.mongo  
6.mq [rocket,rabbit,kafka,active]-√
7.elk [filebeat logstash es kibana]-√
8.cloud[bus,eureka,feign,hystrix,ribbon,sleuth,zuul] -√
9.分布式事务 tcc cap zab，最终一致性,最大努力通知型
10.guava系列 
11.多环境---√
12.自定义参数和随机数---√
13.命令行参数启动jar包 java -jar xxx.jar --server.port= 8888 ---√
14.mail ---√
15.schedule,定时任务,xxl-job,异步支持---√
16.docker[docker 镜像制作和持续集成] [swarn,compose,harbor,rancher Kubernetes]
17.thymeleaf-√
18.fastDfs 与文件上传 -√ [概念和原理相关笔记完善] [linux 集群 和 Nginx集成搭建 ]
19.shiro 
20.security
21.cassandra
22.多数据源
23.cas/jasig
24.https [证书购买,安装,重定向] [原理]
25.netty 
26.websocket 
27.servlet3
28.canal datax
29.flume [flume dfs hdfs]
30.storm/jstorm/flink
31.kong--api网关
32.yapi接口管理 ---√ 阿里云版搭建完成,官网未完成 todo 
33.pdf,excel,word,html,xml [文件生成与解析]
34.mycat,sharding-jdbc,dbsplit分库分表
35.asm字节码反编译工具
35.session与分布式session 
36.Nacos 微服务[https://mp.weixin.qq.com/s/l52giRP5UCj1DHPriLecFg]
37.rpc[dubbo,thrift,grpc,rmi,ice,springcloud] ---√
37.apollo配置中心 kubernetes docker namespace等知识点综合实战
39.Consul eureka
40.flywaydb 数据库版本控制
```

>参考地址

1.https://blog.csdn.net/guokezhongdeyuzhou/article/details/79789629

2.http://www.ityouknow.com/ 

3.https://www.cnblogs.com/haitao-xie/p/6323423.html

4.https://blog.csdn.net/Angry_Mills/article/details/79446770


>boot 属性加载顺序
```
#优先级从高到低依次为:
1 在命令行中传入的参数。
2. SPRING APPLICATION JSON中的属性。 SPRING_APPLICATION—JSON是以JSON格式配置在系统环境变量中的内容。
3. java:comp/env中的JNDI 属性。
4. Java的系统属性， 可以通过System.getProperties()获得的内容。
5. 操作系统的环境变量 。
6. 通过random.*配置的随机属性。
7. 位于当前应用 jar 包之外， 针对不同{profile}环境的配置文件内容， 例如application-{profile}.properties或是YAML定义的配置文件。
8. 位于当前应用 jar 包之内 ， 针对不同{profile}环境的配置文件内容，例如application-{profile}.properties或是YAML定义的配置文件。
9. 位于当前应用jar包之外的application.properties和YAML配置内容。
10.位于当前应用jar包之内的application.properties和YAML配置内容。
11.在@Configuration注解修改的类中，通过@PropertySource注解定义的属性。
12.应用默认属性，使用SpringApplication.se七DefaultProperties 定义的内容

```
>boot监控actuator
```
actuator 模块中已经实现的 一些原生端点。 根据端点的作用， 可以将原生端点分为以下三大类。
 • 应用配置类：获取应用程序中加载的应用配置、 环境变量、 自动化配置报告等与 SpringBoot应用密切相关的配置类信息。
    /autoconfig : 获取应用的自动化配置报告
    /beans : 获取应用上下文中创建的所有Bean
    /configprops: 获取应用中配置的属性信息报告
    /env : 获取应用所有可用的环境属性报告。 包括环境变量、jvm属性、应用的配置属性、命令行中的参数
    /mappings : 返回所有Spring MVC的控制器映射关系报告
     /info: 该端点用来返回 一些应用自定义的信息
 • 度量指标类：获取应用程序运行过程中用于监控的度量指标， 比如内存信息、 线程池信息、 HTTP请求统计等。
    /metrics: 提供应用运行状态的完整度量指标报告
    /health: 获取应用的各类 健康指标信息
    /dump: 该端点用来暴露程序运行中的线程信息
    /trace: 该端点用来返回基本的 HTTP 跟踪信息
     
 • 操作控制类：提供了对应用的关闭等操作类功能。
 
```
