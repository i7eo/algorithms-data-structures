package phase1.chapter2.lesson3;

public class InsertionSortBase {
  private InsertionSortBase() {}

  private static void swap(int[] arr, int i, int j) {
    int t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
  }

  public static void sort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int swapIdx = i;
      for (int j = i - 1; j > -1; j--) {
        if (arr[swapIdx] < arr[j]) {
          swap(arr, j, swapIdx);
          swapIdx = j;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 4, 5, 6, 2, 3};
    InsertionSortBase.sort(arr);
    for (int e : arr) System.out.print(e + " ");
    System.out.println();
  }
}
