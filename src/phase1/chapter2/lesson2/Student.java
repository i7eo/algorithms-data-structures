package phase1.chapter2.lesson2;

public class Student implements Comparable<Student> {
  private final String name;
  private final int score;

  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }

  @Override
  public int compareTo(Student another) {
    //    if (this.score < another.score) return -1;
    //    if (this.score == another.score) return 0;
    //    return 1;
    return this.score - another.score;
  }

  @Override
  public boolean equals(Object student) {
    if (this == student) {
      return true;
    }

    if (student == null) {
      return false;
    }

    if (this.getClass() != student.getClass()) {
      return false;
    }

    Student another = (Student) student;
    return this.name.equals(another.name);
  }

  @Override
  public String toString() {
    // 格式化字符串，覆盖默认的toString
    return String.format("Student(name: %s, score: %d)", name, score);
    // 不覆盖的话打印出 phase1.chapter2.lesson2.Student@7d4991ad phase1.chapter2.lesson2.Student@28d93b30
    // phase1.chapter2.lesson2.Student@1b6d3586
    // 即 jvm 开辟的内存地址
  }
}
