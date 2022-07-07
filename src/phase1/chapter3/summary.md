# 数据结构基础

数据结构提供了组织、存储数据的功能，主要实现的就是增删改查

## 线性结构

- 数组
- 栈
- 队列
- 链表
- 哈希表

## 树结构

- 二叉树
- 二分搜索树
- AVL
- 红黑树
- Treap
- Splay
- 堆
- Trie
- 线段树
- K-D树
- 并查集
- 哈夫曼树

## 图结构

- 邻接矩阵（二维数组）
- 邻接表（链表数组）

# 生活中的例子

## 数据库

1. 在外存中存储数据，海量数据必然需要高效的数据结构来存储数据。用到的结构有：AVL、红黑树、B类树、哈希表
    ```roomsql
    SELECT * FROM "i7eo" WHERE title = "github"
    ``` 
2. 操作系统中的优先队列（所有的进程）、内存管理、内存堆栈、文件管理
3. 文件压缩（哈夫曼树）
4. 图论领域中的寻路算法（dfs/bfs 中利用数据结构的特性：组织数据，来完成逻辑执行时数据的正常流转）