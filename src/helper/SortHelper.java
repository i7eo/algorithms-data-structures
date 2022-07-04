package helper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SortHelper {
  private SortHelper() {}

  public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1].compareTo(arr[i]) > 0) return false;
    }
    return true;
  }

  public static <T extends Comparable<T>> void sortTest(String name, T[] arr, String sortName) {
    long startTime = System.nanoTime();

    try {
      Class<?> SortClass = Class.forName(name);
      //      Arrays.stream(SortClass.getMethods())
      //          .forEach(
      //              method -> {
      //                System.out.println(method);
      //              });

      // 如果函数参数为泛型，则参数传入 Object 即可，因为泛型最终会被jvm类型剔除为Object 而 Object 是所有包装类、interface等的祖先
      Method sort = SortClass.getMethod(sortName, Comparable[].class);
      // method.invoke默认会隐式将传入的参数放在Object[]中的第一个元素，当传入的是数组时，编辑器认为所有参数在数组中了，
      // 不会再隐式包装，实际传入的参数不是数组，而是数组中的所有参数，所以需要手动new Object[],将数组对象放入
      sort.invoke(SortClass, new Object[] {arr});
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

    System.out.println(
        String.format("[%s, %s], n = %d, spends %fs", name, sortName, arr.length, time));
  }
}
