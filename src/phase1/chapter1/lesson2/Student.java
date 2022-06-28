package phase1.chapter1.lesson2;

public class Student {
  private final String name;

  public Student(String name) {
    this.name = name;
  }

  //  public boolean equals(Student student) {}  // 错的，要覆盖父类 Object 的 equals 方法需要参数类型也得一致

  @Override
  public boolean equals(Object student) {
    // 判空
    if (student == null) return false;
    // 是否为同一个类
    if (this.getClass() != student.getClass()) return false;
    // 地址是否一致
    if (this == student) return true;

    // 强制转换
    Student temp = (Student) student;
    return this.name.equals(temp.name);
  }
}
