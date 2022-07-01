package phase1.chapter2.lesson2;

import helper.ArrayGenerator;
import helper.SortHelper;

public class SelectionSort {
  private SelectionSort() {}

  public static <T> void swap(T[] arr, int i, int j) {
    T t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
  }

  /**
   * 选择排序：循环来找当前最小的，并且把最小的元素和 i 进行交换，把最小的元素交换到数组前部，达到排序（升序）效果 扩展泛型，表示传入的类型必须能实现 Comparable（比较接口）
   *
   * @param arr
   * @param <T>
   */
  public static <T extends Comparable<T>> void sort(T[] arr) {
    // 1. 正序循环
    //    for (int i = 0; i < arr.length; i++) {
    //      int minIdx = i;
    //      for (int j = i; j < arr.length; j++) {
    //        if (arr[j].compareTo(arr[minIdx]) < 0) {
    //          minIdx = j;
    //        }
    //      }
    //      swap(arr, i, minIdx);
    //    }

    // 2. 倒序循环
    //    for (int i = arr.length - 1; i > -1; i--) {
    //      int minIdx = i;
    //      for (int j = i; j > -1; j--) {
    //        if (arr[j].compareTo(arr[minIdx]) < 0) {
    //          minIdx = j;
    //        }
    //      }
    //      // 倒序的时候不能换 i, minIdx，因为此时的 i 为尾部位置，如果此时交换则将最小的放到了尾部成了降序，不符合要求
    //      // 这里一定要搞清楚索引是标识位置的关键
    //      swap(arr, i, minIdx);
    //    }

    // 基于2中发现的问题，如果还是按照2的思路我们需要开辟新的空间来控制循环不变量（即把最小的值放到前部但是因为倒序循环，最终排序好的元素还是会再次进入循环）
    // 既然倒序取最小值，最小值会因为索引是倒序的被放到数组后部，那我们直接取最大值即可
    for (int i = arr.length - 1; i > -1; i--) {
      int maxIdx = i;
      for (int j = i; j > -1; j--) {
        if (arr[j].compareTo(arr[maxIdx]) > 0) {
          maxIdx = j;
        }
      }
      swap(arr, i, maxIdx);
    }
  }

  public static void main(String[] args) {
    //    int[] arr = { 1,4,2,3,6,5 };
    //    SelectionSort.sort(arr); // no instance(s) of type variable(s) T exist so that int[]
    // conforms to T[]

    //    Integer[] arr = {1, 4, 2, 3, 6, 5};
    //    SelectionSort.sort(arr);
    //    for (int e : arr) {
    //      System.out.print(e + " ");
    //    }
    //    System.out.println();
    //
    //    Student[] students = {
    //      new Student("Alice", 98), new Student("i7eo", 95), new Student("Eva", 100),
    //    };
    //    SelectionSort.sort(students);
    //    for (Student student : students) System.out.print(student + " ");
    //    System.out.println();

    // 使用chapter1中的ArrayGenerator生成大数据数组来测试性能
    //    int max = 10000;
    //    Integer[] arr = ArrayGenerator.generateRandomArray(max, max);
    //    SortHelper.sortTest("SelectionSort", arr);
    int[] dataSize = {10, 10};
    for (int n : dataSize) {
      Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
      //      SortHelper.sortTest("phase1.chapter2.lesson2.SelectionSort", arr);
      String classPath = SelectionSort.class.getCanonicalName();
      SortHelper.sortTest(classPath, arr);
    }
  }
}
