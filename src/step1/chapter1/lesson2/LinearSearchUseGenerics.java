package step1.chapter1.lesson2;

// 基本数据类型为：
// boolean byte char short int long float double

// java 中泛型不可以为基本数据类型，只能是类对象
// 为了解决这个问题，java 为每个基本类型添加了包装类来进行自由转换

// 基本数据类型包装类为：
// Boolean Byte Character Short Integer Long Float Double

import step1.chapter1.lesson4.ArrayGenerator;

public class LinearSearchUseGenerics {
  private LinearSearchUseGenerics() {}

  public static <T> int search(T[] data, T target) {
    for (int i = 0; i < data.length; i++) {
      // 此时函数传入的是俩个包装类对象，要将下面的判断条件改为值相等
      //            if(data[i] == target) {
      //                return i;
      //            }
      if (data[i].equals(target)) {
        return i;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    //        int[] data = {24,14,12,9,16,32,66,4};
    Integer[] data = {24, 14, 12, 9, 16, 32, 66, 4};

    // data 需要手动用 Integer 包装，16 java 自动包装
    int result = LinearSearchUseGenerics.search(data, 16);
    System.out.println(result);
    int result2 = LinearSearchUseGenerics.search(data, 666);
    System.out.println(result2);

    Student[] students = {new Student("eva"), new Student("i7eo")};
    Student target = new Student("i7eo");
    int result3 = LinearSearchUseGenerics.search(students, target);
    System.out.println(result3); // -1 类对象调用equals时比较的是类地址，如果希望比较值则需自己重写equals方法

    int n = 1000000;
    Integer[] data2 = ArrayGenerator.generateOrderedArray(n);
    long startTime = System.nanoTime();
    LinearSearchUseGenerics.search(data2, n);
    long endTime = System.nanoTime();
    double time = (endTime - startTime) / 1000000000.0;
    System.out.println(time + "s");
  }
}
