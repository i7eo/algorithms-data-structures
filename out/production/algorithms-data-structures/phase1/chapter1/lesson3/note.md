# 复杂度分析

表示算法性能

## 示例

```
1 public static <T> int search(T[] data, T target) {
2     for (int i = 0; i < data.length; i++) {
3       if (data[i].equals(target)) {
4         return i;
5       }
6     }
7     return -1;
8 }
```

注意事项：

- 通常看最差的情况
- 复杂度分析：
    1. 数据规模 n = data.length
    2. T = n (循环n次)
    3. T = 2n (除了循环，if也得每次进行判断)
    4. T = 3n T = 4n T = 5n T = 5n+2
    5. 每个人都有不同想法，但是正儿八经要分析的话得先拿到编译后的二进制代码，在拿到二进制代码对应的机器指令，再看看本机是arm还是x64架构，查看指令集等
- 上述单位是 ms 吗？不，他的单位是条，意味着有这么多条指令
- 所以最终人们使用 O(n) 来表示时间复杂度，意义是描述该算法与数据规模n的关系
- 在算法复杂度的表示中，常数并不重要。复杂度描述的是随着数据规模n的增大，算法性能的变化趋势

`O(1) < O(logn) < O(根号n) < O(n) < O(nlogn) < O(n^2) < O(2^n) < O(n!)` 