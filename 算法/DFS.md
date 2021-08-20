## DFS深度遍历算法

在一个分支上尽可能深的遍历每一种可能。

**回溯 = dfs + 剪支**

### [526.优美的排序](https://leetcode-cn.com/problems/beautiful-arrangement/)

> 假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：
>
> 第 i 位的数字能被 i 整除
> i 能被第 i 位上的数字整除
> 现在给定一个整数 N，请问可以构造多少个优美的排列？
>
> 1. **N** 是一个正整数，并且不会超过15。
>
> > 输入: 2
> > 输出: 2
> > 解释: 
> >
> > 第 1 个优美的排列是 [1, 2]:
> >   第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
> >   第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除
> >
> > 第 2 个优美的排列是 [2, 1]:
> >   第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
> >   第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除

dfs参数分析

```java
int n;//终止条件
int result;
List<Integer> curr;//存放中间结果
boolean[] vis;//存放路径是否访问过
int index;//递归条件
int[] source//原数据组成的数组
```

先写一个遍历所有组成的dfs,比如source = [1,2]，那么result有：[1,1]、[1,2]、[2,1]、[2,2]

```java
void dfs(int n,int result,List<Integer> curr,int index,int[] source)
  if(curr.size() == n){
    result.add(curr);
    return;
  }
	if(index == n){
    return;
  }
	for(int i = 0;i < n;i ++){
    curr.add(source[i]);
    dfs(n,result,curr,i,source);
    curr.remove(curr.size() - 1);
  }
}
```

然后实现有记忆搜索（即不重复搜索）result:[1,2]\[2,1]

```java
void dfs(int n,List<List<Integer>> result,List<Integer> curr,int index,int[] source,boolean[] vis){
  if(curr.size() == 0){
    result.add(curr);
    return;
  }
  if(index == n){
    return;
  }
  for(int i = 0;i < n;i ++){
    if(!vis[i]){
      curr.add(source[i]);
    	dfs(n,result,curr,i,source,vis);
    	curr.remove(curr.size() - 1);
    	vis[i] = false;
    } 
  }
}
```

最后实现这道题（时间：69，空间39.8）

```java
void dfs(int n,List<List<Integer>> result,List<Integer> curr,int index,int[] source,boolean[] vis){
  if(curr.size() == n){
    result.add(new ArrayList<>(curr));
    return;
  }
  if(index == n){
    return;
  }
  for(int i = 0;i < n;i ++){
    if(!vis[i] && (i % source[i] == 0 || source[i] % i == 0)){
      vis[i] = true;
      curr.add(source[i]);
      dfs(n,result,curr,i,source,vis);
      curr.remove(curr.size() - 1);
      vis[i] = false;
    }
  }
}
```

```java
//优化（时间54，空间35）
private int result = 0;
public static void dfs(int n,int index,boolean[] vis,int subscript){
  if(subscript > n){
    result ++;
    return;
  }
  if(index == n){
    return;
  }
  for(int i = 0;i < n;i ++){
    if(!vis[i] && ((subscript % (i + 1) == 0 || (i + 1) % subscript == 0))){
      subscript ++;
      vis[i] = true;
      dfs(n,curr,i,source,vis,subscript);
      vis[i] = false;
      subscript --;
    }
  }
}
```

