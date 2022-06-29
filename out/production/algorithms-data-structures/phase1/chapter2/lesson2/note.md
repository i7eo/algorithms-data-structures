Q: 双 for 时间复杂度？

n + (n - 1) + ... + 2 + 1 = n^2/2 + n/2 => 丢掉低阶和常数得出 O(n^2)

Q: java 中使用泛型时，不能将基本类型传入泛型，必须使用类型?

因为Java中的泛型是通过编译时的类型擦除来完成的，当泛型被类型擦除后都变成Object类型。但是Object类型不能指代像int，double这样的基本类型只能指代Integer，Double这样的引用类型。详情见：https://www.zhihu.com/question/47006557