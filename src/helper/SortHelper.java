package helper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class SortHelper {
  private SortHelper() {}

  public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1].compareTo(arr[i]) > 0) return false;
    }
    return true;
  }

  public static <T extends Comparable<T>> void sortTest(String name, T[] arr) {
    long startTime = System.nanoTime();

    try {
      Class<?> SortClass = Class.forName(name);
      Arrays.stream(SortClass.getMethods())
          .forEach(
              method -> {
                System.out.println(method);
              });

      Method sort = SortClass.getMethod("sort", Comparable[].class);
      System.out.println(sort);
      sort.invoke(SortClass, arr);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }

    //    switch (name) {
    //      case "SelectionSort":
    //        SelectionSort.sort(arr);
    //        break;
    //      default:
    //        System.out.println("Not matched");
    //        break;
    //    }

    long endTime = System.nanoTime();

    double time = (endTime - startTime) / 1000000000.0;

    if (!SortHelper.isSorted(arr)) throw new RuntimeException("SelectionSort failed.");

    System.out.println(String.format("[%s], n = %d, spends %fs", name, arr.length, time));
  }
}
