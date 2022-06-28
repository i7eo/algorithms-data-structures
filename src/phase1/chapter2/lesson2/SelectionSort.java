package phase1.chapter2.lesson2;

public class SelectionSort {
  private SelectionSort() {}

  public static <T> void swap(T[] arr, int i, int j) {
    T t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
  }

  // 扩展泛型，表示传入的类型必须能实现 Comparable（比较接口）
  public static <T extends Comparable<T>> void sort(T[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int minIdx = i;
      for (int j = i; j < arr.length; j++) {
        if (arr[j].compareTo(arr[minIdx]) < 0) {
          minIdx = j;
        }
      }
      swap(arr, i, minIdx);
    }
  }

  public static void main(String[] args) {
    //    int[] arr = { 1,4,2,3,6,5 };
    //    SelectionSort.sort(arr); // no instance(s) of type variable(s) T exist so that int[]
    // conforms to T[]

    // java 中使用泛型时，不能将基本类型传入泛型，必须使用类型

    Integer[] arr = {1, 4, 2, 3, 6, 5};
    SelectionSort.sort(arr);
    for (int e : arr) {
      System.out.print(e + " ");
    }
    System.out.println();

    Student[] students = {
      new Student("Alice", 98), new Student("i7eo", 95), new Student("Eva", 100),
    };
    SelectionSort.sort(students);
    for (Student student : students) System.out.print(student + " ");
    System.out.println();
  }
}
