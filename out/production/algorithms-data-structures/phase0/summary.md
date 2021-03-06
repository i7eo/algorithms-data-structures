# Java 基础

1. [程序基本机构](#程序基本机构)
2. [变量和数据类型](#变量和数据类型)
3. [整数运算](#整数运算)
4. [浮点数运算](#浮点数运算)
5. [布尔运算](#布尔运算)
6. [字符和字符串](#字符和字符串)
7. [数组类型](#数组类型)

## 程序基本机构

```java
/**
 * 可以用来自动创建文档的注释
 */
public class Hello {
    public static void main(String[] args) {
        // 向屏幕输出文本:
        System.out.println("Hello, world!");
        /* 多行注释开始
        注释内容
        注释结束 */
    }
} // class定义结束
```

1. 一个程序的基本单位就是 `class`，`class` 是关键字，这里定义的 `class` 名字就是 `Hello`
2. 类名要求：
    1. 类名必须以英文字母开头，后接字母，数字和下划线的组合
    2. 习惯以大写字母开头
3. 方法定义了一组执行语句，方法内部的代码将会被依次顺序执行
4. Java的每一行语句必须以分号结束
5. 我们注意到 `public` 除了可以修饰 `class` 外，也可以修饰方法。而关键字 `static`
   是另一个修饰符，它表示静态方法，后面我们会讲解方法的类型，目前，我们只需要知道，Java入口程序规定的方法必须是静态方法，方法名必须为 `main`，括号内的参数必须是 `String` 数组
6. // 后跟注释，idea 中加上TO DO 会高亮
7. mac 中 reformat code 快捷键是 `⌘+⇧+F`

## 变量和数据类型

`int x = 1;`

1. 在Java中，变量必须先定义后使用，在定义变量的时候，可以给它一个初始值。
2. 上述语句定义一个整型 `int` 变量，名称为 `x`，初始值为 `1`
3. 不写初始值相当于指定默认值，默认值为0

基本数据类型是 CPU 可以直接进行运算的类型。基本类型如下：

1. 整数类型：byte short int long
2. 浮点数类型：float double
3. 字符类型：char
4. 布尔类型：boolean

Java定义的这些基本数据类型有什么区别呢？要了解这些区别，我们就必须简单了解一下计算机内存的基本结构。

计算机内存的最小存储单元是字节（byte），一个字节就是一个8位二进制数，即8个bit。它的二进制表示范围从00000000~11111111，换算成十进制是0~255，换算成十六进制是00~
ff，计算机是用二进制来表示数据的，一个字节也就是 8 个比特位，其中最高位表示符号位（0 正 1 负）即范围

内存单元从0开始编号，称为内存地址。每个内存单元可以看作一间房间，内存地址就是门牌号。

0 1 2 3 4 5 6 ...
☐ ☐ ☐ ☐ ☐ ☐ ☐ ...

不同的数据类型占用的字节数不一样。我们看一下Java基本数据类型占用的字节数：

byte ☐

short ☐☐

int ☐☐☐☐

long ☐☐☐☐☐☐☐☐

float ☐☐☐☐

double ☐☐☐☐☐☐☐☐

char ☐☐

byte恰好就是一个字节，而long和double需要8个字节。

### 整型

对于整型类型，Java只定义了带符号的整型，因此，最高位的bit表示符号位（0表示正数，1表示负数）。各种整型能表示的最大范围如下：

- byte：-128 ~ 127（10000000～01111111）
- short: -32768 ~ 32767
- int: -2147483648 ~ 2147483647
- long: -9223372036854775808 ~ 9223372036854775807

### 浮点型

浮点类型的数就是小数，因为小数用科学计数法表示的时候，小数点是可以“浮动”的，如1234.5可以表示成12.345x102，也可以表示成1.2345x103，所以称为浮点数。

下面是定义浮点数的例子：

```
float f1 = 3.14f;
float f2 = 3.14e38f; // 科学计数法表示的3.14x10^38
double d = 1.79e308;
double d2 = -1.79e308;
double d3 = 4.9e-324; // 科学计数法表示的4.9x10^-324
```

对于float类型，需要加上f后缀。

浮点数可表示的范围非常大，`float` 类型可最大表示3.4x1038，而 `double` 类型可最大表示1.79x10308。

### 字符类型

字符类型 `char` 表示一个字符。Java的char类型除了可表示标准的ASCII外，还可以表示一个Unicode字符：

```java
public class Main {
    public static void main(String[] args) {
        char a = 'A';
        char zh = '中';
        System.out.println(a);
        System.out.println(zh);
    }
}
```

注意 `char` 类型使用单引号'，且仅有一个字符，要和双引号"的字符串类型区分开。

### 引用类型

除了上述基本类型的变量，剩下的都是引用类型。例如，引用类型最常用的就是String字符串：

`String s = "hello";`
引用类型的变量类似于C语言的指针，它内部存储一个“地址”，指向某个对象在内存的位置，后续我们介绍类的概念时会详细讨论。

### 常量

定义变量的时候，如果加上final修饰符，这个变量就变成了常量：

```
final double PI = 3.14; // PI是一个常量
double r = 5.0;
double area = PI * r * r;
PI = 300; // compile error!
```

常量在定义时进行初始化后就不可再次赋值，再次赋值会导致编译错误。根据习惯，常量名通常全部大写。

> var关键字
> 有些时候，类型的名字太长，写起来比较麻烦。例如：
> `StringBuilder sb = new StringBuilder();`
> 这个时候，如果想省略变量类型，可以使用var关键字：
> `var sb = new StringBuilder();`
> 编译器会根据赋值语句自动推断出变量sb的类型是StringBuilder。对编译器来说，语句：
> 实际上会自动变成：
> `StringBuilder sb = new StringBuilder();`

### 变量的作用范围

在Java中，多行语句用{ }括起来。很多控制语句，例如条件判断和循环，都以{ }作为它们自身的范围。

只要正确地嵌套这些{ }，编译器就能识别出语句块的开始和结束。而在语句块中定义的变量，它有一个作用域，就是从定义处开始，到语句块结束。超出了作用域引用这些变量，编译器会报错。

定义变量时，要遵循作用域最小化原则，尽量将变量定义在尽可能小的作用域，并且，不要重复使用变量名。

## 整数运算

## 浮点数运算

## 布尔运算

## 字符和字符串

```
char c1 = 'A'
```

和 `char` 类型不同，字符串类型 `String` 是引用类型，我们用双引号"..."表示字符串。一个字符串可以存储0个到任意个字符：

```
String s1 = "s1"
```

引用类型的变量可以指向一个空值null，它表示不存在，即该变量不指向任何对象。

```
String s1 = null; // s1是null
String s2; // 没有赋初值值，s2也是null
String s3 = s1; // s3也是null
String s4 = ""; // s4指向空字符串，不是null
```

## 数组类型

定义一个数组类型的变量，使用数组类型“类型[]”，例如，int[]。和单个基本类型变量不同，数组变量初始化必须使用new int[5]表示创建一个可容纳5个int元素的数组。

Java的数组有几个特点：

数组所有元素初始化为默认值，整型都是0，浮点型是0.0，布尔型是false；
数组一旦创建后，大小就不可改变。
要访问数组中的某一个元素，需要使用索引。数组索引从0开始，例如，5个元素的数组，索引范围是0~4。

可以修改数组中的某一个元素，使用赋值语句，例如：`ns[1] = 79;`

可以用数组变量.length获取数组大小

```
int[] ns = new int[5];
int[] ns = new int[] { 68, 79, 91, 85, 62 };
int[] ns = { 68, 79, 91, 85, 62 };
```

注意数组是引用类型，并且数组大小不可变。我们观察下面的代码：

```java
public class Main {
    public static void main(String[] args) {
        // 5位同学的成绩:
        int[] ns;
        ns = new int[]{68, 79, 91, 85, 62};
        System.out.println(ns.length); // 5
        ns = new int[]{1, 2, 3};
        System.out.println(ns.length); // 3
    }
}
```

数组大小变了吗？看上去好像是变了，但其实根本没变。详情查看：https://www.liaoxuefeng.com/wiki/1252599548343744/1255941599809248
