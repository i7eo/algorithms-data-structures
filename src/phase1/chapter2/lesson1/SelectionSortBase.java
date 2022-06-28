package phase1.chapter2.lesson1;

public class SelectionSortBase {
  private SelectionSortBase() {}

  private static void swap(int[] arr, int i, int j) {
    int t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
  }

  /** 选择排序 每次找到最小值进行交换 平均时间复杂度 O(n^2/2) 缺点：找这个操作进行了双for 优点：swap 是高效的，省了空间，原地排序 */
  public static void sort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      // 循环不变量为 arr[0...i) 始终是有序的，arr[i...n) 始终是无序的
      int minIdx = i;
      for (int j = i; j < arr.length; j++) {
        if (arr[j] < arr[minIdx]) {
          minIdx = j;
        }
      }
      swap(arr, i, minIdx);
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 4, 5, 6, 2, 3};
    SelectionSortBase.sort(arr);
    for (int e : arr) System.out.print(e + " ");
    System.out.println();
  }
}
