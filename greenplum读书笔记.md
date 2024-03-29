# 第四章 gp快速入门

## 4.2 gp数据库的特性

- 开源

- 超大规模和高性能

  > gp数据库除了支持给予PostgreSQL查询优化器之外，还专门开发了一个新的查询优化器ORCA。orca时一款自顶向下的基于cascades框架的查询优化器。

- 高可用性

  > gp提供多级容错确保系统的高可用性。主节点master通过standby master进行备份，并且每个数据节点primary segment分别配置一个mirror segment节点进行备份，同时确保同一组primary segment和mirror segment不再同一个物理机，降低由于宕机而导致的数据丢失的风险。

- 通用型

  > gp拥有完善的sql标准支持。因为gp基于PostgreSQL，因此继承了PostgreSQL对于jdbc、odbc、c、python API等接口的支持。gp数据库的通用型确保了任何应用程序都可以方便的与之继承并进行数据访问。

- 多态存储

  > 用户可以根据数据热度或者访问模式不同而使用不同的存储方式，以获得更好的查询性能。
  >
  > 在gp数据库中，一张表的数据水平分割到各个节点，用户可以为一张表按照一定的规则（比如日期）创建分区表。一张表的各个子分区可以使用不同的物理存储方式。
  >
  > - 行存储：数据以行的形式存储在数据页里，适合频繁更新的查询；
  > - 列存储：数据以列的形式存储在数据页里，适合olap分析性查询；（olap：联机分析处理）
  > - 外部表：数据保存在其他文件系统中，比如HDFS、S3，数据库只保留元数据信息。

- 高扩展性和高效资源管理

  > MPP是无共享框架，gp数据库具有良好的、线性的在线扩展能力。用户可以为运行中的gp数据库增加硬件资源。
  >
  > gp数据库提供了高效的资源管理机制，根据用户的业务逻辑讲资源合理的分配给查询任务，避免查询任务因资源不足而得不到响应。gp资源管理主要包括对并发查询数量的限制，查询执行时内存、cpu资源使用的限制。同时，gp在资源管理方面也提供了多级保证，在数据库连接（connection）级别上，可以控制用户接入的数量；在数据库会话（session）级别上，可以设定每个用户的资源组来管理任务进入的情况，同时控制查询并发和查询内存、cpu资源的使用占比；在查询语句级别上，可以为查询语句设置优先级，并且在语句执行中实时调整，从而优化待定查询，缩短其运行时间。gp数据库提供两种资源管理方式：资源队列和资源组。

- 高效数据加载

  > gp数据库利用mpp架构可以高效的并行加载数据，允许数据从多个文件系统通过多个物理主机上的多个网卡进行加载，从而达到非常高的数据传输率。

- 高级数据分析

  > gp数据库支持各种过程化编程语言：postgresql、R、Python、Java、perl等语言的扩展。
  >
  > ![image-20221127230250825](/Users/wyl/Library/Application Support/typora-user-images/image-20221127230250825.png)

- 良好的监控管理和运维体验

  > ![image-20221127230349353](/Users/wyl/Library/Application Support/typora-user-images/image-20221127230349353.png)

## 4.3 gp数据库的组成

> gp数据库是典型的master/Slave架构，集群通常由一个master节点、一个standby master节点以及多个segment节点组成，节点之间通过告诉网络互相连接。他们之间的关系是：
>
> standby master为master提供高可用，mirror segment为segment提供高可用。
>
> 高可用：主要解决节点宕机问题。
>
> ![image-20221128230913116](/Users/wyl/Library/Application Support/typora-user-images/image-20221128230913116.png)

## 4.4 gp数据库的安装与部署

