# 数组操作

1. [遍历数组](#遍历数组)
2. [数组排序](#数组排序)
3. [多维数组](#多维数组)
4. [命令行参数](#命令行参数)

## 遍历数组

for 循环

```java
public class Main {
    public static void main(String[] args) {
        int[] ns = {1, 4, 9, 16, 25};
        for (int i = 0; i < ns.length; i++) {
            int n = ns[i];
            System.out.println(n);
        }
    }
}
```

for each 循环

```java
public class Main {
    public static void main(String[] args) {
        int[] ns = {1, 4, 9, 16, 25};
        for (int n : ns) {
            System.out.println(n);
        }
    }
}
```

注意：在for (int n : ns)循环中，变量n直接拿到ns数组的元素，而不是索引。

显然for each循环更加简洁。但是，for each循环无法拿到数组的索引，因此，到底用哪一种for循环，取决于我们的需要。

直接打印数组变量，得到的是数组在JVM中的引用地址：

```
int[] ns = { 1, 1, 2, 3, 5, 8 };
System.out.println(ns); // 类似 [I@7852e922
```

这并没有什么意义，因为我们希望打印的数组的元素内容。因此，使用for each循环来打印它：

```
int[] ns = { 1, 1, 2, 3, 5, 8 };
for (int n : ns) {
    System.out.print(n + ", ");
}
```

使用for each循环打印也很麻烦。幸好Java标准库提供了Arrays.toString()，可以快速打印数组内容：

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ns = {1, 1, 2, 3, 5, 8};
        System.out.println(Arrays.toString(ns));
    }
}
```

## 多维数组

## 数组排序

```java
public class Main {
    public static void main(String[] args) {
        int[][] ns = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int[] arr0 = ns[0];
        System.out.println(arr0.length); // 4
    }
}
```

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] ns = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(Arrays.deepToString(ns));
    }
}
```

## 命令行参数

```java
public class Main {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
```