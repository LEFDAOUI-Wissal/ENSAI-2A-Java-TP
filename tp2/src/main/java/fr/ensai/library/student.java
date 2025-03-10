import java.io.*;
import java.util.*;


class Student {
    private String name;
    private int age;
    private int academicYear;
    private boolean isClassDelegate;

    public Student(String name, int age, int academicYear, boolean isClassDelegate) {
        this.name = name;
        this.age = age;
        this.academicYear = academicYear;
        this.isClassDelegate = isClassDelegate;
    }

    @Override
    public String toString() {
        return name + " (Year " + academicYear + ")";
    }
}
