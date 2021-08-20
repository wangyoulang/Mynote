### 快速上手redis

#### springboot 配置Redis

```xml
<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

然后在配置文件中配置基本的host ，password 等等信息。

可以去autoconfiguration里面去找对应的配置文件。

#### springboot使用redis

```java
@SpringBootTest
class MybatisPlusDemoApplicationTests {
	//注入redisTemplate
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads()  {
        redisTemplate.opsForValue().set("test","chen");
        redisTemplate.boundValueOps("test");
        System.out.println(redisTemplate.opsForValue().get("test"));
    }
}
```

不过一般我们都会写一个工具类，来帮助我们使用。

#### springboot自定义redistemplate

```java
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        template.setStringSerializer(stringRedisSerializer);
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
```

### redis rdb

rdb是redis 默认的持久化规则。

### redis aof

aof 没有默认开启，需要去配置里面设置为yes

> 重写规则说明

因为aof是文件的无限追加，所以文件大小会越来越大，如果aof文件大于 `auto-aof-rewrite-min-size`设定的值，就会fork一个新的线程来将我们的文件进行重写！

```bash
appendonly no #默认是不开启aof模式的，默认是使用rdb方式持久化的，在大部分所有的情况下，rdb完全够用！
appendfilename "appendonly.aof" #持久化的文件的名字
#appendfsync always #每次修改都会sync。消耗性能
appendfsync everysec #每秒执行一此sync ，可能会丢失一秒的数据！
#appendfsync no #不执行 sync，这个时候操作系统自己同步数据，速度最快！
```

> aof的优点和缺点

优点：

- 每一次修改都同步，文件的完整会更加好
- 每秒同步一次，可能会丢失一秒的数据
- 从不同步，效率最高

缺点：

- 相对于数据文件来说，AOF远远大于rdb，修复的速度也比rdb慢！
- Aof运行效率也要比rdb慢，所以我们redis默认的配置就是rdb持久化。

### 知识点拓展

- RDB持久化方式能够在指定的时间间隔内对你的数据进行快照存储
- AOF持久化方式记录每次对服务器写的操作，当服务器重启的时候会重新执行这些命令来恢复原始的数据，AOF命令以Redis协议追加保存每次写的操作道文件末尾，Redis还能对文件进行后台重写，使得AOF文件的体积不至于过大。
- 只做缓存，如果你只希望你的数据在服务器运行的时候存在，你也可以不使用任何持久化。

### Redis订阅发布

Redis发布订阅是一种消息通信模式：发送者（pub）发送消息，订阅者（sub）接受消息。

Redis可以订阅任意数量的频道。

**类似于消息队列**



> 订阅一个频道

```bash
SUBSCRIBE xxxxxx
```

![image-20210511194813192](C:\Users\陈俊宏\AppData\Roaming\Typora\typora-user-images\image-20210511194813192.png)

> 发送一个消息到某个频道

```bash
PUBLISH xxxxxx "信息"
```

![image-20210511194749792](C:\Users\陈俊宏\AppData\Roaming\Typora\typora-user-images\image-20210511194749792.png)

### Redis主从复制

 只需要配置从库，不用配置主库！

```bash
127.0.0.1:6379> info replication
# Replication
role:master
connected_slaves:0
master_failover_state:no-failover
master_replid:c6e2836188e355c4466901d2967562adde13f9d0
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:0
second_repl_offset:-1
repl_backlog_active:0
repl_backlog_size:1048576
repl_backlog_first_byte_offset:0
repl_backlog_histlen:0

```

复制几个配置文件，然后修改对应的信息:

- 端口
- pid名字
- log文件名字
- dump.rdb名字

 在从机中执行

```bash
SLAVEOF host port
```

当前从机就会变成从机角色

![image-20210511213138786](C:\Users\陈俊宏\AppData\Roaming\Typora\typora-user-images\image-20210511213138786.png)



启动就变成从机，在配置文件中 将 `replicaof`[主机地址]和`masterauth`[主机密码] 配置起来就可以了。

从机只能读完，不能写入。

主机断开连接后，重新连接后依然可以读取到主机的信息。 



> 变成主机

```bash
SLAVEOF no one 
```

这样就把当前的变成了主机。