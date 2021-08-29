# JVM

# 一.内存区域与内存异常

## 1.运行时数据区

### 1.1.程序计数器

用来记录字节码指令地址。

### 1.2.虚拟机栈

线程的每个方法的调用和退出对应着栈帧的入栈和出栈。

本地变量表，有reference。

异常有两个

- StackOverflowError：超出栈最大深度
- OutOfMemoryError：超出内存

### 1.3.本地方法栈

存本地方法，为native方法服务。也会有StackOver和OutOfMemory异常

### 1.4.堆

存放对象实例和数组

如果堆没有分配完对象实例，并且不能扩展的时候，抛出OutOfMemory。

### 1.5.方法区

存类的加载信息，常量、静态变量和即时编译器代码。

#### 运行时常量池

属于方法区的一部分，存放编译器和运行期的字面量和引用。

## 2.HotSpot虚拟机对象创建

### 2.1.对象创建方式

#### 1.new

通过构造函数创建对象

#### 2.Class类的反射机制

```java
Student st = Student.class.newInstance();
Class的newInstance方法内部调用的也是Constructor的newInstance方法。
```

#### 3.Conctructor类的newInstance方法

```java
Constructor con = Student.class.getConstructor();
Student st = con.newInstance();
```

#### 4.使用clone方法

类需要实现Cloneable接口，重写clone方法。clone方法创建对象不使用构造器。

#### 5.反序列化机制

类需要实现Serializable接口

### 2.2对象创建过程

- 第一步，先分配内存，存放对象实例变量，这些变量有自己的，也有从父类继承的变量
- 第二步，初始化，按先后顺序分别初始化对象实例变量、代码块、构造函数

```java
public class InstanceVariableInitializer {  
	//第一步，初始化变量
    private int i = 1;  
    private int j = i + 1;  
	//第三步，初始化构造函数
    public InstanceVariableInitializer(int var){
        System.out.println(i);
        System.out.println(j);
        this.i = var;
        System.out.println(i);
        System.out.println(j);
    }
	//第二步，初始化代码块
    {               // 实例代码块
        j += 3; 

    }

    public static void main(String[] args) {
        new InstanceVariableInitializer(8);
    }
}/* Output: 
            1
            5
            8
            5
 *///:~
```

在实例化类之前，必须实例化其超类，其超类又会实例化超类，直到object被实例化。

```ini
虚拟机字节码指令遇到new指令 -> 类加载检查 -> 在堆中分配内存空间-> 填充对象头
```

### 2.3对象头的内存

- 对象头，有MarkWord，类型指针，指向它的类的元数据指针。如果对象是数组，还需要一个记录数组大小的数据。
- 实例数据，存储对象属性数据，包括从父类继承的属性。
- 对其填充，主要是占位，保证对象大小是某个字节的整数倍。

### 2.4.对象的访问

java通过reference操作堆中的指针。

##### 句柄

句柄池在堆中划分，reference存储句柄地址。然后句柄访问对象。

##### 指针

reference直接存储对象地址。

# 二.垃圾回收

## 1.对象已死？

### 引用计数法

对象有引用，计数器+1，计数器的值任何时候都为0，则不可能被引用。但是如果两个对象之间相互循环引用，那么计数器就失效。因为它们相互引用，即便对象已经不会再使用了，但是计数器的值总不为0。

### 可达性分析

从GC roots对象向下搜索，搜索时候走过的路径叫做引用链，当一个对象到GC roots没有引用链与它相连，则说明这个对象可以回收了。

哪些对象可以作为GCroots对象？

- 虚拟机栈的引用对象

- 方法区的静态引用对象
- 方法区的常量引用对象
- 本地方法栈的引用对象

### 引用

- 强引用：GC不会回收这些对象
- 软引用：只有快要发生内存溢出时候，才会回收这些对象。它们有些用，但是并非必须的对象。属于鸡肋。
- 弱引用：非必须引用，只能活到下一次GC
- 虚引用





