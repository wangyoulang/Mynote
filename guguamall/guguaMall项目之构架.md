# 架构篇

### 构建一个Springboot项目

> 写配置文件application.yml
>
> 配置端口号和数据库：
>
> ```yml
> server:
>   port: 8080
> spring:
>   datasource:
>     url: jdbc:mysql://127.0.0.1:3306/mall?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
>     name: root
>     password: root
> ```
>
> 配置数据库扫描路径
>
> ```yml
> mybatis:
>   mapper-locations:
>     - classpath:mapper/*.xml
>     - calsspath*:com/**/mapper/*.xml
> ```
>
> 使用mybatis-generator自动生成代码。

### Swagger-UI实现在线文档

> - 常用注解
>
> ```区块
> @Api:修饰controller类
> @ApiOperation：修饰controller方法
> @ApiParam：修饰接口中的参数
> @ApiModelProperty：修饰实体类的属性，当实体类是接口的请求参数或者返回结果时，生成在现文档。
> ```
>
> - 整合swagger
>
> > 添加相关依赖
>
> ```xml
> 				<dependency>
>             <groupId>io.springfox</groupId>
>             <artifactId>springfox-swagger2</artifactId>
>             <version>2.7.0</version>
>         </dependency>
>         <dependency>
>             <groupId>io.springfox</groupId>
>             <artifactId>springfox-swagger-ui</artifactId>
>             <version>2.7.0</version>
>         </dependency>
> ```
>
> 添加注解，运行之后可以查看[接口信息](http://localhost:8080/swagger-ui.html)

### redis实现缓存功能

> - 添加依赖
>
> ```xml
> <!--redis依赖配置-->
> <dependency>
>   <groupId>org.springframework.boot</groupId>
>   <artifactId>spring-boot-starter-data-redis</artifactId>
> </dependency>
> ```
>
> - 在Spring节点下添加redis配置
>
> ```yml
>   redis:
>     host: localhost # Redis服务器地址
>     database: 0 # Redis数据库索引（默认为0）
>     port: 6379 # Redis服务器连接端口
>     password: # Redis服务器连接密码（默认为空）
>     jedis:
>       pool:
>         max-active: 8 # 连接池最大连接数（使用负值表示没有限制）
>         max-wait: -1ms # 连接池最大阻塞等待时间（使用负值表示没有限制）
>         max-idle: 8 # 连接池中的最大空闲连接
>         min-idle: 0 # 连接池中的最小空闲连接
>     timeout: 3000ms # 连接超时时间（毫秒）
> ```
>
> - 自定义key配置
>
> ```yml
> # 自定义redis key
> redis:
>   key:
>     prefix:
>       authCode: "portal:authCode:"
>     expire:
>       authCode: 120 # 验证码超期时间
> ```
>
> 

