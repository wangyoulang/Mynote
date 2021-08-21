# Git使用

## 1.在github上创建仓库并上传

### 1.1仓库的操作

```java
仓库路径查看：git remote -v
删除指定的远程仓库：git remote rm origin
修改远程仓库地址：git remote set-url origin <remote-url>
添加远程仓库：git remote add origin <你的项目地址> //注:项目地址形式为:https://gitee.com/xxx/xxx.git或者 git@gitee.com:xxx/xxx.git
```

### 1.2 本地初始化一个项目

<img src="/Users/zhiyi/Library/Application Support/typora-user-images/image-20210821175138735.png" alt="image-20210821175138735" style="zoom:50%;" />

<img src="/Users/zhiyi/Library/Application Support/typora-user-images/image-20210821175430982.png" alt="image-20210821175430982" style="zoom:50%;" />



#### 配置git

```java
git config --global user.name "你的名字或昵称"
git config --global user.email "你的邮箱"
```

#### 初始化版本库

```java
git init 
git remote add origin <你的项目地址> //注:项目地址形式为http://git.oschina.net/xxx/xxx.git或者 git@git.oschina.net:xxx/xxx.git
```

#### 第一次提交版本

```java
git pull origin master //拉远程代码
git add . //将你的代码加入到git版本监控中
git commit -m "第一次提交" //提交代码
git push origin master //push代码
```

