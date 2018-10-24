>多模块项目搭建 
```
1. web启动类入口目录
2. service依赖
3. 数据库访问使用tk下的通用mapper
4. zk
5. mongo
6. memcache


```


>任务列表
```
1.日志-√
2.redis-√
3.zk
4.mongo
6.mq [rocket,rabbit,kafka,active]
7.elk
8.cloud
9.distributed transaction tcc cap zab
10.guava系列
11.多环境-√
12.自定义参数和随机数-√
13.命令行参数启动jar包 java -jar xxx.jar --server.par七= 8888
14.mail
15.schedule
16.docker
17.thymeleaf
18.fastDfs 与文件上传
19.shiro
20.security
21. cassandra
22.多数据源


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
ac七ua七or 模块中已经实现的 一些原生端点。 根据端点的作用， 可以将原生端点分为以下三大类。
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