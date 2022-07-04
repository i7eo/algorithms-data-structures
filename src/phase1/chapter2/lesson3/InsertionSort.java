package phase1.chapter2.lesson3;

import helper.ArrayGenerator;
import helper.SortHelper;

import java.util.Arrays;

public class InsertionSort {
  private InsertionSort() {}

  public static <T> void swap(T[] arr, int i, int j) {
    T t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
  }

  /**
   * 这样不行的原因是如果用 j 和 i 比较，则并不会对子序列产生影响，而插入排序的思想是子序列要有序，所以必须是子序列逐一比较
   *
   * @param arr
   */
  //  public static void sort0(int[] arr) {
  //    for (int i = 1; i < arr.length; i++) {
  //      for (int j = i - 1; j >= 0; j--) {
  //        if (arr[i] < arr[j]) {
  //          int t = arr[i];
  //          arr[i] = arr[j];
  //          arr[j] = t;
  //        }
  //      }
  //    }
  //  }

  /**
   * 思路： 用当前值与子序列一一比较后，进行交换。 交换完毕后为了防止第二层循环丢失索引位置，所以需要swapIdx来记录
   *
   * @param arr
   */
  //  public static void sort(int[] arr) {
  //    for (int i = 1; i < arr.length; i++) {
  //      int swapIdx = i;
  //      for (int j = i - 1; j > -1; j--) {
  //        if (arr[swapIdx] < arr[j]) {
  //          swap(arr, j, swapIdx);
  //          swapIdx = j;
  //        }
  //      }
  //    }
  //  }

  public static <T extends Comparable<T>> void sort(T[] arr) {
    for (int i = 0; i < arr.length; i++) {
      //      for (int j = i; j - 1 >= 0; j--) {
      //        if (arr[j].compareTo(arr[j - 1]) < 0) {
      //          swap(arr, j, j - 1);
      //        } else {
      //          break;
      //        }
      //      }
      for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
        swap(arr, j, j - 1);
      }
    }
  }

  /**
   * 因为swap中包含三个赋值操作，这里不使用swap，使用一个暂存变量，只进行一次赋值即可 swap 的交换 arr[i] 这是对数组的寻址操作，数量级上来后性能提升很明显。
   * 但这只是常数级别的优化，寻址的优化取决于 jvm 优化，最终的时间复杂度还是没有变
   *
   * @param arr
   * @param <T>
   */
  public static <T extends Comparable<T>> void sort2(T[] arr) {
    for (int i = 0; i < arr.length; i++) {
      T t = arr[i];
      Integer j;
      for (j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j--) {
        arr[j] = arr[j - 1];
      }
      arr[j] = t;
    }
  }

  public static void main(String[] args) {
    //    int[] arr = {6, 3, 2, 5, 1, 4};
    //    InsertionSort.sort0(arr);
    //    for (int e : arr) System.out.print(e + " ");
    //    System.out.println();

    int[] dataSize = {10};
    for (int n : dataSize) {
      Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
      Integer[] arr2 = Arrays.copyOf(arr, arr.length);
      System.out.println(Arrays.toString(arr2));
      String classPath = InsertionSort.class.getCanonicalName();
      //      SortHelper.sortTest(classPath, arr, "sort");
      SortHelper.sortTest(classPath, arr2, "sort2");
      System.out.println(Arrays.toString(arr2));
    }
  }
}
