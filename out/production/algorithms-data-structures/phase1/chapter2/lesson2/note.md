Q: java 中使用泛型时，不能将基本类型传入泛型，必须使用类型?

因为Java中的泛型是通过编译时的类型擦除来完成的，当泛型被类型擦除后都变成Object类型。但是Object类型不能指代像int，double这样的基本类型只能指代Integer，Double这样的引用类型。详情见：https://www.zhihu.com/question/47006557