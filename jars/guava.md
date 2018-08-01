>手动安装jar包
```
google guava jar的2种使用方式
1.手动下载安装
mvn install:install-file -Dfile=E:\google\guava\guava-14.0-rc3.jar\guava-14.0-rc3.jar -DgroupId=com.google.guava -DartifactId=guava -Dversion=14.0-rc3 -Dpackaging=jar

2.使用Google坐标
<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>20.0</version> 
</dependency>

该jar包在maven  repository 中有jre ,Android ，23.0等版本
java这块用整数版本即可
```
>guava
```$xslt
1.annotation
2.base
3.cache
4.collect
5.escape
6.eventbus
7.graph
8.hash
9.html
10.io
11.math
12.net
13.primitives
14.reflect
15.util.concurrent
16.xml

```