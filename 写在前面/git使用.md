# Git使用

## 1.在github上创建仓库并上传

提高git速度的命令：

```java
export https_proxy=http://127.0.0.1:7890 http_proxy=http://127.0.0.1:7890 all_proxy=socks5://127.0.0.1:7890
```

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

修改用户名和邮箱

```java
git config --global --replace-all user.name "你的名字或昵称"
git config --global --replace-all user.email "你的邮箱"
```



#### 初始化版本库

```java
git init 
git echo "readme内容" >>README.me
git add .
git commit -m "first commit"
git branch -M master
git remote add origin <你的项目地址> //注:项目地址形式为http://git.oschina.net/xxx/xxx.git或者 git@git.oschina.net:xxx/xxx.git 比如(git remote add https://github.com/wangyoulang/Mynote.git
)
git push -u master
```

#### 提交版本

```java
git pull origin master //写之前拉远程代码
git add . //将你的代码加入到git版本监控中
git commit -m "你的注释" //提交代码
git push origin master //push代码
```

## 2.获取git的ssh秘钥和公钥

- 确定电脑上是否有ssh key

```java
cd ~/.ssh
ls
```

- 创建SSH key

```java
ssh-keygen -t rsa -C "your_email@example.com"
```

然后生成ssh的文件夹和ssh key的密码都可以默认，都按enter键就好

![img](https://upload-images.jianshu.io/upload_images/4395232-1f03efa406d5176f.png)

- 复制ssh key

```java
vim ~/.ssh
//然后复制文件内容到github上
```

![image-20210822001031178](C:\Users\17599\AppData\Roaming\Typora\typora-user-images\image-20210822001031178.png)

这样就OK了。
