## Redis本地安装

- 安装Homebrew

`/bin/zsh -c "$(curl -fsSL https://gitee.com/cunkai/HomebrewCN/raw/master/Homebrew.sh)`

- 安装redis

`brew install redis`

安装成功标志：

```==> Downloading https://mirrors.ustc.edu.cn/homebrew-bottles/bottles/redis-6.0.1
######################################################################## 100.0%
==> Pouring redis-6.0.1.mojave.bottle.tar.gz
==> Caveats
To have launchd start redis now and restart at login:
  brew services start redis
Or, if you don't want/need a background service you can just run:
  redis-server /usr/local/etc/redis.conf
==> Summary
🍺  /usr/local/Cellar/redis/6.0.1: 13 files, 3.7MB```
```

- 更改redis配置文件

切换到redis路径，然后打开配置文件：`vim redis.conf`，在Linux下搜索字段的快捷键是`/requirepass`,然后按enter键搜索，n表示下一个。将pass后面的修改为自己的密码。如下：

```\# aclfile /etc/redis/users.acl
# aclfile /etc/redis/users.acl
requirepass 12345678
# IMPORTANT NOTE: starting with Redis 6 "requirepass" is just a compatibility
# layer on top of the new ACL system. The option effect will be just setting
# the password for the default user. Clients will still authenticate using
# AUTH <password> as usually, or more explicitly with AUTH default <password>
# if they follow the new protocol: both will work.
#
# The requirepass is not compatable with aclfile option and the ACL LOAD
# command, these will cause requirepass to be ignored.
#
# requirepass foobared
```

- 启动redis（带配置文件启动）：

```
./redis-server ../myconf/redis.conf
```

```
40648:C 05 Aug 2021 10:07:59.373 # oO0OoO0OoO0Oo Redis is starting oO0OoO0OoO0Oo
40648:C 05 Aug 2021 10:07:59.373 # Redis version=6.2.5, bits=64, commit=00000000, modified=0, pid=40648, just started
40648:C 05 Aug 2021 10:07:59.373 # Configuration loaded
40648:M 05 Aug 2021 10:07:59.374 * Increased maximum number of open files to 10032 (it was originally set to 256).
40648:M 05 Aug 2021 10:07:59.374 * monotonic clock: POSIX clock_gettime
                _._                                                  
           _.-``__ ''-._                                             
      _.-``    `.  `_.  ''-._           Redis 6.2.5 (00000000/0) 64 bit
  .-`` .-```.  ```\/    _.,_ ''-._                                  
 (    '      ,       .-`  | `,    )     Running in standalone mode
 |`-._`-...-` __...-.``-._|'` _.-'|     Port: 6379
 |    `-._   `._    /     _.-'    |     PID: 40648
  `-._    `-._  `-./  _.-'    _.-'                                   
 |`-._`-._    `-.__.-'    _.-'_.-'|                                  
 |    `-._`-._        _.-'_.-'    |           https://redis.io       
  `-._    `-._`-.__.-'_.-'    _.-'                                   
 |`-._`-._    `-.__.-'    _.-'_.-'|                                  
 |    `-._`-._        _.-'_.-'    |                                  
  `-._    `-._`-.__.-'_.-'    _.-'                                   
      `-._    `-.__.-'    _.-'                                       
          `-._        _.-'                                           
              `-.__.-'                                               

40648:M 05 Aug 2021 10:07:59.386 # Server initialized
40648:M 05 Aug 2021 10:07:59.386 * Ready to accept connections
40648:M 05 Aug 2021 11:08:00.058 * 1 changes in 3600 seconds. Saving...
40648:M 05 Aug 2021 11:08:00.062 * Background saving started by pid 71132
71132:C 05 Aug 2021 11:08:00.066 * DB saved on disk
```

启动成功！

- 退出redis服务

```
control + c
```

- 启动redis客户端：

```
redis-cli -h 127.0.0.1 -p 6379
```

Mac版本有redis的可视化界面，App Store下载。

## Redis上手-IDEA

- SpringBoot配置依赖

```java
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-redis</artifactId>
    <version>1.4.7.RELEASE</version>
</dependency>
```

- 在yml中配置路径和使用哪个数据库

```java
spring:
	redis:
    password: 12345678
    database: 0
```

如果使用的是本地url，那么username和url会有默认值。所以就不用配置了。

测试：

```java
@Autowired
RedisTemplate redisTemplate;

@Test
public void testRedis(){
	redisTemplate.opsForValue().set("me","王有浪");
	System.out.println(redisTemplate.opsForValue().get("me"));
}
```







